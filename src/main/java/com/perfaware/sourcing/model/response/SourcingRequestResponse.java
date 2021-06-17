package com.perfaware.sourcing.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SourcingRequestResponse {

    @JsonProperty("stores_inv")
    List<String> seqStores;

    @JsonProperty("capacity_availabilities")
    List<CapacityAvailability> capacityAvailabilities;

    @JsonProperty("isSplit")
    private String isSplit = "N";

}
