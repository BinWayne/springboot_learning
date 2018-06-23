package com.ibm.dsw.pricepub.admin.core.quartz;

import com.ibm.dsw.pricepub.admin.entity.JobTask;
import com.ibm.dsw.pricepub.admin.util.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.quartz.CalendarIntervalScheduleBuilder.calendarIntervalSchedule;


@Service
public class QuartzJobTaskService {

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    public boolean checkJob(JobTask job){
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);
        try {
            if(scheduler.checkExists(triggerKey)){
                return true;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean startJob(JobTask job) {

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobDetail jobDetail = null;
        try {
            Class clazz = Class.forName(job.getClazzPath());
            jobDetail  = JobBuilder.newJob(clazz).withIdentity(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP)
                    .build();

            // 触发器
            System.out.println("job key--->"+jobDetail.getKey());
            String startDate = job.getStartDate();

            TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);

            //
//  CronTrigger trigger1 = TriggerBuilder.newTrigger()
//                    .withIdentity(triggerKey)
//                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCron())).build();

           Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
                    .startAt(DateBuilder.dateOf(
                            DateUtil.getHour(startDate),
                            DateUtil.getMin(startDate),
                            DateUtil.getSec(startDate),
                            DateUtil.getDay(startDate),
                            DateUtil.getMonth(startDate),
                            DateUtil.getYear(startDate)))
                    .withSchedule(calendarIntervalSchedule().withMisfireHandlingInstructionDoNothing().withIntervalInSeconds(8)).build();
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
                System.out.println("---任务[" + triggerKey.getName() + "]启动成功-------");
                System.out.println("---任务开始时间[" + DateFormatUtils.format(trigger.getStartTime(),"yyyy-MM-dd HH:mm:ss")+ "]-------");

                return true;
            }else{
                System.out.println("---任务[" + triggerKey.getName() + "]已经运行，请勿再次启动-------");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }


    public boolean updateJob(JobTask job) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        String createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");

        TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);
        try {
            if (scheduler.checkExists(triggerKey)) {
                return false;
            }

            JobKey jobKey = JobKey.jobKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);
//
//            CronScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule(job.getCron())
//                    .withMisfireHandlingInstructionDoNothing();
//            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
//                    .withDescription(createTime).withSchedule(schedBuilder).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withDescription(createTime).startAt(DateBuilder.dateOf(10,0,0,6,6,2018))
                    .withSchedule(calendarIntervalSchedule().withIntervalInSeconds(10)).build();
            Class clazz = null;
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            HashSet<Trigger> triggerSet = new HashSet<>();
            triggerSet.add(trigger);
            scheduler.scheduleJob(jobDetail, triggerSet, true);
            System.out.println("---任务["+triggerKey.getName()+"]更新成功-------");
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean remove(JobTask job) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);

       // JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        try {
            if (checkJob(job)) {
                scheduler.pauseTrigger(triggerKey);
                scheduler.unscheduleJob(triggerKey);
                JobKey jobKey = JobKey.jobKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);
                scheduler.pauseJob(jobKey);

                //scheduler.deleteJob(JobKey.jobKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP));
                scheduler.interrupt(jobKey);
                System.out.println("---task[" + triggerKey.getName() + "]删除成功-------");
                return true;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean pause(JobTask job) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);

        if (checkJob(job)) {
           // scheduler.pauseTrigger(triggerKey);
           // scheduler.unscheduleJob(triggerKey);
            JobKey jobKey = JobKey.jobKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);
            scheduler.pauseJob(jobKey);

            System.out.println("---task[" + triggerKey.getName() + "]暂停成功-------");
                return true;
            }
        return false;
    }

    public boolean resume(JobTask job) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);

        if (checkJob(job)) {
            scheduler.resumeTrigger(triggerKey);
            JobKey jobKey = JobKey.jobKey(String.valueOf(job.getJobID()), Scheduler.DEFAULT_GROUP);
            scheduler.resumeJob(jobKey);
            System.out.println("---task[" + triggerKey.getName() + "]恢复成功-------");
            return true;

        }
        return false;
    }

}
