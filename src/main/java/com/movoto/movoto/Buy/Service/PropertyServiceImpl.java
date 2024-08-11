package com.movoto.movoto.Buy.Service;

import com.movoto.movoto.Buy.Entity.Property;
import com.movoto.movoto.Buy.Entity.PropertyImage;
import com.movoto.movoto.Buy.Exception.ResourceNotFoundException;
import com.movoto.movoto.Buy.Payload.PropertyDto;
import com.movoto.movoto.Buy.Payload.PropertyWithImagesDTO;
import com.movoto.movoto.Buy.Repository.PropertyImageRepository;
import com.movoto.movoto.Buy.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepo;

    @Autowired
    private PropertyImageRepository propertyImageRepository;


    @Override
    public String addProperty(PropertyDto propertyDto) {
          Property property=new Property();

        property.setTitle(propertyDto.getTitle());
        property.setAddress(propertyDto.getAddress());
        property.setCity(propertyDto.getCity());
        property.setState(propertyDto.getState());
        property.setZipCode(propertyDto.getZipCode());
        property.setPrice(propertyDto.getPrice());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setBathrooms(propertyDto.getBathrooms());
        property.setSquareFeet(propertyDto.getSquareFeet());
        property.setPropertyType(propertyDto.getPropertyType());
        property.setDescription(propertyDto.getDescription());

        // Save the property to the database
        Property save = propertyRepo.save(property);

        // Return a success message or the ID of the saved property
        if(save!=null) {
            return "Property added successfully with ID: " + property.getId();
        }
        else {
            return "Property Failed to  add";
        }
    }


//    @Override
//    public PropertyImage addPropertyImage(Long propertyId, MultipartFile file) throws Exception {
//        // Check if the property exists
//        Optional<Property> propertyOptional = propertyRepo.findById(propertyId);
//        if (!propertyOptional.isPresent()) {
//            throw new Exception("Property not found");
//        }
//
//        // Get the property from the Optional
//        Property property = propertyOptional.get();
//
//        // Extract image details from the MultipartFile
//        String imageName = file.getOriginalFilename();
//        String imageType = file.getContentType();
//        byte[] imageData = file.getBytes();
//
//        // Check data size
//        System.out.println("Image data size: " + imageData.length);
//
//        // Create a new PropertyImage instance and set its properties
//        PropertyImage propertyImage = new PropertyImage();
//        propertyImage.setName(imageName);  // Set image name
//        propertyImage.setType(imageType);  // Set image type
//        propertyImage.setData(imageData);  // Set image data
//        propertyImage.setProperty(property);  // Associate with the property
//
//        // Save the PropertyImage to the database
//        return propertyImageRepository.save(propertyImage);
//    }





    @Override
    public List<Property> getProperties(String city, String state) {
        return propertyRepo.findByCityAndState(city, state);
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found"));
    }

//    @Override
//    public PropertyWithImagesDTO getPropertyWithImages(Long id) {
//        Property property = getPropertyById(id);
//        List<PropertyWithImagesDTO.ImageDTO> imageDTOs = property.getImages().stream()
//                .map(image -> {
//                    PropertyWithImagesDTO.ImageDTO imageDTO = new PropertyWithImagesDTO.ImageDTO();
//                    imageDTO.setId(image.getId());
//                    imageDTO.setName(image.getName());
//                    imageDTO.setType(image.getType());
//                    imageDTO.setData(image.getData());
//                    return imageDTO;
//                })
//                .collect(Collectors.toList());
//
//        PropertyWithImagesDTO dto = new PropertyWithImagesDTO();
//        dto.setId(property.getId());
//        dto.setTitle(property.getTitle());
//        dto.setAddress(property.getAddress());
//        dto.setCity(property.getCity());
//        dto.setState(property.getState());
//        dto.setZipCode(property.getZipCode());
//        dto.setPrice(property.getPrice());
//        dto.setBedrooms(property.getBedrooms());
//        dto.setBathrooms(property.getBathrooms());
//        dto.setSquareFeet(property.getSquareFeet());
//        dto.setPropertyType(property.getPropertyType().toString());
//        dto.setDescription(property.getDescription());
//        dto.setImages(imageDTOs);
//
//        return dto;
//    }

    @Override
    public List<Property> searchProperty(String keyword) {

       return  propertyRepo.searchBykey(keyword);
    }

    // Additional methods for filtering, sorting, etc.
}

