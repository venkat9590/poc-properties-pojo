package com.perfaware.sourcing.persistence.type;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@UserDefinedType(value = "typ_src_basic_condition")
public class ConditionType {
	
	/*
	 CREATE TYPE IF NOT EXISTS typ_src_basic_condition (
     name text,
     attribute text,
	 query_type text,
	 value text );
	*/
	@NotNull
	@Column("name")
	@JsonProperty("condition_name")
	private String conditionName;

	@Column("attribute")
	@JsonProperty("attribute_name")	
	private String attributeName;

	@Column("query_type")
	@JsonProperty("query_type")	
	private String queryType;
	
	@Column("value")
	@JsonProperty("attribute_value")	
	private String attributeValue;


}
