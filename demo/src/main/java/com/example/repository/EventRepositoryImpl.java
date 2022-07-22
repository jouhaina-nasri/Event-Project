package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.entity.Evenement;


@Component
public class EventRepositoryImpl implements EventRepository{

		@Autowired
	    private InfluxDB influxDB;
		
		@Override
		public void save(Evenement event) 
		{
			Point point = Point
                    .measurement("evenement")
                    .time(System.currentTimeMillis(), TimeUnit.MICROSECONDS)
                    .tag("ID",event.getId())
                    .addField("event_timestamp", event.getEvent_timestamp())
                    .addField("event_type", event.getEvent_type())
                    .addField("page_url", event.getPage_url())
                    .addField("page_url_path", event.getPage_url_path())
                    .addField("referer_url", event.getReferer_url())
                    .addField("referer_url_scheme", event.getReferer_url_scheme())
                    .addField("referer_url_port", event.getReferer_url_port())
                    .addField("referer_medium", event.getReferer_medium())
                    .addField("utm_medium", event.getUtm_medium())
                    .addField("utm_source", event.getUtm_source())
                    .addField("utm_content", event.getUtm_content())
                    .addField("utm_campaign", event.getUtm_campaign())
                    .addField("click_id", event.getClick_id())
                    .addField("geo_latitude", event.getGeo_latitude())
                    .addField("geo_longitude", event.getGeo_longitude())
                    .addField("geo_country", event.getGeo_country())
                    .addField("geo_timezone", event.getGeo_timezone())
                    .addField("geo_region_name", event.getGeo_region_name())
                    .addField("ip_address", event.getIp_address())
                    .addField("browser_name", event.getBrowser_name())
                    .addField("browser_user_agent", event.getBrowser_user_agent())
                    .addField("browser_language", event.getBrowser_language())
                    .addField("os", event.getOs())
                    .addField("os_name", event.getOs_name())
                    .addField("os_timezone", event.getOs_timezone())
                    .addField("device_type", event.getDevice_type())
                    .addField("device_is_mobile", event.getDevice_is_mobile())
                    .build();
			influxDB.write(point);
		}

		@Override
		public List<Evenement> findAll() {
			List<Evenement> result = new ArrayList<Evenement>();
	        Query query = new Query("SELECT * FROM evenement");
	        QueryResult queryResult = influxDB.query(query);
	        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
	        result = resultMapper.toPOJO(queryResult, Evenement.class);
			return result;
		}

		@Override
		public void deleteAll() {
			 Query query = new Query("drop measurement evenement");
		     QueryResult queryResult = influxDB.query(query);
		}

		@Override
		public boolean findbyID(String id_event) {
			List<Evenement> result = new ArrayList<Evenement>();
	        Query query = new Query("SELECT * FROM evenement where ID /" + id_event +"/");
	        QueryResult queryResult = influxDB.query(query);
	        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
	        result = resultMapper.toPOJO(queryResult, Evenement.class);
			if(result==null)
				return false;
			else 
				return true;
		}

		@Override
		public void deletebyID(String id_event) {
			Query query = new Query("drop measurement evenement where ID /" + id_event +"/");
		    QueryResult queryResult = influxDB.query(query);
		}

	}
