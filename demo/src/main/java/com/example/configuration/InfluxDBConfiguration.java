package com.example.configuration;

import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDBConfiguration {

    @Value("${spring.influx.url:''}")
    private String influxDBUrl;

    @Value("${spring.influx.user:''}")
    private String userName;

    @Value("${spring.influx.password:''}")
    private String password;

    @Value("${spring.influx.database:''}")
    private String database;

    @Bean
    public InfluxDB influxDB(){
        InfluxDB influxDB = InfluxDBFactory.connect(influxDBUrl, userName, password);
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
        Pong response = influxDB.ping();
        if (response.getVersion().equalsIgnoreCase("unknown")) {
          System.out.println("unknown");
        } 
        else System.out.println("response is : "+response.toString());
        try {
            influxDB.setDatabase(database)
                    .enableBatch(100,2000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        	 System.out.println("In Catch");
             e.printStackTrace();
        } finally {
            influxDB.setRetentionPolicy("autogen");
        }
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
        return influxDB;
    }
}