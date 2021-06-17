package com.perfaware.sourcing.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CapacityAvailabilityResponse {

    @JsonProperty("availabilities")
    List<CapacityAvailability> capacityAvailability;

}
