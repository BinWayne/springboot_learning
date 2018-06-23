package com.ibm.dsw.pricepub.admin.util;

import org.junit.Assert;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


public class DateUtilTest extends AbstractTestNGSpringContextTests {



    @Test
    public void test(){
        String startDate = "2018-06-21 02:15:00.0";
        int value = DateUtil.getYear(startDate);
        Assert.assertEquals(2018,value);
        value = DateUtil.getMonth(startDate);
        Assert.assertEquals(06,value);
         value = DateUtil.getDay(startDate);
        Assert.assertEquals(21,value);
         value = DateUtil.getHour(startDate);
        Assert.assertEquals(02,value);
         value = DateUtil.getMin(startDate);
        Assert.assertEquals(15,value);
         value = DateUtil.getSec(startDate);
        Assert.assertEquals(0,value);

    }
}
