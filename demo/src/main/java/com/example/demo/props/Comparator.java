package com.example.demo.props;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Comparator {
	private Impl impl;

	@Autowired
	public Comparator(Impl impl) {
		this.impl = impl;
	}

}
