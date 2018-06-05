package com.activity.dao;

import java.util.List;

import com.activity.model.Baskan;

public interface BaskanActivityDAO {
	
	public void addBaskan(Baskan baskan);
	
	public List<Baskan> getBaskanlar();
	
	public Baskan getBaskan(int baskanId);
	
	public void deleteBaskan(int baskanId);

}
