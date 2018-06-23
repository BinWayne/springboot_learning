package com.ibm.dsw.pricepub.admin.controller;

import com.ibm.dsw.pricepub.admin.entity.JobTask;
import com.ibm.dsw.pricepub.admin.entity.ResponseMessage;
import com.ibm.dsw.pricepub.admin.mapper.JobTaskMapper;
import com.ibm.dsw.pricepub.admin.service.jdbc.JobService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {


    @Autowired
    private JobService jobService;

    //test
    @Autowired
    private JobTaskMapper jobTaskMapper;

    @ApiOperation(value = "/addJob", httpMethod = "POST", notes = "添加任务类")
    @RequestMapping(value = "/addJob",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseMessage addJob(@RequestBody JobTask jobTask){
        //test;
        jobTask = jobTaskMapper.selectByJobID(1327);
        jobTask.setClazzPath("com.ibm.dsw.pricepub.admin.core.quartz.customQuartz.GenerateFileJob");
        ResponseMessage responseMessage= jobService.addJob(jobTask);
        return responseMessage;

    }

    public void editJob(){

    }

    @RequestMapping(value = "/cancelJob/{jobKey}",method = RequestMethod.GET)
    public ResponseMessage deleteJob(@PathVariable Integer jobKey){
        JobTask jobTask = jobTaskMapper.selectByJobID(1327);

        jobTask.setClazzPath("com.ibm.dsw.pricepub.admin.core.quartz.customQuartz.GenerateFileJob");
        ResponseMessage responseMessage= jobService.deleteJob(jobTask);
        return responseMessage;
    }

    @RequestMapping(value = "/pause/{jobKey}",method = RequestMethod.GET)
    public void pauseJob(@PathVariable Integer jobKey){
        JobTask jobTask = jobTaskMapper.selectByJobID(1327);
        jobTask.setClazzPath("com.ibm.dsw.pricepub.admin.core.quartz.customQuartz.GenerateFileJob");
        ResponseMessage responseMessage= jobService.pauseJob(jobTask);

    }
    @RequestMapping(value = "/resume/{jobKey}",method = RequestMethod.GET)
    public void resumeJob(){
        JobTask jobTask = jobTaskMapper.selectByJobID(1327);
        jobTask.setClazzPath("com.ibm.dsw.pricepub.admin.core.quartz.customQuartz.GenerateFileJob");
        ResponseMessage responseMessage= jobService.resumeJob(jobTask);

    }
}
