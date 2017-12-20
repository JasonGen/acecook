package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.henallux.dataAccess.Entity.AchatEntity;
import com.spring.henallux.dataAccess.Entity.ClientEntity;

public interface RepositoryAchat extends JpaRepository<AchatEntity, Integer>{

}
