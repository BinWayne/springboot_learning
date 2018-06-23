package com.ibm.dsw.pricepub.admin.dao;

import com.ibm.dsw.pricepub.admin.entity.JobTask;

import org.springframework.stereotype.Repository;

@Repository
public interface JobDao {
    public int addJob(JobTask job);
    public void selectAllJob();
    public int updateJob(JobTask job);
    public void deleteJob(int jobId);
}
