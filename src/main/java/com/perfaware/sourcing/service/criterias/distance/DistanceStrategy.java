package com.perfaware.sourcing.service.criterias.distance;

import com.perfaware.sourcing.model.request.PersonInfoShipTo;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;

import java.math.BigDecimal;

public interface DistanceStrategy {

    public BigDecimal calculateDistance(ShipNodeTable shipNodeTable, PersonInfoShipTo personInfoShipTo);
}
