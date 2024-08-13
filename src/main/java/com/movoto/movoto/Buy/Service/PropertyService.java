package com.movoto.movoto.Buy.Service;

import com.movoto.movoto.Buy.Entity.Property;
import com.movoto.movoto.Buy.Entity.PropertyImage;
import com.movoto.movoto.Buy.Entity.PropertyType;
import com.movoto.movoto.Buy.Payload.PropertyDto;
import com.movoto.movoto.Buy.Payload.PropertyWithImagesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public interface PropertyService {

    public String addProperty(PropertyDto propertydto);
    public List<Property> getProperties(String city, String state);
    public Property getPropertyById(Long id);
  //  public PropertyImage addPropertyImage(Long propertyId, MultipartFile file) throws Exception;
    //public PropertyWithImagesDTO getPropertyWithImages(Long id);
    public List<Property>  searchProperty( String keyword);
    public List<Property> filterProperties(String city, String state, BigDecimal minPrice, BigDecimal maxPrice,
                                           int bedrooms, int bathrooms, PropertyType propertyType, int minSquareFeet);
}
