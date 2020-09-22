package com.example.springbootquartz.controller;

import org.quartz.Calendar;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.Timestamp;

/**
 * @author creator hujiawei 2020/9/22 11:01 下午
 * @author updater
 * @version 1.0.0
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("第一个job"+ new Timestamp(System.currentTimeMillis()).getTime());
    }
}
