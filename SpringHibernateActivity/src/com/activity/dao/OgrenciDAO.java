package com.activity.dao;

import java.util.List;

import com.activity.model.Etkinlik;
import com.activity.model.Ogrenci;

public interface OgrenciDAO {

	public void addOgrenci(Ogrenci ogrenci,Etkinlik etkinlik);
	
	public List<Ogrenci> getOgrenciler();
	
	public Ogrenci getOgrenci(int id);
	
	public void deleteOgrenci(int id);
	
}
