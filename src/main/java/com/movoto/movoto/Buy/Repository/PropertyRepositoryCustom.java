package com.movoto.movoto.Buy.Repository;

import com.movoto.movoto.Buy.Entity.Property;
import com.movoto.movoto.Buy.Entity.PropertyType;

import java.math.BigDecimal;
import java.util.List;

public interface PropertyRepositoryCustom {
    List<Property> findPropertiesWithFilters(String city, String state, BigDecimal minPrice, BigDecimal maxPrice,
                                             int bedrooms, int bathrooms, PropertyType propertyType, int minSquareFeet);
}