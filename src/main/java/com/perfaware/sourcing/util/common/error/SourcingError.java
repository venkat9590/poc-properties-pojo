package com.perfaware.sourcing.util.common.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class SourcingError {

    private final String DEFAULT_MESSAGE ="Unable to process request";
    private final String DEFAULT_CODE="1000";

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    SourcingError(){
        this.code=DEFAULT_MESSAGE;
        this.message=DEFAULT_MESSAGE;
    }

}
