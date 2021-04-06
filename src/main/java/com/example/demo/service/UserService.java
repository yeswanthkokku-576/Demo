package com.example.demo.service;

import com.example.demo.model.CupCake;
import com.example.demo.repo.CupCakeRepo;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private CupCakeRepo repo;
    /*Here PostConstruct will be called when SPRING ioc container initializes all the beans*/
    @PostConstruct
    public void init() {
       if(repo.countUsers()==0){
           try {

               FileReader filereader = new FileReader("/Users/yeswanthkokku/Downloads/multiTimeline.csv");

               CSVReader csvReader = new CSVReaderBuilder(filereader)
                       .withSkipLines(1)
                       .build();
               List<String[]> allData = csvReader.readAll();
                CupCake user=new CupCake();
               // print Data
               for (int i=2;i<allData.size();i++) {
                  user.setTime(allData.get(i)[0]);
                  user.setCount(allData.get(i)[1]);
                  user.setLastTouched(new Date());
                  repo.save(user);
                   }


           }
           catch (Exception e) {
               e.printStackTrace();
           }
       }


    }
}
