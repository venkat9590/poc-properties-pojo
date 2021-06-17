package com.perfaware.sourcing.service.criterias.cost;

import com.perfaware.sourcing.model.request.Order;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;
import com.perfaware.sourcing.persistence.type.SelectionCriterionType;
import com.perfaware.sourcing.util.constants.SourcingConstants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class NodeCostService {

    private NodeCostStrategyContext nodeCostStrategyContext;

    Predicate<SelectionCriterionType> nodeCostSelection = criteria -> SourcingConstants.nodeCost.equalsIgnoreCase(criteria.getParameterName());

    public List<String> callNodeCost(List<SelectionCriterionType> selectionCriterionType, List<java.lang.String> storeListForCriteria, Map<java.lang.String, ShipNodeTable> nodeDetails, Order orderRequest){

        Optional<SelectionCriterionType> nodeCostCriteria = selectionCriterionType.stream().filter(nodeCostSelection).findAny();


        return null;
    }

}
