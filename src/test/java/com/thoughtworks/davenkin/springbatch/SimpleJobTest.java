package com.thoughtworks.davenkin.springbatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {
        "classpath:skipItemJobContext.xml",
        "classpath:testContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleJobTest
{
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Job simpleTaskletStepJob;

    @Autowired
    private JobLauncher jobLauncher;

    @Test
    public void launchJob() throws Exception
    {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

    @Test
    public void testJobByParameter() throws Exception
    {
        HashMap<String, JobParameter> parameters = new HashMap<String, JobParameter>();
//        parameters.put("myParameter", new JobParameter("parameter1"));
        parameters.put("myParameter", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(parameters);
        jobLauncher.run(simpleTaskletStepJob, jobParameters);

    }
}
