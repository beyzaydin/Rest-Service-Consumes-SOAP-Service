package com.example.demo.service;

import com.example.demo.Entity.CurrencyEntity;
import com.example.demo.dto.CurrencyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final DbService dbService;

    @Autowired
    public CurrencyServiceImpl(DbService dbService) {
        this.dbService = dbService;
    }

    @Override
    public List<CurrencyModel> getTodayCurrency() {
        if (dbService.isEmpty(LocalDate.now())) {
            dbService.saveToday();
        }
        return dbService.getDate(LocalDate.now());
    }

    @Override
    public List<CurrencyModel> getDateCurrency(String date) {
        LocalDate localDate = transformDate(date);
        if (dbService.isEmpty(localDate)) {
            dbService.saveDate(localDate);
        }
        return dbService.getDate(localDate);
    }

    @Override
    public Page<CurrencyEntity> getDateBetween(String startDate, String endDate, int page, int size) {
        LocalDate start = transformDate(startDate);
        LocalDate end = transformDate(endDate);

        return dbService.getDateBetween(start, end, page, size);
    }

    private LocalDate transformDate(String date) {
        date = date.substring(0,2) +"-"+ date.substring(2,4)+"-"+ date.substring(4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }
}
