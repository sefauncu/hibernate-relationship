package com.activity.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="kulup")
public class Kulup {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kulupId")
	private int kulupId;
	@Column(name="kulupAd")
	private String kulupAd;
	@Column(name="kulupIcerik")
	private String kulupIcerik;
	@Column(name="kulupLogo")
	private String kulupLogo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="kulupBaskanID")
	private Baskan baskan;
	
	@OneToMany(mappedBy="kulup",
			cascade=CascadeType.ALL)
	private List<Etkinlik> etkinliks;
		
	public List<Etkinlik> getEtkinliks() {
		return etkinliks;
	}

	public void setEtkinliks(List<Etkinlik> etkinliks) {
		this.etkinliks = etkinliks;
	}

	public Baskan getBaskan() {
		return baskan;
	}

	public void setBaskan(Baskan baskan) {
		this.baskan = baskan;
	}
	
	public int getKulupId() {
		return kulupId;
	}
	public void setKulupId(int kulupId) {
		this.kulupId = kulupId;
	}
	public String getKulupAd() {
		return kulupAd;
	}
	public void setKulupAd(String kulupAd) {
		this.kulupAd = kulupAd;
	}
	public String getKulupIcerik() {
		return kulupIcerik;
	}
	public void setKulupIcerik(String kulupIcerik) {
		this.kulupIcerik = kulupIcerik;
	}
	public String getKulupLogo() {
		return kulupLogo;
	}
	public void setKulupLogo(String kulupLogo) {
		this.kulupLogo = kulupLogo;
	}
	public Kulup(String kulupAd, String kulupIcerik, String kulupLogo) {
		super();
		this.kulupAd = kulupAd;
		this.kulupIcerik = kulupIcerik;
		this.kulupLogo = kulupLogo;
	}
	public Kulup() {
		super();
	}
	
	public void addBaskan(Kulup kulup,Baskan baskan){		
		kulup.setBaskan(baskan);
		
	}
	
	
	/*
	   public void add(Etkinlik tempEtkinlik){
	 
		if(etkinliks ==  null){
			etkinliks = new ArrayList<>();
		}
		etkinliks.add(tempEtkinlik);
		tempEtkinlik.setKulup(this);
	}
	
	public void add(Etkinlik tempEtkinlik,Kulup kulup){
		if(etkinliks ==  null){
			etkinliks = new ArrayList<>();
		}
		etkinliks.add(tempEtkinlik);
		tempEtkinlik.setKulup(this);
	}
	*/



}
