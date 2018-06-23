package com.ibm.dsw.pricepub.admin.dao;

import com.ibm.dsw.pricepub.admin.entity.JobTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class JobDaoImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private JobDao jobDao;



    @Test
    public void testAddJob() throws Exception {
        JobTask jobTask = new JobTask();
        jobTask.setJobTitle("job");
        jobTask.setFileCfgIDs("4");

        jobTask.setJobDtl(1);
        jobTask.setJobFail(0);
        jobTask.setJobSucc(1);
        jobTask.setJobFreq("W");
        jobTask.setStartDate("2018-06-28");
        jobTask.setEndDate("2018-06-28");
        jobTask.setAddByUserName("tonySSSsss");
        jobTask.setModByUserName("tonySSSsss");
        jobTask.setInactFlag(0);
        int value = jobDao.addJob(jobTask);

        System.out.println(value);

//TODO: Test goes here...
    }

    @Test
    public void testUpdateJob(){
        JobTask jobTask = new JobTask();
        jobTask.setJobTitle("jobtitle");
        jobTask.setFileCfgIDs("file_config_id");
        jobTask.setInactFlag(1);
        jobTask.setJobDtl(1);
        jobTask.setJobFail(0);
        jobTask.setJobSucc(1);
        jobTask.setJobFreq("W");
        jobTask.setStartDate("2018-06-08");
        jobTask.setEndDate("2018-06-08");
        jobTask.setAddByUserName("tony");
        jobTask.setJobID(1327);
        int id = jobDao.updateJob(jobTask);
        System.out.println(id+"****");
    }

}
