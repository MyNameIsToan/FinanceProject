package com.runningmicroservice.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runningmicroservice.service1.entities.AssetEntities;

public interface AssetRepository extends JpaRepository<AssetEntities, Long>{

}
