package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activity.dao.KulupActivityDAO;
import com.activity.model.Baskan;
import com.activity.model.Kulup;

@Service("kulupService")
public class KulupActivityServiceImpl implements KulupActivityService {

	@Autowired
	private KulupActivityDAO kulupActivityDAO;
	


	@Override
	@Transactional
	public void addKulup(Kulup kulup,Baskan baskan) {
		
		kulupActivityDAO.addKulup(kulup,baskan);
		
	}

	@Override
	@Transactional
	public List<Kulup> getKulupler() {
	
		return kulupActivityDAO.getKulupler();
	}

	@Override
	@Transactional
	public Kulup getKulup(int kulupId) {
		
		return kulupActivityDAO.getKulup(kulupId);
	}

	@Override
	@Transactional
	public void deleteKulup(int kulupId) {
		
		kulupActivityDAO.deleteKulup(kulupId);
		
	}

}
