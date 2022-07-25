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
import com.example.entity.Event;


@Component
public class EventRepositoryImpl implements EventRepository{

		@Autowired
	    private InfluxDB influxDB;
		
		@Override
		public void save(Event event) 
		{
			Point point = Point
                    .measurement("event")
                    .time(System.currentTimeMillis(), TimeUnit.MICROSECONDS)
                    .tag("ID",event.getId())
                    .addField("event_timestamp", event.getEventTimestamp())
                    .addField("event_type", event.getEventType())
                    .addField("page_url", event.getPageUrl())
                    .addField("page_url_path", event.getPageUrlPath())
                    .addField("referer_url", event.getRefererUrl())
                    .addField("referer_url_scheme", event.getRefererUrlScheme())
                    .addField("referer_url_port", event.getRefererUrlPort())
                    .addField("referer_medium", event.getRefererMedium())
                    .addField("utm_medium", event.getUtmMedium())
                    .addField("utm_source", event.getUtmSource())
                    .addField("utm_content", event.getUtmContent())
                    .addField("utm_campaign", event.getUtmCampaign())
                    .addField("click_id", event.getClickId())
                    .addField("geo_latitude", event.getGeoLatitude())
                    .addField("geo_longitude", event.getGeoLongitude())
                    .addField("geo_country", event.getGeoCountry())
                    .addField("geo_timezone", event.getGeoTimezone())
                    .addField("geo_region_name", event.getGeoRegionName())
                    .addField("ip_address", event.getIpAddress())
                    .addField("browser_name", event.getBrowserName())
                    .addField("browser_user_agent", event.getBrowserUserAgent())
                    .addField("browser_language", event.getBrowserLanguage())
                    .addField("os", event.getOs())
                    .addField("os_name", event.getOsName())
                    .addField("os_timezone", event.getOsTimezone())
                    .addField("device_type", event.getDeviceType())
                    .addField("device_is_mobile", event.getDeviceIsMobile())
                    .build();
			influxDB.write(point);
		}

		@Override
		public List<Event> findAll() {
			List<Event> result = new ArrayList<Event>();
	        Query query = new Query("SELECT * FROM event");
	        QueryResult queryResult = influxDB.query(query);
	        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
	        result = resultMapper.toPOJO(queryResult, Event.class);
			return result;
		}

		@Override
		public void deleteAll() {
			 Query query = new Query("drop measurement event");
		     QueryResult queryResult = influxDB.query(query);
		}

		@Override
		public boolean findbyID(String id_event) {
			List<Event> result = new ArrayList<Event>();
	        Query query = new Query("SELECT * FROM event where ID /" + id_event +"/");
	        QueryResult queryResult = influxDB.query(query);
	        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
	        result = resultMapper.toPOJO(queryResult, Event.class);
			if(result==null)
				return false;
			else 
				return true;
		}

		@Override
		public void deletebyID(String id_event) {
			Query query = new Query("drop measurement event where ID /" + id_event +"/");
		    QueryResult queryResult = influxDB.query(query);
		}

	}
