package com.thoughtworks.davenkin.springbatch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class InventoryWriter implements ItemWriter<Inventory>
{
    private JdbcTemplate jdbcTemplate;

    public void write(List<? extends Inventory> inventories) throws Exception
    {
        Inventory inventory = inventories.get(0);

        String sql = "INSERT INTO INVENTORY " +
                "(TOTAL_DEPOSIT_AMOUNT, TOTAL_WITHDRAW_TIME, TOTAL_INCOME, DUE_TIME) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, inventory.createPrepareStatementSetter());

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
}
