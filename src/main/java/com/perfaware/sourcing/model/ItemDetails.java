package com.perfaware.sourcing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetails {
  
	@JsonProperty("is_ship_alone")
	private String isShipAlone;

	@JsonProperty("is_hazmat")
	private String isHazMat;

}
