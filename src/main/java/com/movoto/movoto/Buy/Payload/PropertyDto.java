package com.movoto.movoto.Buy.Payload;

import com.movoto.movoto.Buy.Entity.Agent;
import com.movoto.movoto.Buy.Entity.PropertyImage;
import com.movoto.movoto.Buy.Entity.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private BigDecimal price;
    private int bedrooms;
    private int bathrooms;
    private int squareFeet;
    private PropertyType propertyType;
    private String description;
    private List<PropertyImage> images;
    private List<Agent> agents;

}
