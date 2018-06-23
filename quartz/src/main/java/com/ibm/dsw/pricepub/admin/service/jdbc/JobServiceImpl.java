package com.ibm.dsw.pricepub.admin.service.jdbc;


import com.ibm.dsw.pricepub.admin.config.JobErrorMessageConfig;
import com.ibm.dsw.pricepub.admin.core.quartz.QuartzJobTaskService;
import com.ibm.dsw.pricepub.admin.entity.JobTask;


import com.ibm.dsw.pricepub.admin.dao.JobDao;
import com.ibm.dsw.pricepub.admin.entity.ResponseMessage;
import com.ibm.dsw.pricepub.admin.mapper.JobTaskMapper;
import org.quartz.Job;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class JobServiceImpl implements  JobService{

    @Autowired
    private JobTaskMapper jobTaskMapper;

    @Autowired
    private JobErrorMessageConfig jobErrorMessageConfig;

    @Autowired
    private QuartzJobTaskService quartzJobTaskService;

    /**
     *     DECLARE ERR_MISSING_INPUT     INTEGER DEFAULT 34100;
     *     DECLARE ERR_GENERAL_SQL       INTEGER DEFAULT 1;
     *     DECLARE ERR_RECORD_EXISTS     INTEGER DEFAULT 4;
     *     DECLARE ERR_RECORD_NOT_EXISTS INTEGER DEFAULT 5;
     *     DECLARE ERR_ROW_NOT_FOUND     INTEGER DEFAULT 5000;
     * */
    @Override
    public ResponseMessage addJob(JobTask job) {
      // int value = jobTaskMapper.insert(job);

           boolean hasJob = quartzJobTaskService.checkJob(job);

           if(!hasJob){
               quartzJobTaskService.startJob(job);
           }

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setReturnCode(0);
//        switch (value){
//            case 0:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getSuccess());
//                break;
//            case 1:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getGeneralSql());
//                break;
//            case 2:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getTrapError());
//                break;
//            case 3:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getMissLLSP());
//                break;
//            case 4:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getRecordExists());
//                break;
//            case 5:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getMissingInput());
//                break;
//            case 5000:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getRowNotFound());
//                break;
//            case 34100:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getRecordExists());
//                break;
//            default:
//                responseMessage.setReturnMessage(jobErrorMessageConfig.getSuccess());
//                break;
//        }

        return responseMessage;
    }

    @Override
    public void selectAllJob() {

    }

    @Override
    public void updateJob(JobTask job) {

    }

    @Override
    public ResponseMessage deleteJob(JobTask job) {

        try {
            quartzJobTaskService.remove(job);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setReturnCode(0);
        return  responseMessage;
    }

    @Override
    public ResponseMessage pauseJob(JobTask job) {
        try {
            quartzJobTaskService.pause(job);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setReturnCode(0);
        return  responseMessage;
    }

    @Override
    public ResponseMessage resumeJob(JobTask job) {
        try {
            quartzJobTaskService.resume(job);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setReturnCode(0);
        return  responseMessage;
    }
}
