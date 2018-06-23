package com.ibm.dsw.pricepub.admin.core.quartz.customQuartz;

import org.quartz.*;


import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateFileJob implements InterruptableJob {

    private boolean _interrupted = false;
    private JobKey _jobKey = null;
    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println("\n—————— 【中断】外界正在调用调度器停止这个任务key：" + _jobKey + " ————————");
        _interrupted = true;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("job start =================== at "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        _jobKey = context.getJobDetail().getKey();
        System.out.println("[开始执行job]，任务key===>"+_jobKey);
        int i=1;
        while (true){
            System.out.println("执行 第"+i+"次");
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(_interrupted){
                System.out.println("被终止了~~~");
                return;
            }
            if(i==5) break;
        }
        System.out.println("JobDemo1：next execute time====="+
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                        .format(context.getNextFireTime())+"==============");
    }
}
