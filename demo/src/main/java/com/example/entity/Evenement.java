package com.example.entity;

import javax.persistence.Entity;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//Table name 
@Measurement(name = "evenement")
public class Evenement {
	
	@Column(tag = true, name = "id")
	private String id;

	@Column(name = "event_timestamp")
	private String event_timestamp;
	
	@Column(name = "event_type")
	private String event_type;
	
	@Column(name = "page_url")
	private String page_url;
	
	@Column(name = "page_url_path")
	private String page_url_path;
	
	@Column(name = "referer_url")
	private String referer_url;
	
	@Column(name = "referer_url_scheme")
	private String referer_url_scheme;
	
	@Column(name = "referer_url_port")
	private String referer_url_port;
	
	@Column(name = "referer_medium")
	private String referer_medium;
	
	@Column(name = "utm_medium")
	private String utm_medium;
	
	@Column(name = "utm_source")
	private String utm_source;
	
	@Column(name = "utm_content")
	private String utm_content;
	
	@Column(name = "utm_campaign")
	private String utm_campaign;
	
	@Column(name = "click_id")
	private String click_id;
	
	@Column(name = "geo_latitude")
	private String geo_latitude;
	
	@Column(name = "geo_longitude")
	private String geo_longitude;
	
	@Column(name = "geo_country")
	private String geo_country;
	
	@Column(name = "geo_timezone")
	private String geo_timezone;
	
	@Column(name = "geo_region_name")
	private String geo_region_name;
	
	@Column(name = "ip_address")
	private String ip_address;
	
	@Column(name = "browser_name")
	private String browser_name;
	 
	@Column(name = "browser_user_agent")
	private String browser_user_agent;
	
	@Column(name = "browser_language")
	private String browser_language;
	
	@Column(name = "os")
	private String os;
	
	@Column(name = "os_name")
	private String os_name;
	
	@Column(name = "os_timezone")
	private String os_timezone;
	
	@Column(name = "device_type")
	private String device_type;
	
	@Column(name = "device_is_mobile")
	private Boolean device_is_mobile;
	
}
