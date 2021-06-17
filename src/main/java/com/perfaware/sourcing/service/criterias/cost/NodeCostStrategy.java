package com.perfaware.sourcing.service.criterias.cost;

import com.perfaware.sourcing.persistence.table.ShipNodeTable;

import java.math.BigDecimal;

public interface NodeCostStrategy {

    public BigDecimal calculateNodeCost(ShipNodeTable shipNodeTable);

}
