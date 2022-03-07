package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "flags", indexes = @Index(columnList = "kod"))
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] flag;

    private String kod;

    public ImageEntity(byte[] flag, String code) {
        this.flag = flag;
        this.kod = code;
    }
}