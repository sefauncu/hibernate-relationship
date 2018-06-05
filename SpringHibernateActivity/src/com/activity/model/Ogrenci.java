package com.activity.model;

import javax.persistence.Table;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "ogrenci")
public class Ogrenci {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "mail")
	private String mail;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "etkinlik_ogrenci", joinColumns = @JoinColumn(name = "ogrenci_id"), inverseJoinColumns = @JoinColumn(name = "etkinlik_id"))
	private List<Etkinlik> etkinliks;

	public List<Etkinlik> getEtkinliks() {
		return etkinliks;
	}

	public void setEtkinliks(List<Etkinlik> etkinliks) {
		this.etkinliks = etkinliks;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Ogrenci(String name, String mail) {
		super();
		this.name = name;
		this.mail = mail;
	}

	public Ogrenci() {
		super();
	}

}
