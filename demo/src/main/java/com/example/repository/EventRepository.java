package com.example.repository;

import java.util.List;

import com.example.entity.Evenement;

public interface EventRepository {

	public void save(Evenement event);
	public List<Evenement> findAll(); 
	public boolean findbyID(String id_event);
	public void deleteAll();
	public void deletebyID(String id_event);
	
	
	

}
