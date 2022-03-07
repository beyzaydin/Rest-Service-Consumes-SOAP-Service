package com.example.demo.service;

import com.example.demo.Entity.CurrencyEntity;
import com.example.demo.dto.CurrencyModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CurrencyService {

    List<CurrencyModel> getTodayCurrency();

    List<CurrencyModel> getDateCurrency(String date);

    Page<CurrencyEntity> getDateBetween(String startDate, String endDate, int page, int size);

}

