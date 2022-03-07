package com.example.demo.service;

import com.example.demo.Entity.CurrencyEntity;
import com.example.demo.dto.CurrencyModel;
import com.example.demo.dto.ReturnModel;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface DbService {

    void saveToday();

    void saveDate(LocalDate date);

    boolean isEmpty(LocalDate date);

    ReturnModel xmlDeseriliazier(String url);

    List<CurrencyModel> getDate(LocalDate date);

    Page<CurrencyEntity> getDateBetween(LocalDate start, LocalDate end, int page, int size);

}
