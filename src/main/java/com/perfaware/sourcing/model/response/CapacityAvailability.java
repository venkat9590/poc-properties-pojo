package com.perfaware.sourcing.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapacityAvailability {

    @JsonProperty("availability_date")
    private String date;

    @JsonProperty("availability")
    Map<String, Map<String, List<SlotTimeResponse>>> hmpResponse;

}
