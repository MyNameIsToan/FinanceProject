package com.runningmicroservice.service1.service;

import java.util.List;

import com.runningmicroservice.service1.entities.AssetEntities;

public interface IAssetService {
	List<AssetEntities> GetAll();
	AssetEntities CreateAsset(AssetEntities model);
	AssetEntities UpdateAsset(AssetEntities model);
	void DeleteAsset(Long id);
}
