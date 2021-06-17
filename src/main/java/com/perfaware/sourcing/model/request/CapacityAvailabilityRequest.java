package com.perfaware.sourcing.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CapacityAvailabilityRequest {

    @JsonProperty("stores")
    private List<String> stores;

    @JsonProperty("org_code")
    private String orgCode;

    @JsonProperty("delivery_method")
    private String deliveryMethod;

    @JsonProperty("availability_date")
    private String availabilityDate;

}
