package com.thoughtworks.davenkin.springbatch;

import org.springframework.batch.item.ItemReader;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;

public class InventoryReader implements ItemReader<Inventory>
{
    private JdbcTemplate jdbcTemplate;
    private static int index;

    public Inventory read() throws Exception
    {
        Double deposit = jdbcTemplate.queryForObject("select sum(deposit_amount) from deposit", Double.class);
        Double withdraw = jdbcTemplate.queryForObject("select sum(withdraw_amount) from withdraw", Double.class);
        if(index++ > 0)
            return null;
        return new Inventory(deposit, withdraw, new Timestamp(System.currentTimeMillis()));
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
}
