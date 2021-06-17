package com.example.demo.props;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;


//@ConfigurationProperties(prefix = "prop")
@Component
@Data
public class Impl {
	//@Value("${packages}")
	private String packages;
	@PostConstruct
	public void criteriaCheck() {
		System.out.println("Packages -->"+packages);
		//logger.info("Properties value: ---> " + Packages);

	}

}
