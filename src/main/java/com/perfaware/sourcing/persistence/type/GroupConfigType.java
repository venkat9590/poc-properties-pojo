package com.perfaware.sourcing.persistence.type;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@UserDefinedType("typ_src_group_config")
public class GroupConfigType {

	/*
    CREATE TYPE IF NOT EXISTS typ_src_group_config (		
	 is_shipping_enabled boolean,
	 is_pickup_enabled boolean);	 
	*/
	
	@Column("is_shipping_enabled")
	private Boolean isShippingEnabled;

	@Column("is_pickup_enabled")
	private Boolean isPickupEnabled;
}
