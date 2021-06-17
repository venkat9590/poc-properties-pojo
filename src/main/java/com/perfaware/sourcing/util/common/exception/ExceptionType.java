package com.perfaware.sourcing.util.common.exception;

public enum ExceptionType {

    SRC_RULE_ID_EX("Sourcing rule id not found for the request."),
    SRC_CRITERIA_EX_DIS_CLASS("Sourcing rule criteria: Distance selection IMPL: Class not found."),
    CLASS_CAST_EX("Class cast exception when casting: ");

    private String exMessage;

    ExceptionType(String ex){
        this.exMessage=ex;
    }

    public String getExMessage(){return exMessage;}
}
