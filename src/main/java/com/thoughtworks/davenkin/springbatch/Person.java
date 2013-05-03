package com.thoughtworks.davenkin.springbatch;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 5/3/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object[] createPrepareStatementSetter()
    {
        return new Object[]{id,name};
    }
}
