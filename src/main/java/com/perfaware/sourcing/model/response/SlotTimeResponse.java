package com.perfaware.sourcing.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotTimeResponse {

    @JsonProperty("sot_start_time")
    private String slotStartTime;

    @JsonProperty("slot_end_time")
    private String slotEndTime;
}
