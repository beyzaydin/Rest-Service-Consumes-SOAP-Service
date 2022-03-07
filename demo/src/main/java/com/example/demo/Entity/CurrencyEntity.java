package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "currencies", indexes = @Index(columnList = "tDate"))
public class CurrencyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String kod;

    @org.springframework.format.annotation.DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate tDate;

    private String currencyCode;
    private int crossOrder;
    private String currencyName;
    private Integer unit;
    private String isim;
    private Float forexBuying;
    private Float forexSelling;
    private Float banknoteBuying;
    private Float banknoteSelling;
    private Float crossRateUSD;
    private Float crossRateOther;

    public CurrencyEntity(String kod, LocalDate tDate,
                          String currencyCode, int crossOrder,
                          String currencyName,
                          Integer unit, String isim,
                          Float forexBuying, Float forexSelling,
                          Float banknoteBuying, Float banknoteSelling,
                          Float crossRateUSD, Float crossRateOther) {
        this.kod = kod;
        this.tDate = tDate;
        this.currencyCode = currencyCode;
        this.crossOrder = crossOrder;
        this.currencyName = currencyName;
        this.unit = unit;
        this.isim = isim;
        this.forexBuying = forexBuying;
        this.forexSelling = forexSelling;
        this.banknoteBuying = banknoteBuying;
        this.banknoteSelling = banknoteSelling;
        this.crossRateUSD = crossRateUSD;
        this.crossRateOther = crossRateOther;
    }

}
