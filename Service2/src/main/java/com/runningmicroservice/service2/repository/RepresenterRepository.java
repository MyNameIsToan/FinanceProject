package com.runningmicroservice.service2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runningmicroservice.service2.entities.Representer;

public interface RepresenterRepository extends JpaRepository<Representer, Long>{

}
