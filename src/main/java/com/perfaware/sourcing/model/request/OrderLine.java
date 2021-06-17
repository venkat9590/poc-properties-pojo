package com.perfaware.sourcing.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.perfaware.sourcing.model.ItemDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
	
	@JsonProperty("line_no")
	private String lineNo;

	@JsonProperty("item_id")
	private String itemId;
	
	@JsonProperty("quantity")
	private String quantity;
	
	@JsonProperty("uom")
	private String uom;

	@JsonProperty("product_class")
	private String productClass;
	
	@JsonProperty("fulfillment_type")
	private String fulfillmentType;

	@JsonProperty("item_details")
	private ItemDetails itemDetails;
	
}
