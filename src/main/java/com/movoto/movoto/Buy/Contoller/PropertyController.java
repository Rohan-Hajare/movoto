package com.movoto.movoto.Buy.Contoller;

import com.movoto.movoto.Buy.Entity.Property;
import com.movoto.movoto.Buy.Entity.PropertyImage;
import com.movoto.movoto.Buy.Payload.PropertyDto;
import com.movoto.movoto.Buy.Payload.PropertyWithImagesDTO;
import com.movoto.movoto.Buy.Service.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("movoto/properties")
public class PropertyController {
    @Autowired
    private PropertyServiceImpl propertyService;

    @PostMapping("/add")
    public ResponseEntity<String> addProperty(@RequestBody PropertyDto propertyDto)
    {
        String s = propertyService.addProperty(propertyDto);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }


//    @PostMapping("/{propertyId}/images")
//    public ResponseEntity<String> uploadPropertyImage(@PathVariable Long propertyId, @RequestParam("file") MultipartFile file) {
//        try {
//            PropertyImage propertyImage = propertyService.addPropertyImage(propertyId, file);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Image uploaded successfully: " + propertyImage.getUrl());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
//        }
//    }

    @GetMapping
    public ResponseEntity<List<Property>> getProperties(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state
    ) {
        List<Property> properties = propertyService.getProperties(city, state);
        return ResponseEntity.ok(properties);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        return ResponseEntity.ok(property);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PropertyWithImagesDTO> getPropertyWithImagesById(@PathVariable Long id) {
//        PropertyWithImagesDTO propertyWithImages = propertyService.getPropertyWithImages(id);
//
//        return ResponseEntity.ok(propertyWithImages);
//
//    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Property> > searchProperty(@PathVariable String keyword)
    {
           List<Property> properties = propertyService.searchProperty(keyword);

            return new ResponseEntity<>(properties,HttpStatus.OK);

    }

}