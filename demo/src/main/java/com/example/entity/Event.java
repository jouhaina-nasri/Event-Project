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
@Measurement(name = "event")
public class Event {
	
	@Column(tag = true, name = "id")
	private String id;

	@Column(name = "event_timestamp")
	private String eventTimestamp;
	
	@Column(name = "event_type")
	private String eventType;
	
	@Column(name = "page_url")
	private String pageUrl;
	
	@Column(name = "page_url_path")
	private String pageUrlPath;
	
	@Column(name = "referer_url")
	private String refererUrl;
	
	@Column(name = "referer_url_scheme")
	private String refererUrlScheme;
	
	@Column(name = "referer_url_port")
	private String refererUrlPort;
	
	@Column(name = "referer_medium")
	private String refererMedium;
	
	@Column(name = "utm_medium")
	private String utmMedium;
	
	@Column(name = "utm_source")
	private String utmSource;
	
	@Column(name = "utm_content")
	private String utmContent;
	
	@Column(name = "utm_campaign")
	private String utmCampaign;
	
	@Column(name = "click_id")
	private String clickId;
	
	@Column(name = "geo_latitude")
	private String geoLatitude;
	
	@Column(name = "geo_longitude")
	private String geoLongitude;
	
	@Column(name = "geo_country")
	private String geoCountry;
	
	@Column(name = "geo_timezone")
	private String geoTimezone;
	
	@Column(name = "geo_region_name")
	private String geoRegionName;
	
	@Column(name = "ip_address")
	private String ipAddress;
	
	@Column(name = "browser_name")
	private String browserName;
	 
	@Column(name = "browser_user_agent")
	private String browserUserAgent;
	
	@Column(name = "browser_language")
	private String browserLanguage;
	
	@Column(name = "os")
	private String os;
	
	@Column(name = "os_name")
	private String osName;
	
	@Column(name = "os_timezone")
	private String osTimezone;
	
	@Column(name = "device_type")
	private String deviceType;
	
	@Column(name = "device_is_mobile")
	private Boolean deviceIsMobile;
	
}
