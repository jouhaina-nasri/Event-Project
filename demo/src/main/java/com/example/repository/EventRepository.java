package com.example.repository;

import java.util.List;

import com.example.entity.Event;

public interface EventRepository {

	public void save(Event event);
	public List<Event> findAll(); 
	public boolean findbyID(String id_event);
	public void deleteAll();
	public void deletebyID(String id_event);
	
	
	

}
