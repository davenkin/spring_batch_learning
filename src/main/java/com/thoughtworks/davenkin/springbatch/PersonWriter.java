package com.thoughtworks.davenkin.springbatch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 5/3/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonWriter implements ItemWriter<Person> {
    private JdbcTemplate jdbcTemplate;
    public void write(List<? extends Person> persons) throws Exception {
        for (Person person : persons) {
            if(person.getId()==4){
                throw new MyException("writer exception");
            }
            System.out.println(person.getId());
            System.out.println(person.getName());
            String sql = "INSERT INTO PERSON " +
                    "(ID,NAME) VALUES (?, ?)";

            jdbcTemplate.update(sql, person.createPrepareStatementSetter());
        }
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
