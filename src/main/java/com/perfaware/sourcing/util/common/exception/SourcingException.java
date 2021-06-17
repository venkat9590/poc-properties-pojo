package com.perfaware.sourcing.util.common.exception;

import com.perfaware.sourcing.util.common.error.SourcingError;

public class SourcingException extends RuntimeException{

    private SourcingError sourcingError;

    public SourcingException(String message){
        super(message);
    }

    public SourcingException(String message,String code){
        super(message);
        this.sourcingError=new SourcingError(code,message);
    }
}
