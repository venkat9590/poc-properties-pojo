package com.perfaware.sourcing.persistence.table;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;
import com.datastax.driver.mapping.annotations.Frozen;
import com.perfaware.sourcing.persistence.type.ConditionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(value = "tbl_src_sourcing_rule_selection")
public class SourcingRuleSelectionTable {
	
	/*
     CREATE TABLE IF NOT EXISTS tbl_src_sourcing_rule_selection (
     org_code text,
	 seq_no int,
	 basic_conditions list<frozen<typ_src_trivial_condition>>,
	 complete_condition text,
	 sourcing_rule_id text,
	 create_ts timestamp,
	 modify_ts timestamp,
	 create_user_id text,
	 modify_user_id text,
	 PRIMARY KEY ((org_code),seq_no));	
	*/

	@PrimaryKeyClass
    @AllArgsConstructor
    @NoArgsConstructor    
    @Data
    public static class Key implements Serializable{

	    @PrimaryKeyColumn(name="org_code", type = PrimaryKeyType.PARTITIONED)
	    private String orgCode;

	    @PrimaryKeyColumn(name="seq_no", type = PrimaryKeyType.CLUSTERED)
	    private int seqNo;	    
	}
	
    @PrimaryKey
    private SourcingRuleSelectionTable.Key key;
    
    @Frozen
    @CassandraType(type = DataType.Name.UDT, userTypeName = "typ_src_basic_condition")
	@Column("basic_conditions")
	private List<ConditionType> basicConditions;

	@Column("complete_condition")
	private String completeCondition;

	@Column("sourcing_rule_id")
	private String sourcingRuleID;
	
	@Column("create_ts")
	private Instant createTs;
	
	@Column("modify_ts")
 	private Instant modifyTs;
	
	@Column("create_user_id")
	private String createUserId;
	
	@Column("modify_user_id")
	private String modifyUserId;	

}
