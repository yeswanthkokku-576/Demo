package com.example.demo.utils;

import com.example.demo.repo.CupCakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.util.Date;

@Configuration
@EnableAsync
public class Scheduler{
    @Autowired
    private CupCakeRepo repo;
    /*Getting 50 randome records and updating with latest time stamp*/
    @Async
    @Scheduled(fixedRate = 300000)
    @Transactional
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        int x=repo.updateProfile(new Date());
    }

}