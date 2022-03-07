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
@Table(name = "query_fuel", indexes = @Index(columnList = "queryDate"))
public class QueryFuel {
    @Id
    @GeneratedValue
    private Long id;

    @org.springframework.format.annotation.DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate queryDate;

    private Integer city;
}
