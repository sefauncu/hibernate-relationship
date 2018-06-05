package com.activity.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="etkinlik")
public class Etkinlik {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="content")
	private String content;
	@Column(name="address")
	private String address;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="kulup_id")
	private Kulup kulup;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="etkinlik_ogrenci",
			joinColumns=@JoinColumn(name="etkinlik_id"),
			inverseJoinColumns=@JoinColumn(name="ogrenci_id")
			)
	private List<Ogrenci> ogrencis;
		
	public List<Ogrenci> getOgrencis() {
		return ogrencis;
	}
	public void setOgrencis(List<Ogrenci> ogrencis) {
		this.ogrencis = ogrencis;
	}
	public Kulup getKulup() {
		return kulup;
	}
	public void setKulup(Kulup kulup) {
		this.kulup = kulup;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Etkinlik(String name, String content, String address) {
		super();
		this.name = name;
		this.content = content;
		this.address = address;
		
	}
	public Etkinlik() {
		super();
	}
	
	public void addKulup(Etkinlik etkinlik,Kulup kulup){		
		
		etkinlik.setKulup(kulup);
		
	}	
	
	
	public void addOgrenci(Ogrenci tempOgrenci) {
		
		if(ogrencis == null){
			ogrencis = new ArrayList<>();
		}
		
		ogrencis.add(tempOgrenci);
	}


}
