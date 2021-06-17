package com.perfaware.sourcing.service.criterias.cost;

import com.perfaware.sourcing.persistence.table.ShipNodeTable;

import java.math.BigDecimal;

public class NodeCostCalculator implements NodeCostStrategy{
    @Override
    public BigDecimal calculateNodeCost(ShipNodeTable shipNodeTable) {
        return new BigDecimal(shipNodeTable.getNodeCost());
    }
}
