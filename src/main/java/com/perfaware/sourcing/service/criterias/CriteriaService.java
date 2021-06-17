package com.perfaware.sourcing.service.criterias;

import com.perfaware.sourcing.model.request.Order;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;
import com.perfaware.sourcing.persistence.type.SelectionCriterionType;
import com.perfaware.sourcing.service.criterias.distance.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CriteriaService {

    private DistanceService distanceService;

    @Autowired
    CriteriaService(DistanceService distanceService){
        this.distanceService = distanceService;
    }

    public List<String> determineCriteriaFlow(List<SelectionCriterionType> selectionCriterionType, List<String> storeListForCriteria, Map<String, ShipNodeTable> nodeDetails, Order orderRequest){

        List<String> filteredStores = new ArrayList<>();
        for(SelectionCriterionType selectionCriteria:selectionCriterionType){

            switch(CriteriaParameters.valueOf(selectionCriteria.getParameterName())){

                case distance:
                    //call distance service to get the stores satisfying the criteria
                    filteredStores = distanceService.callDistanceImpl(selectionCriterionType,storeListForCriteria,nodeDetails,orderRequest);
                    break;

                case node_cost:
                    //call node cost service to get the stores satisfying the criteria
                    return filteredStores;
            }
        }
        return filteredStores;
    }

}
