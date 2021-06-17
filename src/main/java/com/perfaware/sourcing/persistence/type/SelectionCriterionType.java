package com.perfaware.sourcing.persistence.type;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@UserDefinedType(value = "typ_src_selection_criterion")
public class SelectionCriterionType {


	/*
     CREATE TYPE IF NOT EXISTS typ_src_selection_criterion (
	 parameter_name text,	
	 parameter_value double,
	 parameter_uom text,
	 query_type text);	 
	 */	

	@Column("parameter_name")
	private String parameterName;

	@Column("parameter_value")
	private double parameterValue;

	@Column("parameter_uom")
	private String parameterUom;
	
	@Column("query_type")
	private String queryType;

}
