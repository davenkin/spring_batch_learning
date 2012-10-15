package com.thoughtworks.davenkin.springbatch;

import java.sql.Timestamp;

public class Inventory
{
    private Double deposit;
    private Double withdraw;
    private Timestamp timestamp;

    public Inventory(Double deposit, Double withdraw, Timestamp timestamp)
    {
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.timestamp = timestamp;
    }
}
