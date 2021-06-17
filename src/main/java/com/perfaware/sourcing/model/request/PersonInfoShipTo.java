package com.perfaware.sourcing.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfoShipTo {
    
 	
	@JsonProperty("address_line1")
	private String addressLine1;
	
	@JsonProperty("city")
	private String city;
    
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("zipcode")
	private String zipcode;

	@JsonProperty("longitude")
	private String longitude;
	
	@JsonProperty("latitude")
	private String latitude;
	
}
