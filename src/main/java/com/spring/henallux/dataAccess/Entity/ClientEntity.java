package com.spring.henallux.dataAccess.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Null;

import com.spring.henallux.Service.CryptingPassword;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "client")
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Idclient")
	private Integer idClient;
	
	@Column(name = "Nom", length = 30)
	private String nom;
	
	@Column(name = "Prenom", length = 30)
	private String prenom;
	
	@Column(name = "Datenaiss")
	@Temporal(TemporalType.DATE)
	private Date dateNaiss;
	
	@Column(name = "Email", length = 50)
	private String email;
	
	@Column(name = "Numtel", length = 15)
	private String numTel;
	
	@Column(name = "Motdepasse", length = 255)
	private String motDePasse;
	
	@Column(name = "Adr_numerorue", length = 6)
	private String numeroRue;
	
	@Column(name = "Adr_rue", length = 30)
	private String rue;

	@Column(name = "Adr_ville", length = 30)
	private String ville;
	
	@Column(name = "Codepostal")
	private Integer codePostal;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private List<AchatEntity> achats;

	public Integer getIdClient() {
		return idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {

//		try {
//			cryptingPassword.cryptedPassword(motDePasse);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		this.motDePasse = motDePasse;
	}

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public List<AchatEntity> getAchats() {
		return achats;
	}

	public void setAchats(List<AchatEntity> achats) {
		this.achats = achats;
	}

	/*
	public List<AchatEntity> getListeAchats() {
		return listeAchats;
	}

	public void setListeAchats(List<AchatEntity> listeAchats) {
		this.listeAchats = listeAchats;
	}
	*/
	//@JoinColumn(name = "Numerocommande")
	//le many to one est en EAGER par défaut (fetch) attention
	
	
//GETTERS SETTERS
	
	

}
