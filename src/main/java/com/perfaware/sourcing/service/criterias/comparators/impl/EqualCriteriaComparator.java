package com.perfaware.sourcing.service.criterias.comparators.impl;

import com.perfaware.sourcing.service.criterias.comparators.CriteriaComparators;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EqualCriteriaComparator implements CriteriaComparators {

    @Override
    public boolean decimalComparisons(BigDecimal bd1, BigDecimal bd2) {
        return bd1.compareTo(bd2)==0?true:false;
    }

}