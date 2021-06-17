package com.perfaware.sourcing.service;

import java.util.List;
import java.util.Map;

import com.perfaware.sourcing.model.*;
import com.perfaware.sourcing.model.request.Order;
import com.perfaware.sourcing.model.response.SourcingRequestResponse;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;
import com.perfaware.sourcing.persistence.table.SourcingRuleSelectionTable;

public interface SourcingService {
	
	/**
	 * API Group: ShipNode
	 * Inserts nodes into "ShipNode" table
	 * @param requestInfo : shipNode request object
	 * @return ResponseEntity
	 */
	ResponseEntity<ShipNodeResponseObject> updateShipNode(List<ShipNodeRequest> requestInfo) throws Exception;
	
	
	/** 
	 * API Group: ShipNode
	 * Retrieves particular node details from "ShipNode" table
     */
	void getNodeDetails(String orgCode, String nodeId);
	

	/** 
	 * API Group: ShipNode
	 * Deletes node from "ShipNode" table
	 * @return ResponseEntity
	 */	
	ResponseEntity<ShipNodeTable> deleteShipNode(String orgCode, String nodeId);
	

	/** 
	 * API Group: ShipNode
	 * Retrieves all the nodes from "ShipNode" table
	 * @return Response Entity object of all ShipNodeTable rows
	 */	
	ResponseEntity<List<ShipNodeTable>> getShipNodes();


	/** 
	 * API Group: Sourcing Rule Selection
	 * Updates Sourcing Rule Selection information into SourcingRuleSelection table
	 * @param requestInfo : SourcingRule selection request object
	 */		
	ResponseEntity updateSourcingRuleSelection(List<SourcingRuleSelectionReq> requestInfo);
	

	/** 
	 * API Group: Sourcing Rule Selection
	 * get Sourcing Rule Selection information from SourcingRuleSelection table
	 */		
	ResponseEntity<List<SourcingRuleSelectionTable>> getSourcingRuleSelection();
	
	/** 
	 * API Group: Manage Sourcing Rule
	 * 
	 * @param req : Complete Sourcing rule details of particular tier request 
	 */			
	ResponseEntity<Object> manageSourcingRule(List<SourcingRuleRequest> req);


	ResponseEntity<?> findSourcingRuleNew(Order orderRequest) throws JsonProcessingException, Exception;

	SourcingRequestResponse getSourcingNodes(String sourcingRuleId, String orgCode, Map<String,String> hmpItemQty, Order orderRequest) throws Exception;

}
