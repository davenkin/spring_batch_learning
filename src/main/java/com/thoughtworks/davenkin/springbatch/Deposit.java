package com.thoughtworks.davenkin.springbatch;

import java.sql.Timestamp;

public class Deposit
{
    private int deposit_id;
    private double deposit_amount;
    private Timestamp timestamp;

    public Deposit(int deposit_id, double deposit_amount, Timestamp timestamp)
    {

        this.deposit_id = deposit_id;
        this.deposit_amount = deposit_amount;
        this.timestamp = timestamp;
    }

    public void printInfo()
    {
        System.out.println(deposit_id + " " + deposit_amount + " " + timestamp);
    }
}
