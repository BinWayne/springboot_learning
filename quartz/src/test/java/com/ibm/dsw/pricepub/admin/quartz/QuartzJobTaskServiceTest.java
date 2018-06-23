package com.ibm.dsw.pricepub.admin.quartz;

import com.ibm.dsw.pricepub.admin.core.quartz.QuartzJobTaskService;
import com.ibm.dsw.pricepub.admin.entity.JobTask;
import com.ibm.dsw.pricepub.admin.mapper.JobTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class QuartzJobTaskServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    QuartzJobTaskService quartzJobTaskService;

    @Autowired
    JobTaskMapper jobTaskMapper;
    @Test
    public void testAddJob(){
       JobTask jobTask =  jobTaskMapper.selectByJobID(1327);
       jobTask.setClazzPath("com.ibm.dsw.pricepub.admin.core.quartz.customQuartz.GenerateFileJob");
       boolean flag = quartzJobTaskService.checkJob(jobTask);
       if(!flag){
           quartzJobTaskService.startJob(jobTask);

       }
    }
}
