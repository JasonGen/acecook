package com.spring.henallux.model;

import java.io.Serializable;
import java.util.Date;

import com.spring.henallux.dataAccess.Entity.ClientEntity;

public class AchatModel implements Serializable {
	private Integer numeroCommande;
	private Date dateAchat;
	private ClientModel client;
	
	public Integer getNumeroCommande() {
		return numeroCommande;
	}
	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public ClientModel getClient() {
		return client;
	}
	public void setClient(ClientModel client) {
		this.client = client;
	}


}
