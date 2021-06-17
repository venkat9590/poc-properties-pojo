package com.perfaware.sourcing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfaware.sourcing.persistence.type.NodeListType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourcingRuleRequest {
	
	@JsonProperty("sourcing_rule_id")
	private String ruleId;
		
	@JsonProperty("org_code")
	private String orgCode;
	
	@JsonProperty("seq_no")
	private int seqNo;
	
	@JsonProperty("TierDescription")
	private String tier_Description;
	
	@JsonProperty("SelectionCriteria")
	private List<SelectionCriterion> selectionCriteria;
	
	@JsonProperty("TierNodes")
	private List<NodeListType> tierNodes;	

}
