package com.perfaware.sourcing.web;

import com.perfaware.sourcing.model.request.Order;
import com.perfaware.sourcing.service.SourcingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourcingRequestController {

    private SourcingService sourcingService;

    @Autowired
    SourcingRequestController(SourcingService sourcingService){
        this.sourcingService = sourcingService;
    }

    @RequestMapping(
            value="/v1/getAvailability",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST
    )
    public ResponseEntity<?> getSourcingResults(@RequestBody Order order) throws Exception {
        return sourcingService.findSourcingRuleNew(order);
    }

}
