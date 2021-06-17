package com.perfaware.sourcing.persistence.repository;

import java.util.List;

import com.datastax.driver.mapping.annotations.Param;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.perfaware.sourcing.persistence.table.SourcingRuleTable;
import com.perfaware.sourcing.persistence.type.NodeListType;

@Repository
public interface SourcingRuleRepository extends CassandraRepository<SourcingRuleTable, SourcingRuleTable.Key> {
    
	@Query(value="INSERT INTO tbl_src_sourcing_rule_seq (rule_id, rule_type, org_code, tier_seq_no, tier_description, tier_nodes) VALUES (?0, ?1, ?2, ?3, ?4, ?5)")
	void updateSourcingRule(String ruleId, String ruleType, String orgId, int tierSeqNo,
			String tierDescription,List<NodeListType> tierNodes);
	
	@Query(value="SELECT * FROM tbl_src_sourcing_rule_seq WHERE org_code=?0 AND sourcing_rule_id=?1")
	List<SourcingRuleTable> fetchSequences(String orgCode, String sourcingRuleId);
}
