package com.ibm.dsw.pricepub.admin.mapper;


import com.ibm.dsw.pricepub.admin.entity.JobTask;
import org.quartz.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobTaskMapper {

    List<JobTask> selectList();

    int deleteByPrimaryKey(int id);

    int insert(JobTask record);

    int updateByPrimaryKey(JobTask record);

    JobTask selectByJobID(int jobID);
}
