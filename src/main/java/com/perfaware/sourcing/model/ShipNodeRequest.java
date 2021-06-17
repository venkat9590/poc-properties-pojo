package com.perfaware.sourcing.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipNodeRequest {
    
	@NotNull
	@NotEmpty
	@JsonProperty("node_id")
	private String nodeId;
	
	@NotNull
	@NotEmpty
	@JsonProperty("org_code")
	private String orgCode;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("node_type")
	private String nodeType;
	
	@JsonProperty("zipcode")
	private String zipcode;
    
	@JsonProperty("longitude")
	private double longitude;
	
	@JsonProperty("latitude")
	private double latitude;

	@JsonProperty("node_cost")
	private double laborCost;
	
	@JsonProperty("is_active")
	private boolean isActive;
	
	@JsonProperty("is_shipping_enabled")
	private boolean isShippingEnabled;

	@JsonProperty("is_pickup_enabled")
	private boolean isPickupEnabled;
	
	@JsonProperty("is_big_store")
	private boolean isBigStore;

	@JsonProperty("is_shut_down")
	private boolean isShutDown;
	
	@JsonProperty("is_cold_storage_available")
	private boolean isColdStorageAvailable;

	@JsonProperty("is_hazmat_storage_available")
	private boolean isHazmatStorageAvailable;
	
}
