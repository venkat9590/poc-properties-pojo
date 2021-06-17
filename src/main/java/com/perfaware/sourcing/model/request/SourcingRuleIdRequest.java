package com.perfaware.sourcing.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SourcingRuleIdRequest {

    @JsonProperty("attr_1")
    private String att1;

    @JsonProperty("attr_2")
    private String att2;

    @JsonProperty("attr_3")
    private String att3;

}
