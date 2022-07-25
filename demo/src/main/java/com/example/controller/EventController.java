package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Event;
import com.example.repository.EventRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 
@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Event Entity!!!!")
@RestController
public class EventController{
	
	@Autowired
	EventRepository eventRepository;
	
	@ApiOperation(value = "Save Event in the System ", response = Iterable.class, tags = "SaveEvents")
	  @ApiResponses(value = { 
	      @ApiResponse(code = 200, message = "Suceess|OK"),
	      @ApiResponse(code = 401, message = "not authorized!"), 
	      @ApiResponse(code = 403, message = "forbidden!!!"),
	      @ApiResponse(code = 404, message = "not found!!!") })
	 
	@PostMapping(value = "/save")
	public void save(@RequestBody Event client){
		eventRepository.save(client);
	}
	
	@ApiOperation(value = "Get list of Event in the System ", response = Iterable.class, tags = "findAllEvents")
	  @ApiResponses(value = { 
	      @ApiResponse(code = 200, message = "Suceess|OK"),
	      @ApiResponse(code = 401, message = "not authorized!"), 
	      @ApiResponse(code = 403, message = "forbidden!!!"),
	      @ApiResponse(code = 404, message = "not found!!!") })
	 
	@GetMapping(value = "/findAllEvents")
    public List<Event> findAll(){
		return eventRepository.findAll();
	}
	
	@ApiOperation(value = "Find Event By ID in the System ", response = Iterable.class, tags = "FindEventById")
	  @ApiResponses(value = { 
	      @ApiResponse(code = 200, message = "Suceess|OK"),
	      @ApiResponse(code = 401, message = "not authorized!"), 
	      @ApiResponse(code = 403, message = "forbidden!!!"),
	      @ApiResponse(code = 404, message = "not found!!!") })
	 
	@GetMapping(value = "/findbyID/{id}")
	public boolean FindByID(@PathVariable("id") String ID){
		return eventRepository.findbyID(ID);
	}
	
	@ApiOperation(value = "Delete Event by id in the System ", response = Iterable.class, tags = "DeleteById")
	  @ApiResponses(value = { 
	      @ApiResponse(code = 200, message = "Suceess|OK"),
	      @ApiResponse(code = 401, message = "not authorized!"), 
	      @ApiResponse(code = 403, message = "forbidden!!!"),
	      @ApiResponse(code = 404, message = "not found!!!") })
	 
	@DeleteMapping(value = "/delete/{id}")
	public void DeleteByID(@PathVariable("id") String ID){
		eventRepository.deletebyID(ID);
	}
	
	@ApiOperation(value = "Delete All Events in the System ", response = Iterable.class, tags = "DeleteAllEvents")
	  @ApiResponses(value = { 
	      @ApiResponse(code = 200, message = "Suceess|OK"),
	      @ApiResponse(code = 401, message = "not authorized!"), 
	      @ApiResponse(code = 403, message = "forbidden!!!"),
	      @ApiResponse(code = 404, message = "not found!!!") })
	 
	@DeleteMapping(value = "/delete")
	public void DeleteAll(){
		eventRepository.deleteAll();
	}
	
	

	
}
