package com.perfaware.sourcing.service.criterias.distance;

import com.perfaware.sourcing.model.request.Order;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;
import com.perfaware.sourcing.persistence.type.SelectionCriterionType;
import com.perfaware.sourcing.service.criterias.comparators.ComparatorType;
import com.perfaware.sourcing.service.criterias.comparators.CriteriaComparatorService;
import com.perfaware.sourcing.service.criterias.comparators.CriteriaComparators;
import com.perfaware.sourcing.util.constants.SourcingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@PropertySource("classpath:criteria-${spring.profiles.active}.properties")
public class DistanceService {

    @Value("${distance.integ.enabled}")
    private String isDistanceIntegEnabled;

    @Value("#{'${distance.criteria.impl.package}'+'.'+'${distance.offline.integ.class}'}")
    private String offlineIntegClass;

    @Value("#{'${distance.criteria.impl.package}'+'.'+'${distance.online.integ.class}'}")
    private String onlineIntegClass;

    private DistanceStrategyContext distanceStrategyContext;
    private CriteriaComparatorService criteriaComparatorService;
    private CriteriaComparators criteriaComparators;

    @Autowired
    DistanceService(CriteriaComparatorService criteriaComparatorService){
        this.criteriaComparatorService=criteriaComparatorService;
    }

    Predicate<SelectionCriterionType> distanceSelectionCriteria = criteria -> SourcingConstants.DISTANCE.equalsIgnoreCase(criteria.getParameterName());

    public List<String> callDistanceImpl(List<SelectionCriterionType> selectionCriterionType, List<String> storeListForCriteria, Map<String, ShipNodeTable> nodeDetails, Order orderRequest){

        List<String> filteredStoresOnDistance = new ArrayList<>();
        Optional<SelectionCriterionType> distanceCriteria = selectionCriterionType.stream().filter(distanceSelectionCriteria).findAny();
        System.out.println("Comparatr: "+ComparatorType.getFromValue(distanceCriteria.get().getQueryType()));
        criteriaComparators = criteriaComparatorService.fetchComparatorImpl(distanceCriteria.get().getQueryType());

        try{
            if("N".equalsIgnoreCase(isDistanceIntegEnabled)){
                //call haversine for each store details.
                this.distanceStrategyContext = new DistanceStrategyContext(offlineIntegClass);
                for(String storeId:storeListForCriteria){

                    BigDecimal distanceBD = distanceStrategyContext.executeDistanceCalculations(nodeDetails.get(storeId),orderRequest.getPersonInfoShipTo());
                    System.out.println("distance for Store: "+storeId+" distance is: "+distanceBD);
                    System.out.println("");
                    if(distanceCriteria.isPresent() && criteriaComparators.decimalComparisons(BigDecimal.valueOf(distanceCriteria.get().getParameterValue()),distanceBD)){
                        filteredStoresOnDistance.add(storeId);
                    }
                }

            }
        }
        catch(Exception ex){

        }

        return filteredStoresOnDistance;
    }


}
