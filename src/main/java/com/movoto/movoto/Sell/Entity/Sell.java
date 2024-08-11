package com.movoto.movoto.Sell.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sell")
public class Sell {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String propertyType;
    private String propertyAddress;
    private String contact;
    private long price;

}
