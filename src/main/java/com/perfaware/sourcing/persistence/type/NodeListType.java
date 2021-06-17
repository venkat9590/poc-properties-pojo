package com.perfaware.sourcing.persistence.type;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@UserDefinedType("typ_src_node_config")
public class NodeListType {

	
	/*
     CREATE TYPE IF NOT EXISTS typ_src_node_config (
	 node_id text,		
	 is_shipping_enabled boolean,
	 is_pickup_enabled boolean);	 
	*/	

	@Column("node_id")
	private String nodeId;

	@Column("is_shipping_enabled")
	private Boolean isShippingEnabled;

	@Column("is_pickup_enabled")
	private Boolean isPickupEnabled;
	 
}
