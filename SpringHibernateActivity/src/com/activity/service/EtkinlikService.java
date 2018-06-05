package com.activity.service;

import java.util.List;

import com.activity.model.Etkinlik;
import com.activity.model.Kulup;

public interface EtkinlikService {


	public void addEtkinlik(Etkinlik etkinlik,Kulup kulup);
	
	public List<Etkinlik> getEtkinlikler();
	
	public Etkinlik getEtkinlik(int id);
	
	public void deleteEtkinlik(int id);
}
