package com.perfaware.sourcing.util;

import java.time.Instant;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class TSProvider {
	
    private Instant time;

    public TSProvider(){
        time= SourcingUtility.generateCurrentTimestamp();
    }


}
