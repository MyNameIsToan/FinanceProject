package com.runningmicroservice.service2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runningmicroservice.service2.entities.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long>{

}
