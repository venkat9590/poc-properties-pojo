package com.perfaware.sourcing.model;

import java.time.Instant;
import java.util.List;

import com.perfaware.sourcing.persistence.table.SourcingRuleSelectionTable;
import com.perfaware.sourcing.persistence.type.ConditionType;
import com.perfaware.sourcing.util.TSProvider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SourcingRuleSelectionDTO {

	private int seqNo;
	private String orgCode;
	private List<ConditionType> basicConditions;
	private String completeCondition;
	private String sourcingRuleId;
	private SourcingRuleSelectionTable SourcingRuleSelectionTable;
    private String createUserID;
    private String modifyUserID;
    private Instant createTs;
    private Instant modifyTs;
    private TSProvider tsProvider;


	public SourcingRuleSelectionDTO(String orgCode, int seqNo, List<ConditionType> basicConditions,
			String completeCondition, String sourcingRuleId, TSProvider tsProvider) {
		this.seqNo = seqNo;
		this.orgCode = orgCode;
		this.basicConditions = basicConditions;
		this.completeCondition = completeCondition;
		this.sourcingRuleId = sourcingRuleId;
		this.createTs = tsProvider.getTime();
		this.modifyTs = tsProvider.getTime();
		this.createUserID = "system";
		this.modifyUserID = "system";
		SourcingRuleSelectionTable = new SourcingRuleSelectionTable(new SourcingRuleSelectionTable.Key(this.orgCode,this.seqNo),basicConditions,completeCondition,sourcingRuleId,createTs,modifyTs,createUserID,modifyUserID);
	}
	
	




}
