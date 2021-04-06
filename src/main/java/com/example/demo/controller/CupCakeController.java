package com.example.demo.controller;

import com.example.demo.model.CupCake;
import com.example.demo.DTO.CupCakeDto;
import com.example.demo.repo.CupCakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController()
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/")
public class CupCakeController {
    RestTemplate restTemplate=new RestTemplate();
    @Autowired
    private CupCakeRepo repo;
    /*we will return all the users for every 5 minutes which will be called by frontend*/
    @GetMapping("/testing")
    public List<CupCakeDto> userlists(){
        //String a=restTemplate.getForObject("http://localhost:7085/hi",String.class);
        //System.out.println(a);

        return repo.findChildren();
    }
    @PostMapping("/insert")
    public void insert(@RequestBody CupCakeDto dto){
        CupCake cake=new CupCake();
        cake.setCount(dto.getData());
        cake.setTime(dto.getTime());
        cake.setLastTouched(new Date());
        restTemplate.postForEntity("http://localhost:8081/insert",cake,Void.class);

    }
    @GetMapping("/delete")
    public void delete(@ModelAttribute("id") String id){
        Optional<CupCake> cake=repo.findById(id);
        restTemplate.postForEntity("http://localhost:8081/insert",cake.get(),Void.class);
    }

}
