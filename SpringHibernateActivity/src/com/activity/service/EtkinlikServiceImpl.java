package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activity.dao.EtkinlikDAO;
import com.activity.model.Etkinlik;
import com.activity.model.Kulup;

@Service("etkinlikService")
public class EtkinlikServiceImpl implements EtkinlikService {
	
	@Autowired
	private EtkinlikDAO etkinlikDAO;

	@Override
	@Transactional
	public void addEtkinlik(Etkinlik etkinlik,Kulup kulup) {
		
		etkinlikDAO.addEtkinlik(etkinlik,kulup);
		
	}

	@Override
	@Transactional
	public List<Etkinlik> getEtkinlikler() {
		
		return etkinlikDAO.getEtkinlikler();
	}

	@Override
	@Transactional
	public Etkinlik getEtkinlik(int id) {
		
		return etkinlikDAO.getEtkinlik(id);
	}

	@Override
	@Transactional
	public void deleteEtkinlik(int id) {
		
		etkinlikDAO.deleteEtkinlik(id);
		
	}

}
