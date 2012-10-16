package com.thoughtworks.davenkin.springbatch;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PrintItemMapper implements RowMapper
{
    public Object mapRow(ResultSet resultSet, int i) throws SQLException
    {
        int deposit_id = resultSet.getInt("DEPOSIT_ID");
        double deposit_amount = resultSet.getDouble("DEPOSIT_AMOUNT");
        Timestamp timestamp = resultSet.getTimestamp("DEPOSIT_TIME");
        return new Deposit(deposit_id, deposit_amount, timestamp);
    }
}
