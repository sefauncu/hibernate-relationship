package com.activity.service;

import java.util.List;

import com.activity.model.Etkinlik;
import com.activity.model.Ogrenci;

public interface OgrenciService {

	
	public void addOgrenci(Ogrenci ogrenci,Etkinlik etkinlik);
	
	public List<Ogrenci> getOgrenciler();
	
	public Ogrenci getOgrenci(int id);
	
	public void deleteOgrenci(int id);
}
