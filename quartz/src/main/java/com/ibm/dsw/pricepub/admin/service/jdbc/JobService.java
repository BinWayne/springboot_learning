package com.ibm.dsw.pricepub.admin.service.jdbc;

import com.ibm.dsw.pricepub.admin.entity.JobTask;
import com.ibm.dsw.pricepub.admin.entity.ResponseMessage;
import org.springframework.stereotype.Component;

@Component
public interface JobService {
    public ResponseMessage addJob(JobTask job);
    public void selectAllJob();
    public void updateJob(JobTask job);
    public ResponseMessage pauseJob(JobTask job);
    public ResponseMessage resumeJob(JobTask job);
    public ResponseMessage deleteJob(JobTask jobTask);
}
