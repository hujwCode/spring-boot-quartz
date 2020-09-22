package com.example.springbootquartz.controller;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.GregorianCalendar;

/**
 * @author creator hujiawei 2020/9/22 11:03 下午
 * @author updater
 * @version 1.0.0
 */
public class HelloQuartz {
    public static void main(String[] args) throws SchedulerException {
        // 1.调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // 2.触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .endAt(new GregorianCalendar(2020, 9, 22, 11, 20).getTime())
                .build();
        // 3.jobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

        // 4. 将jobdetai和trigger增加到schuduler中
        scheduler.scheduleJob(jobDetail, trigger);

        // 5. 调度器开始工作
        scheduler.start();
    }
}
