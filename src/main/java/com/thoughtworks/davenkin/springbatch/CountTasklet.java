package com.thoughtworks.davenkin.springbatch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 5/4/13
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class CountTasklet implements Tasklet {
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        Collection<StepExecution> stepExecutions = chunkContext.getStepContext().getStepExecution().getJobExecution().getStepExecutions();
        StepExecution stepExecution1=null;
        for (StepExecution stepExecution : stepExecutions) {
            if (stepExecution.getStepName().equals("simpleTaskletStep")) {
                stepExecution1 = stepExecution;
                break;
            }
        }
        assert stepExecution1 != null;
        System.out.println("job finished at: "+stepExecution1.getEndTime().toString());
        System.out.println("successful record number: "+ stepExecution1.getWriteCount());
        System.out.println("unsuccessful record number: "+ (stepExecution1.getReadSkipCount()+stepExecution1.getWriteSkipCount()));
      return RepeatStatus.FINISHED;
    }
}
