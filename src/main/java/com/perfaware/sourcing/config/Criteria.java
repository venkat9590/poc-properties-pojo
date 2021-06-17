package com.perfaware.sourcing.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
//@ConfigurationProperties(prefix = "criteria.comparator")
@PropertySource("classpath:crt-${spring.profiles.active}.properties")
@Data
public class Criteria {

	private static final Logger logger = LoggerFactory.getLogger(Criteria.class);
	private Comparator comparator;

	/*
	 * String implementationpackage;
	 * 
	 * String lessthan;
	 * 
	 * String greaterthan;
	 * 
	 * String equal;
	 */  
	 
	  @PostConstruct public void checkCriteria() {
	  logger.info("CriteriaConfig valuess --> " + "implementationpackage: " +
	  comparator.getImpl().getPackages() + " " + "lessthan: " +
	  comparator.getLessthan() + " " + "greaterthan: " +
	  comparator.getGreaterthan() + " " + "equal: " + comparator.getEqual());
	  
	 }

	@Autowired
	public Criteria(Comparator comparator) {
		this.comparator = comparator;
	}
}
