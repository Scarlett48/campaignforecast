package com.example.SpringBootDemo.connectionJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    public List<Campaign> getAllCampaigns(){
    List<Campaign> campaigns = new ArrayList<>();
    campaignRepository.findAll().forEach(campaigns::add);
    return campaigns;
    }

    public void addCampaign(Campaign campaign){
        campaignRepository.save(campaign);
    }

}
