package com.perfaware.sourcing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TierNode {
	
	@JsonProperty("NodeId")
	private String nodeId;
	
	@JsonProperty("ShippingEnabled")
	private boolean shippingEnabled;
	
	@JsonProperty("PickupEnabled")
	private boolean pickupEnabled;
	
	@JsonProperty("IsBigStore")
	private boolean isBigStore;
	
	@JsonProperty("IsShutDown")
	private boolean isShutDown;
	
	@JsonProperty("OrderType")
	private String orderType;
	
	@JsonProperty("IsColdStorageAvailable")
	private boolean isColdStorageAvailable;
	
	@JsonProperty("CanStoreHazmat")
	private boolean canStoreHazmat;

}
