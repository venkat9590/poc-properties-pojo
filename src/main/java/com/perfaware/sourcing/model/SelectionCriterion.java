package com.perfaware.sourcing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionCriterion {
    
	@JsonProperty("CriterionName")
	private String criterionName;
	
	@JsonProperty("CriterionValue")
	private String criterionValue;
	
	@JsonProperty("CriterionUom")
	private String criterionUom;
	
	@JsonProperty("ExecutionSequence")
	private int executionSequence;
	
	@JsonProperty("SortingSequence")
	private int sortingSequence;
	
	@JsonProperty("NoOfOptions")
	private int noOfOptions;
}
