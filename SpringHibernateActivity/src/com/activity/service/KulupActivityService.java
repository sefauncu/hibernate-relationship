package com.activity.service;

import java.util.List;

import com.activity.model.Baskan;
import com.activity.model.Kulup;

public interface KulupActivityService {

	
	public void addKulup(Kulup kulup,Baskan baskan);
	
	public List<Kulup> getKulupler();
	
	public Kulup getKulup(int kulupId);
	
	public void deleteKulup(int kulupId);
	
}
