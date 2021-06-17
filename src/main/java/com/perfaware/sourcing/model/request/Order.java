package com.perfaware.sourcing.model.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
	
	@JsonProperty("order_no")
	private String orderNo; 
	
	@JsonProperty("ship_node")
	private String shipNode;
	
	@JsonProperty("enterprise_code")
	private String enterpriseCode;
	
	@JsonProperty("delivery_method")
	private String deliveryMethod;
	
	@JsonProperty("order_type")
	private String orderType;
	
	@JsonProperty("fulfillment_type")
	private String fulfillmentType;
		
	@JsonProperty("order_lines")
	private List<OrderLine> orderLines;
	
	@JsonProperty("ship_to")
	private PersonInfoShipTo personInfoShipTo;
	

}
