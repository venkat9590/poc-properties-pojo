package com.perfaware.sourcing.web;

import java.util.List;

import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.perfaware.sourcing.model.request.Order;
import com.perfaware.sourcing.model.SourcingRuleSelectionReq;
import com.perfaware.sourcing.persistence.table.SourcingRuleSelectionTable;
import com.perfaware.sourcing.service.SourcingService;

/**
 * Sourcing Rule Selection Rest service controller
 */
@RestController
@RequestMapping("/sourcing/sourcingruleselection")
public class SourcingRuleSelectionController {

	private final SourcingService SourcingService;

	@Autowired
	public SourcingRuleSelectionController(SourcingService SourcingService) {
		this.SourcingService = SourcingService;
	}


	/**
	 * Creates Sourcing Rule selection
	 * @param requestList - all selection records
	 * @return
	 */
	@PutMapping (value = "/",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity postSourcingRuleInfo(@RequestBody List<SourcingRuleSelectionReq> requestList){

		return SourcingService.updateSourcingRuleSelection(requestList);
	}



	/**
	 * Fetches all sourcing rule selection records
	 * @return
	 */
	@GetMapping (value = "/")
	public ResponseEntity<List<SourcingRuleSelectionTable>> getSourcingRuleInfo(){

		return SourcingService.getSourcingRuleSelection();
	}

	@PostMapping (value = "/findsourcingrule/new",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findSourcingRuleNew(@RequestBody  Order orderRequest) throws JsonProcessingException, Exception{

		return SourcingService.findSourcingRuleNew(orderRequest);
	}

}
