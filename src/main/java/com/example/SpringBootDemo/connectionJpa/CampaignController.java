package com.example.SpringBootDemo.connectionJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @RequestMapping("/campaigns")
    public List<Campaign> getCampaigns(){
        return campaignService.getAllCampaigns();
    }

    @PostMapping("/add")
    public void addCampaign(@RequestBody Campaign campaign){
        campaignService.addCampaign(campaign);
    }

}
