package com.thoughtworks.davenkin.springbatch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class PrintItemWriter implements ItemWriter<Deposit>
{
    public void write(List<? extends Deposit> deposits) throws Exception
    {
        for (Deposit deposit : deposits)
        {
            deposit.printInfo();
        }
    }
}
