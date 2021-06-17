package com.perfaware.sourcing.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.perfaware.sourcing.persistence.config.CassandraConfiguration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "cassandra")
@PropertySource("classpath:cassandra-${spring.profiles.active}.properties")
@Data
public class CassandraConfig {
	private static final Logger logger = LoggerFactory.getLogger(CassandraConfig.class);
	
String contactpoints;

	String port;

	String keyspace;

	String nodecount;

	String username;

	String password;
	@PostConstruct
	public void Check() {
		logger.info("Cassandra prop file--> "+"contactpoints: "+contactpoints+" "+"port: "+port+" "+"keyspace: "+keyspace+" "
	+"nodecount: "+nodecount+" "+"username: "+username+" "+"password: "+password);
		
	}
	
	
	


}
