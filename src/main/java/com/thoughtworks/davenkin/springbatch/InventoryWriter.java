package com.thoughtworks.davenkin.springbatch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class InventoryWriter implements ItemWriter<Inventory>
{
    public void write(List<? extends Inventory> inventories) throws Exception
    {
    }
}
