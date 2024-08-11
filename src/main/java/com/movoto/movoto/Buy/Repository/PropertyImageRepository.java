package com.movoto.movoto.Buy.Repository;


import com.movoto.movoto.Buy.Entity.PropertyImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.Optional;

public interface PropertyImageRepository extends JpaRepository<PropertyImage, Long> {

}
