package com.perfaware.sourcing.persistence.table;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(value = "tbl_src_node")
@Component

public class ShipNodeTable {

	/*
	  
	 CREATE KEYSPACE sourcing WITH replication = {'class':
	 'SimpleStrategy', 'replication_factor': '2'} AND durable_writes = true;
	  
CREATE TABLE IF NOT EXISTS tbl_src_node (
     org_code text,
	 node_id text,
	 description text,
	 node_type text,
	 zipcode text,
	 longitude double,		
	 latitude double,
	 node_cost double,
	 is_active boolean,
	 is_shipping_enabled boolean,
	 is_pickup_enabled boolean,
	 is_big_store boolean,
	 is_shut_down boolean,
	 is_cold_storage_available boolean,
	 is_hazmat_storage_available boolean,
	 create_ts timestamp,
	 modify_ts timestamp,
	 create_user_id text,
 	 modify_user_id text,
	 PRIMARY KEY ((org_code), node_id));	  
	 */

	
	@PrimaryKeyClass	  
	@AllArgsConstructor	  
	@Data 
	public class Key implements Serializable{
		
		@PrimaryKeyColumn(name ="org_code", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private String orgCode;
		
		@PrimaryKeyColumn(name ="node_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
		private String nodeId;
			    
	}
	
        
    @PrimaryKey
    private ShipNodeTable.Key key;
            
	@Column("description")
	private String description;
    
	@Column("node_type")
	private String nodeType;
	
	@Column("zipcode")
	private String zipcode;
       
	@Column("longitude")
	private double longitude;
    
	@Column("latitude")
	private double latitude;
	
	@Column("node_cost")
	private double nodeCost;
	
	@Column("is_active")
	private boolean isActive;
	
	@Column("is_shipping_enabled")
	private boolean isShippingEnabled;

	@Column("is_pickup_enabled")
	private boolean isPickupEnabled;
	
	@Column("is_big_store")
	private boolean isBigStore;
    
	@Column("is_shut_down")
	private boolean isShutDown;

	@Column("is_cold_storage_available")
	private boolean isColdStorageAvailable;
	
	@Column("is_hazmat_storage_available")
	private boolean isHazmatStorageAvailable;

	@Column("create_ts")
	private Instant createTs;
	
	@Column("modify_ts")
 	private Instant modifyTs;
	
	@Column("create_user_id")
	private String createUserId;
	
	@Column("modify_user_id")
	private String modifyUserId;
}
