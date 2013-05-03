package com.thoughtworks.davenkin.springbatch;

import org.springframework.batch.item.ItemWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 5/3/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonDelegateWriter implements ItemWriter<Person> {
    private ItemWriter<Person> delegate;
    public void write(List<? extends Person> persons) throws Exception {
        for (Person person : persons) {
            if(person.getId()==4){
                throw new RuntimeException("writer exception");
            }
            ArrayList<Person> persons1 = new ArrayList<Person>();
            persons1.add(person)     ;
            delegate.write(persons1);
        }
    }

    public void setDelegate(ItemWriter<Person> delegate) {
        this.delegate = delegate;
    }
}
