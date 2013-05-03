package com.thoughtworks.davenkin.springbatch;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 5/3/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyException extends RuntimeException {
    public MyException(String msg) {
        super(msg);
    }
}
