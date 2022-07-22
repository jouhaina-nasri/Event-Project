package com.example.configuration;

import org.influxdb.InfluxDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfluxDBDao {
	
	@Autowired
	private InfluxDB influxDB;
	
	
	private boolean isAvailable() {
		  try {
		    influxDB.ping();
		    return true;
		  } catch (Exception e) {
			  e.printStackTrace();
			  return false;
		  }
		}

}
