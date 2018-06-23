package com.ibm.dsw.pricepub.admin.dao;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


import java.sql.SQLException;

@SpringBootTest
public class DataSourceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    ApplicationContext applicationContext;


    @Test
    public void testDataSourceProp() throws SQLException {
        BasicDataSource dataSource  = applicationContext.getBean(BasicDataSource.class);
        //BasicDataSource basicDataSource = (BasicDataSource) applicationContext.getBean("dataSource");

        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSourceProperties);

//
        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getUsername());
        System.out.println(dataSource.getPassword());
        dataSource.getConnection();



    }
}
