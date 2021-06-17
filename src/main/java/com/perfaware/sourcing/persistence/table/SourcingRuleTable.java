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
import com.perfaware.sourcing.persistence.type.GroupConfigType;
import com.perfaware.sourcing.persistence.type.NodeListType;
import com.perfaware.sourcing.persistence.type.SelectionCriterionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(value = "tbl_src_sourcing_rule_seq")
public class SourcingRuleTable {

	/*
     CREATE TABLE IF NOT EXISTS tbl_src_sourcing_rule_seq (
     org_code text,
	 sourcing_rule_id text,
	 sourcing_rule_description text,			
	 maximum_solutions int,
	 optimization_criteria list<text>,
	 seq_no int,
	 seq_description text,	 
	 node_selection_criteria list<frozen<typ_src_selection_criterion>>,
	 group_config frozen<typ_src_group_config>,
	 node_list list<frozen<typ_src_node_config>>,
	 create_ts timestamp,
	 modify_ts timestamp,
	 create_user_id text,
	 modify_user_id text,	 
     PRIMARY KEY ((org_code), sourcing_rule_id, seq_no));
    */	

	@PrimaryKeyClass	  
	@AllArgsConstructor	  
	@Data 
	public static class Key implements Serializable{

		@PrimaryKeyColumn(name ="org_code", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private String orgCode;
		
		@PrimaryKeyColumn(name ="sourcing_rule_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
		private String sourcingRuleId;
		
		@PrimaryKeyColumn(name ="seq_no", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
		private int seqNo;
				

	}

    @PrimaryKey
    private SourcingRuleTable.Key key;

    @Column("sourcing_rule_description")
	private String sourcingRuleDescription;
    
    @Column("maximum_solutions")
    private int maximumSolutions;  
    
    @Column("optimization_criteria")
	private List<String> optimizationCriteria;
    
	@Column("seq_description")
	private String seqDescription;	

    @Frozen
    @Column("node_selection_criteria")
    @CassandraType(type = DataType.Name.UDT, userTypeName = "typ_src_selection_criterion")
    private List<SelectionCriterionType> nodeSelectionCriteria;
    
    @Frozen
    @Column("group_config")
    @CassandraType(type = DataType.Name.UDT, userTypeName = "typ_src_group_config")
    private GroupConfigType groupConfig;

    @Frozen
    @Column("node_list")
    @CassandraType(type = DataType.Name.UDT, userTypeName = "typ_src_node_config")
    private List<NodeListType> nodeList;
    
	@Column("create_ts")
	private Instant createTs;
	
	@Column("modify_ts")
 	private Instant modifyTs;
	
	@Column("create_user_id")
	private String createUserId;
	
	@Column("modify_user_id")
	private String modifyUserId;
	
}
