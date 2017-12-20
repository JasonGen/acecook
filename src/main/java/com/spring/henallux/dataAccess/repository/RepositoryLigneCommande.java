package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.henallux.dataAccess.Entity.ClientEntity;
import com.spring.henallux.dataAccess.Entity.LigneCommandeEntity;

public interface RepositoryLigneCommande extends JpaRepository<LigneCommandeEntity, Integer>{

}
