package com.activity.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="baskan")
public class Baskan implements Serializable {

	 private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="baskanId")
	private int baskanId;
	@Column(name="baskanAdSoyad")
	private String baskanAdSoyad;
	@Column(name="baskanTelefon")
	private String baskanTelefon;
	@Column(name="baskanMail")
	private String baskanMail;
	
	@OneToOne(mappedBy="baskan", 
			cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
						CascadeType.REFRESH})
	private Kulup kulup;
	
	public Kulup getKulup() {
		return kulup;
	}
	public void setKulup(Kulup kulup) {
		this.kulup = kulup;
	}
	public int getBaskanId() {
		return baskanId;
	}
	public void setBaskanId(int baskanId) {
		this.baskanId = baskanId;
	}
	public String getBaskanAdSoyad() {
		return baskanAdSoyad;
	}
	public void setBaskanAdSoyad(String baskanAdSoyad) {
		this.baskanAdSoyad = baskanAdSoyad;
	}
	public String getBaskanTelefon() {
		return baskanTelefon;
	}
	public void setBaskanTelefon(String baskanTelefon) {
		this.baskanTelefon = baskanTelefon;
	}
	public String getBaskanMail() {
		return baskanMail;
	}
	public void setBaskanMail(String baskanMail) {
		this.baskanMail = baskanMail;
	}
	public Baskan(String baskanAdSoyad, String baskanTelefon, String baskanMail) {
		super();
		this.baskanAdSoyad = baskanAdSoyad;
		this.baskanTelefon = baskanTelefon;
		this.baskanMail = baskanMail;
	}
	public Baskan() {
		super();
	}
	
}
