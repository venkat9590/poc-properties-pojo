package com.example.demo.props;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:criteria-${spring.profiles.active}.properties")
public class Criteria {
	private static final Logger logger = LoggerFactory.getLogger(Criteria.class);
	private Comparator comparator;

	@Autowired
	public Criteria(Comparator comparator) {
		this.comparator = comparator;

	}

	@PostConstruct
	public void criteriaCheck() {
		logger.info("Properties value: ---> " + comparator.getImpl().getPackages());
	}

}
