package com.movoto.movoto.Buy.Payload;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PropertyWithImagesDTO {
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
    private String propertyType;
    private String description;
    private List<ImageDTO> images;

    @Data
    public static class ImageDTO {
        private Long id;
        private String name;
        private String type;
        private byte[] data;
    }
}