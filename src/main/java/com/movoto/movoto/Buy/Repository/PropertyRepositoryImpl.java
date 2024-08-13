package com.movoto.movoto.Buy.Repository;

import com.movoto.movoto.Buy.Entity.Property;
import com.movoto.movoto.Buy.Entity.PropertyType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropertyRepositoryImpl implements PropertyRepositoryCustom  {

    private final EntityManager entityManager;

    public PropertyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   @Override
    public List<Property> findPropertiesWithFilters(String city, String state, BigDecimal minPrice, BigDecimal maxPrice,
                                                    int bedrooms, int bathrooms, PropertyType propertyType, int minSquareFeet) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> query = cb.createQuery(Property.class);
        Root<Property> property = query.from(Property.class);

        List<Predicate> predicates = new ArrayList<>();

        if (city != null) {
            predicates.add(cb.equal(property.get("city"), city));
        }
        if (state != null) {
            predicates.add(cb.equal(property.get("state"), state));
        }
        if (minPrice != null && maxPrice != null) {
            predicates.add(cb.between(property.get("price"), minPrice, maxPrice));
        }
        if (bedrooms > 0) {
            predicates.add(cb.greaterThanOrEqualTo(property.get("bedrooms"), bedrooms));
        }
        if (bathrooms > 0) {
            predicates.add(cb.greaterThanOrEqualTo(property.get("bathrooms"), bathrooms));
        }
        if (propertyType != null) {
            predicates.add(cb.equal(property.get("propertyType"), propertyType));
        }
        if (minSquareFeet > 0) {
            predicates.add(cb.greaterThanOrEqualTo(property.get("squareFeet"), minSquareFeet));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
