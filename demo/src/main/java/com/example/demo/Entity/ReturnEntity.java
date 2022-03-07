package com.example.demo.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "return_types")
public class ReturnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @org.springframework.format.annotation.DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate tDate;

    private String bultenNo;

    public ReturnEntity() {

    }

    public ReturnEntity(LocalDate tDate, String bultenNo) {
        this.tDate = tDate;
        this.bultenNo = bultenNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate gettDate() {
        return tDate;
    }

    public void settDate(LocalDate tDate) {
        this.tDate = tDate;
    }

    public String getBultenNo() {
        return bultenNo;
    }

    public void setBultenNo(String bultenNo) {
        this.bultenNo = bultenNo;
    }

}
