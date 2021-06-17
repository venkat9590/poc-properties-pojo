package com.perfaware.sourcing.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perfaware.sourcing.model.SourcingRuleRequest;
import com.perfaware.sourcing.service.SourcingService;

@RestController
@RequestMapping("/sourcing")
public class SourcingRuleSequenceController {

	private final SourcingService SourcingService;

	@Autowired
	public SourcingRuleSequenceController(SourcingService SourcingService) {
		this.SourcingService = SourcingService;
	}



	/**
	 * API Group: Manage Sourcing Rule 
	 */

	@PostMapping (value = "/managesourcingrule",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> manageSourcingRule(@RequestBody List<SourcingRuleRequest> req){

		return SourcingService.manageSourcingRule(req);
	}

	
	/*@GetMapping (value = "/getSourcingNodes",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getSourcingNodes(@RequestParam("sourcing_rule_id") String sourcingRuleId, @RequestParam("org_code") String orgCode){

		return SourcingService.getSourcingNodes(sourcingRuleId,orgCode);
	}*/

	

}
