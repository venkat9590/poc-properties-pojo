package com.perfaware.sourcing.persistence.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.perfaware.sourcing.persistence.table.ShipNodeTable;

@Repository
public interface ShipNodeRepository extends CassandraRepository<ShipNodeTable, ShipNodeTable.Key>{
	
	@Query(value="SELECT * FROM tbl_src_node WHERE org_code=?0 AND node_id=?1")
	ShipNodeTable findByOrgCodeAndNodeId(String orgCode, String nodeId);
	
	//org_code text,node_id text,description text,node_type text,zipcode text,longitude double,latitude double,node_cost double,is_active boolean,shipping_enabled boolean,pickup_enabled boolean,is_big_store boolean,is_shut_down boolean,is_cold_storage_available boolean,can_store_hazmat boolean,create_ts timestamp,modify_ts timestamp,create_user_id text,modify_user_id text
	
	@Query(value="INSERT INTO tbl_src_node (node_id, org_code, description, node_type, zipcode, longitude, latitude, node_cost, is_active, is_shipping_enabled, is_pickup_enabled, is_big_store, is_shut_down, is_cold_storage_available, is_hazmat_storage_available, create_ts, modify_ts, create_user_id, modify_user_id) VALUES (?0, ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, toTimeStamp(now()), toTimeStamp(now()), 'system', 'system')")
    void updateShipNode(String node_id, String org_code, String description, String node_type, String zipcode, double longitude,
    		double latitude, double node_cost, boolean is_active, boolean shipping_enabled, boolean pickup_enabled,
    		boolean is_big_store, boolean is_shut_down, boolean is_cold_storage_available, boolean can_store_hazmat) throws Exception;
	
	
	@Query(value="UPDATE tbl_src_node SET is_active=false WHERE node_id=?0 AND org_code=?1")
	void deleteShipNode(String node_id, String org_code);

	@Query(value = "select * from tbl_src_node where org_code =?0 and node_id in ?1")
	List<ShipNodeTable> findAllNodes(String orgCode,List<String> nodes);
}
