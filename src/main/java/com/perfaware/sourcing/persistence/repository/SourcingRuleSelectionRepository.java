package com.perfaware.sourcing.persistence.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.perfaware.sourcing.persistence.table.SourcingRuleSelectionTable;
import com.perfaware.sourcing.persistence.type.ConditionType;

@Repository
public interface SourcingRuleSelectionRepository extends CassandraRepository<SourcingRuleSelectionTable,SourcingRuleSelectionTable.Key>{

	
	@Query(value="SELECT * FROM tbl_src_sourcing_rule_selection WHERE seq_no=?0")
	SourcingRuleSelectionTable findAllByKeyseq_no(String seq_no);
	
	@Query(value="INSERT INTO tbl_src_sourcing_rule_selection (org_code, seq_no, basic_conditions, complete_condition, sourcing_rule_id, create_ts, modify_ts, create_user_id, modify_user_id) VALUES (?0, ?1, ?2, ?3, ?4, toTimeStamp(now()), toTimeStamp(now()), 'system', 'system')")
    void updateSourcingRuleSelection(String org_code, int seq_no, List<ConditionType> basic_conditions, String complete_condition, String sourcing_rule_id);

	@Query(value="TRUNCATE tbl_src_sourcing_rule_selection")
	void deleteSourcingRuleSelection();
}
