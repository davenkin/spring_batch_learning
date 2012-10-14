package com.thoughtworks.davenkin.springbatch;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {
        "classpath:applicationContext.xml",
        "classpath:testContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleTaskletStepTest
{
    /** JobLauncherTestUtils Bean. */
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private DataSource dataSource;

    /** Launch Test. */
    @Test
    public void launchJob() throws Exception {
        // launch the job, the utils provide the job with a unique parameter
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        // assert job run status
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from BATCH_JOB_EXECUTION");
        while(resultSet.next())
        {
            String anInt = resultSet.getString(1);
            System.out.println(anInt);
            String str = resultSet.getString("START_TIME");
            System.out.println(str);

        }
    }
}
