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
public class InvCacheRecForItems {

    @JsonProperty("org_code")
    private String orgCode;

    @JsonProperty("item")
    private String item;

    @JsonProperty("qty")
    private String qty;

}
