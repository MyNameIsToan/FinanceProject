package com.runningmicroservice.service1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.runningmicroservice.service1.entities.AssetEntities;
import com.runningmicroservice.service1.repository.AssetRepository;
import com.runningmicroservice.service1.service.IAssetService;

public class AssetService implements IAssetService{
	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public List<AssetEntities> GetAll() {
		return assetRepository.findAll();
	}

	@Override
	public AssetEntities CreateAsset(AssetEntities model) {
		AssetEntities asset = new AssetEntities();
		asset.setNameEng(model.getNameEng());
		asset.setNameVie(model.getNameVie());
		asset.setQuantity(model.getQuantity());
		asset.setParentId(model.getParentId());
		asset.setStatus(true);
		assetRepository.save(asset);
		return asset;
	}

	@Override
	public AssetEntities UpdateAsset(AssetEntities model) {
		AssetEntities asset = assetRepository.getOne(model.getAssetId());
		if(asset != null)
		{
			asset.setNameEng(model.getNameEng());
			asset.setNameVie(model.getNameVie());
			asset.setQuantity(model.getQuantity());
			asset.setParentId(model.getParentId());
			asset.setStatus(true);
			assetRepository.save(asset);
			return asset;
		}
		return null;
	}

	@Override
	public void DeleteAsset(Long id) {
		assetRepository.deleteById(id);
	}

}
