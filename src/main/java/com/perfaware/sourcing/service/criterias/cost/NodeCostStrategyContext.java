package com.perfaware.sourcing.service.criterias.cost;

import com.perfaware.sourcing.persistence.table.ShipNodeTable;

import java.math.BigDecimal;

public class NodeCostStrategyContext {

    private NodeCostStrategy nodeCostStrategy;

    NodeCostStrategyContext(NodeCostStrategy nodeCostStrategy){
        this.nodeCostStrategy=nodeCostStrategy;
    }

    public BigDecimal executeNodeCostCalculation(ShipNodeTable shipNodeTable){
        return nodeCostStrategy.calculateNodeCost(shipNodeTable);
    }

}
