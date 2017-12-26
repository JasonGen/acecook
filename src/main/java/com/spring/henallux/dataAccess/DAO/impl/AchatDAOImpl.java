package com.spring.henallux.dataAccess.DAO.impl;

import com.spring.henallux.dataAccess.Entity.AchatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.DAO.AchatDAO;
import com.spring.henallux.dataAccess.repository.RepositoryAchat;
import com.spring.henallux.dataAccess.repository.RepositoryClient;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.AchatModel;
import com.spring.henallux.model.ClientModel;

@Service
public class AchatDAOImpl implements AchatDAO{

	@Autowired
	private RepositoryAchat repositoryAchat;
	@Autowired
	private ProviderConverter providerConverter;

	@Override
	public AchatModel find(Integer id) {

		return providerConverter.achatEntityToModel(repositoryAchat.findOne(id));
	}

	@Override
	public AchatEntity save(AchatModel achatModel) {
		return repositoryAchat.save(providerConverter.achatModelToEntity(achatModel));
	}



}
