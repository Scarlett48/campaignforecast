package com.example.SpringBootDemo.connectionJpa;

import org.springframework.data.repository.CrudRepository;

public interface HiringRepository extends CrudRepository<HiringDetails, Long> {
}
