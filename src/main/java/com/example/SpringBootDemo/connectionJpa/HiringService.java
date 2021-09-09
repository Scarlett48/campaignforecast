package com.example.SpringBootDemo.connectionJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HiringService {
    @Autowired
    private HiringRepository hiringRepository;

    public List<HiringDetails> getHiringDetails(){
        List<HiringDetails> details = new ArrayList<>();
        hiringRepository.findAll().forEach(details::add);
        return details;
    }

    public void addDetails(HiringDetails details){
        hiringRepository.save(details);
    }

}
