package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activity.dao.OgrenciDAO;
import com.activity.model.Etkinlik;
import com.activity.model.Ogrenci;

@Service("ogrenciService")
public class OgrenciServiceImpl implements OgrenciService {

	@Autowired
	private OgrenciDAO ogrenciDAO;
	
	@Override
	@Transactional
	public void addOgrenci(Ogrenci ogrenci,Etkinlik etkinlik) {
		
		ogrenciDAO.addOgrenci(ogrenci,etkinlik);
		
	}

	@Override
	@Transactional
	public List<Ogrenci> getOgrenciler() {
		
		return ogrenciDAO.getOgrenciler();
	}

	@Override
	@Transactional
	public Ogrenci getOgrenci(int id) {
		
		return ogrenciDAO.getOgrenci(id);
	}

	@Override
	@Transactional
	public void deleteOgrenci(int id) {
		
		ogrenciDAO.deleteOgrenci(id);
		
	}

}
