package com.perfaware.sourcing.service.criterias.distance;

import com.perfaware.sourcing.model.request.PersonInfoShipTo;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;
import com.perfaware.sourcing.util.common.exception.ExceptionType;
import com.perfaware.sourcing.util.common.exception.SourcingException;
import lombok.SneakyThrows;

import java.math.BigDecimal;


public class DistanceStrategyContext {

    private String integClass;

    public DistanceStrategyContext(String integClass){
        this.integClass=integClass;
    }

    @SneakyThrows
    public BigDecimal executeDistanceCalculations(ShipNodeTable shipNodeTable, PersonInfoShipTo personInfoShipTo){
         try{
             DistanceStrategy distanceStrategy = (DistanceStrategy) Class.forName(integClass).newInstance();
             return distanceStrategy.calculateDistance(shipNodeTable,personInfoShipTo);
         }
         catch(ClassNotFoundException classNotFoundException){
             throw new SourcingException(ExceptionType.SRC_CRITERIA_EX_DIS_CLASS.getExMessage());
         }
         catch(ClassCastException classCastException){
             throw new SourcingException(ExceptionType.CLASS_CAST_EX.getExMessage()+integClass);
         }
    }
}
