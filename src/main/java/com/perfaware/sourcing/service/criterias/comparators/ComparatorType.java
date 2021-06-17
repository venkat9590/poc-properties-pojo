package com.perfaware.sourcing.service.criterias.comparators;

import java.util.HashMap;
import java.util.Map;

public enum ComparatorType {

    LESS_THAN("LT"),GREATER_THAN("GT"),EQUAL("EQ");

    private String comparatorType;

    ComparatorType(String type){
        this.comparatorType=type;
        ComparatorTypeMap.MAP.put(type,this);
    }

    public String getComparatorType(){return comparatorType;}

    private static class ComparatorTypeMap{
        static Map<String,ComparatorType> MAP = new HashMap<>();
    }

    public static ComparatorType getFromValue(String value){
        return ComparatorTypeMap.MAP.get(value);
    }
}
