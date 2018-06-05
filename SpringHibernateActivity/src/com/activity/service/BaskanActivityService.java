package com.activity.service;

import java.util.List;

import com.activity.model.Baskan;

public interface BaskanActivityService {

	
    public void addBaskan(Baskan baskan);
	
	public List<Baskan> getBaskanlar();
	
	public Baskan getBaskan(int baskanId);
	
	public void deleteBaskan(int baskanId);
}
