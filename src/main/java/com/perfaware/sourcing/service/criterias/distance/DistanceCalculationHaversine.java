package com.perfaware.sourcing.service.criterias.distance;

import com.perfaware.sourcing.model.request.PersonInfoShipTo;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;

import java.math.BigDecimal;

//Haversine Implementation
public class DistanceCalculationHaversine implements DistanceStrategy{
    @Override
    public BigDecimal calculateDistance(ShipNodeTable shipNodeTable, PersonInfoShipTo personInfoShipTo) {

        double haversine, distance;

        double dLat,  dLon;

        double DEG_RAD = 0.01745329251994;

        double R_EARTH = 6367.45;

        dLat = (Double.parseDouble(personInfoShipTo.getLatitude()) - shipNodeTable.getLatitude()) * DEG_RAD;

        dLon = (Double.parseDouble(personInfoShipTo.getLongitude()) - shipNodeTable.getLongitude()) * DEG_RAD;

        haversine = Math.sin(dLat * 0.5) * Math.sin(dLat * 0.5) +

                Math.sin(dLon * 0.5) * Math.sin(dLon * 0.5) *

                        Math.cos(shipNodeTable.getLatitude() * DEG_RAD) *

                        Math.cos(Double.parseDouble(personInfoShipTo.getLatitude()) * DEG_RAD);

        distance = Math.asin(Math.sqrt(haversine)) * R_EARTH * 2.0;

        return BigDecimal.valueOf(distance);
    }
}
