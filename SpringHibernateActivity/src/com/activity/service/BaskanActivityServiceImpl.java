package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activity.dao.BaskanActivityDAO;
import com.activity.model.Baskan;


@Service("baskanService")
public class BaskanActivityServiceImpl implements BaskanActivityService {

	@Autowired
	private BaskanActivityDAO baskanActivityDAO;
	

	@Override
	@Transactional
	public void addBaskan(Baskan baskan) {
		
		baskanActivityDAO.addBaskan(baskan);
		
	}

	
	@Override
	@Transactional
	public List<Baskan> getBaskanlar() {
		
		return baskanActivityDAO.getBaskanlar();
	}

	@Override
	@Transactional
	public Baskan getBaskan(int baskanId) {
		
		return baskanActivityDAO.getBaskan(baskanId);
	}

	@Override
	@Transactional
	public void deleteBaskan(int baskanId) {
		
		baskanActivityDAO.deleteBaskan(baskanId);
		
	}



}
