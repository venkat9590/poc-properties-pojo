package com.perfaware.sourcing.service.criterias.comparators;

import com.perfaware.sourcing.service.criterias.comparators.impl.CriteriaComparatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriteriaComparatorService {

    private CriteriaComparatorContext criteriaComparatorContext;

    @Autowired
    public CriteriaComparatorService(CriteriaComparatorContext criteriaComparatorContext){
        this.criteriaComparatorContext = criteriaComparatorContext;
    }

    public CriteriaComparators fetchComparatorImpl(String comparatorType){

        switch(ComparatorType.getFromValue(comparatorType)){

            case LESS_THAN:
                return criteriaComparatorContext.getLessThanCriteriaComparator();

            case GREATER_THAN:
                return criteriaComparatorContext.getGreaterThanCriteriaComparator();

            case EQUAL:
                return criteriaComparatorContext.getEqualCriteriaComparator();
        }

        return criteriaComparatorContext.getEqualCriteriaComparator();
    }

}
