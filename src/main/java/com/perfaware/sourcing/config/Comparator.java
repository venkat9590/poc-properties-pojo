package com.perfaware.sourcing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data

public class Comparator {
	private Impl impl;
	private String lessthan;
	private String greaterthan;
	private String equal;
	@Autowired
	public Comparator(Impl impl){
		this.impl=impl;	
	}

}
