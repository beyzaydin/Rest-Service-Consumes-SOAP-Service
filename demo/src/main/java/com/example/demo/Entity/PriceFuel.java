package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "price_fuel"/*, indexes = @Index(columnList = "")*/)
public class PriceFuel {
    @Id
    @GeneratedValue
    private String id;

    @org.springframework.format.annotation.DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate priceDate;

    private String fuelType;
    private String city;
    private String firmName;
    private Long price;
}