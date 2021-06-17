package com.perfaware.sourcing.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.perfaware.sourcing.model.ShipNodeResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perfaware.sourcing.model.ShipNodeRequest;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;
import com.perfaware.sourcing.service.SourcingService;

/**
 * ShipNode Rest service controller
 */
@RestController
@RequestMapping("/sourcing/shipnode")
@Validated
public class ShipNodeController {

	private final SourcingService sourcingService;

	@Autowired
	public ShipNodeController(SourcingService sourcingService){
		this.sourcingService = sourcingService;
	}

	/**
	 * Create ship node
	 * @param reqBody Ship Node Object
	 * @return Newly created ship Node
	 */
	@PostMapping (value = "/",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShipNodeResponseObject> createShipNode(@RequestBody List<ShipNodeRequest> reqBody) throws Exception{
		return sourcingService.updateShipNode(reqBody);
	}


	/**
	 * Makes the ship node Inactive
	 * @param orgCode
	 * @param nodeId
	 * @return
	 */
	@DeleteMapping (value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<ShipNodeTable> deleteShipNodeInfo(@PathVariable("id") @NotNull String nodeId, @RequestParam("org_code") @NotNull String orgCode){
		return sourcingService.deleteShipNode(orgCode,nodeId);
	}


	/**
	 * Get All ship nodes.
	 * @return All Ship nodes
	 */
	@GetMapping (value = "/",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ShipNodeTable>> getAllShipNode(){

		return sourcingService.getShipNodes();
	}

}
