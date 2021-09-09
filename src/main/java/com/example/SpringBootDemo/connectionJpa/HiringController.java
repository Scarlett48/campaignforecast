package com.example.SpringBootDemo.connectionJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HiringController {

    @Autowired
    private HiringService hiringService;


    @RequestMapping("/hiringdetails")
    public List<HiringDetails> getdetails(){
        return hiringService.getHiringDetails();
    }

    @PostMapping("/addHiringDetails")
    public void addCampaign(@RequestBody HiringDetails details){
        hiringService.addDetails(details);
    }

}
