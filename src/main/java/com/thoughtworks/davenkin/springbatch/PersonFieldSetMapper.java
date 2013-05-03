package com.thoughtworks.davenkin.springbatch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 5/3/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonFieldSetMapper implements FieldSetMapper<Person> {
    public Person mapFieldSet(FieldSet fieldSet) throws BindException {
        Person person = new Person();
        person.setId(fieldSet.readInt(0));
        person.setName(fieldSet.readString(1));
        return person;
    }
}
