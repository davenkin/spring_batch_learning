package com.thoughtworks.davenkin.springbatch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SimpleTaskletStepTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final Tasklet tasklet = new SimpleTaskletStep();

    @Test
    public void testExecute() throws Exception
    {
        assertEquals(RepeatStatus.FINISHED, tasklet.execute(null, null));
        assertEquals("Hello World!", outContent.toString());
    }

    @Before
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams()
    {
        System.setOut(null);
    }
}
