package com.spring.henallux.model;

public class MaterielModel {
	private Integer idMateriel;
	private String photo;
	private Double prix;
	private Integer quantiteStock;
	
	
	public Integer getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(Integer idMateriel) {
		this.idMateriel = idMateriel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Integer getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(Integer quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	
	
}
