package com.ibm.dsw.pricepub.admin.dao;

import com.ibm.dsw.pricepub.admin.entity.JobTask;
import com.ibm.dsw.pricepub.admin.mapper.JobTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

@SpringBootTest
public class JobTaskMapperTest extends AbstractTestNGSpringContextTests {


    @Autowired
    JobTaskMapper jobTaskMapper;
    @Test
    public void testSelectList(){
        List<JobTask> list = jobTaskMapper.selectList();
        Assert.assertEquals(4,list.size());
    }

    @Test
    public void testDelete(){
        int value = jobTaskMapper.deleteByPrimaryKey(1349);
        System.out.println(value+"******");
    }
    @Test
    public void testUpdate(){
        JobTask jobTask = new JobTask();
        jobTask.setInactFlag(1);
        jobTask.setJobID(1327);
        jobTaskMapper.updateByPrimaryKey(jobTask);
    }

    @Test
    public void testInsert(){
        JobTask jobTask = new JobTask();

        jobTask.setJobTitle("jobss");
        jobTask.setJobDtl(0);
        jobTask.setJobFail(0);
        jobTask.setJobSucc(1);
        jobTask.setJobFreq("W");
        jobTask.setStartDate("2018-06-28");
        jobTask.setEndDate("2018-06-28");
        jobTask.setAddByUserName("tonySSSsdss");
        jobTask.setModByUserName("tonySSSdsss");
        jobTask.setInactFlag(0);
        jobTask.setDeleteFlag(0);
        jobTask.setAddDate("2018-06-28");
        jobTask.setModDate("2018-06-28");

        int value = jobTaskMapper.insert(jobTask);
        System.out.println(value+"*****");

    }

    @Test
    public void testSelectByJobID(){

        JobTask jobTask = jobTaskMapper.selectByJobID(1327);
        System.out.println("========="+jobTask.getStartDate());
        Assert.assertEquals("TonyTest",jobTask.getJobTitle());
    }
}
