package com.perfaware.sourcing.service.criterias.comparators.impl;

import com.perfaware.sourcing.service.criterias.comparators.impl.EqualCriteriaComparator;
import com.perfaware.sourcing.service.criterias.comparators.impl.GreaterThanCriteriaComparator;
import com.perfaware.sourcing.service.criterias.comparators.impl.LessThanCriteriaComparator;
import com.perfaware.sourcing.util.common.exception.ExceptionType;
import com.perfaware.sourcing.util.common.exception.SourcingException;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Data
@Configuration
@PropertySource("classpath:criteria-${spring.profiles.active}.properties")
public class CriteriaComparatorContext {

    @Value("#{'${criteria.comparator.impl.package}'+'.'+'${criteria.comparator.lessthan}'}")
    private String lessThanClass;

    @Value("#{'${criteria.comparator.impl.package}'+'.'+'${criteria.comparator.greaterthan}'}")
    private String greaterThanClass;

    @Value("#{'${criteria.comparator.impl.package}'+'.'+'${criteria.comparator.equal}'}")
    private String equalClass;

    private LessThanCriteriaComparator lessThanCriteriaComparator;
    private GreaterThanCriteriaComparator greaterThanCriteriaComparator;
    private EqualCriteriaComparator equalCriteriaComparator;

    @SneakyThrows
    @PostConstruct
    public void setComparators(){

        try{
            lessThanCriteriaComparator = (LessThanCriteriaComparator) Class.forName(lessThanClass).newInstance();
            greaterThanCriteriaComparator = (GreaterThanCriteriaComparator) Class.forName(greaterThanClass).newInstance();
            equalCriteriaComparator = (EqualCriteriaComparator) Class.forName(equalClass).newInstance();
        }catch(ClassNotFoundException classNotFoundException){
            throw new SourcingException(ExceptionType.SRC_CRITERIA_EX_DIS_CLASS.getExMessage());
        }
        catch(ClassCastException classCastException){
            throw new SourcingException(ExceptionType.CLASS_CAST_EX.getExMessage()+lessThanClass+"or"+greaterThanClass+"or"+equalClass);
        }

    }

}
