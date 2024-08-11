package com.movoto.movoto.Buy.Repository;

import com.movoto.movoto.Buy.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByCityAndState(String city, String state);
    List<Property> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Property> findByBedroomsGreaterThanEqual(int bedrooms);

    @Query("SELECT p FROM Property p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.address) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.city) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.state) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.zipCode) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(CAST(p.price AS string)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(CAST(p.bedrooms AS string)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(CAST(p.bathrooms AS string)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(CAST(p.squareFeet AS string)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.propertyType) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Property> searchBykey(String keyword);
}

