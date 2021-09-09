package com.example.SpringBootDemo.connectionJpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {

}
