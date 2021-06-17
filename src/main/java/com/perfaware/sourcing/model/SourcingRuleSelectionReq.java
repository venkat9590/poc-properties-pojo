package com.perfaware.sourcing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfaware.sourcing.persistence.type.ConditionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourcingRuleSelectionReq {
	
	@JsonProperty("seq_no")
	private int seqNo;
	
	@JsonProperty("org_code")
	private String orgCode;
	
	@JsonProperty("basic_conditions")
	private List<ConditionType> basicConditions;
	
	@JsonProperty("complete_condition")
	private String completeCondition;
		
	@JsonProperty("sourcing_rule_id")
	private String sourcingRuleId;
}
