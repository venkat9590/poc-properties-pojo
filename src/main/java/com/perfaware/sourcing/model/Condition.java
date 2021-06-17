package com.perfaware.sourcing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condition {

	@JsonProperty("condition_name")
	private String conditionName;
	
	@JsonProperty("attribute_name")
	private String attributeName;
	
	@JsonProperty("query_type")
	private String queryType;
	
	@JsonProperty("attribute_value")
	private String attributeValue;
	
}
