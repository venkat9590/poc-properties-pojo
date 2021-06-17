package com.perfaware.sourcing.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "distance")
@PropertySource("classpath:crt-${spring.profiles.active}.properties")
@Data
public class DistanceConfig {

	private static final Logger logger = LoggerFactory.getLogger(DistanceConfig.class);
	String integrationenabled;

	String criteriaimplpackage;

	String offlineintegrationclass;

	String onlineintegrationclass;

	@PostConstruct
	public void checkDistance() {
		logger.info("DistanceConfig-->" + "IntergrationEnabled: " + integrationenabled + " " + " CriteriaImplPackage: "
				+ criteriaimplpackage + " " + "offLineIntegreationClass: " + offlineintegrationclass + " "
				+ "onLineIntegrationClass" + onlineintegrationclass);
	}

}
