package com.example.demo.dto;

import com.example.demo.Entity.CurrencyEntity;
import com.example.demo.Entity.ReturnEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ModelToEntity {

    public static ReturnModel convertEntityToModelReturn(ReturnEntity returnEntity, List<CurrencyEntity> list) {
        ReturnModel retModel = new ReturnModel(returnEntity.gettDate().toString(), returnEntity.gettDate().toString(), returnEntity.getBultenNo());
        retModel.setCurrencyList(convertEntityToModelCurrency(list));
        return retModel;
    }


    public static List<CurrencyModel> convertEntityToModelCurrency(Iterable<CurrencyEntity> listParam) {
        List<CurrencyModel> list = new ArrayList<>();

        for (CurrencyEntity curr : listParam) {
            CurrencyModel toBeAdded = new CurrencyModel();
            toBeAdded.setKod(curr.getKod());
            toBeAdded.setCurrencyCode(curr.getCurrencyCode());
            toBeAdded.setCrossOrder(curr.getCrossOrder());
            toBeAdded.setCurrencyName(curr.getCurrencyName());
            toBeAdded.setUnit(curr.getUnit());
            toBeAdded.setName(curr.getIsim());
            toBeAdded.setForexBuying(curr.getForexBuying());
            toBeAdded.setForexSelling(curr.getForexSelling());
            toBeAdded.setBanknoteBuying(curr.getBanknoteBuying());
            toBeAdded.setBanknoteSelling(curr.getBanknoteSelling());
            toBeAdded.setCrossRateUSD(curr.getCrossRateUSD());
            toBeAdded.setCrossRateOther(curr.getCrossRateOther());

            list.add(toBeAdded);
        }
        return list;
    }


    public static ReturnEntity convertModelToEntityReturn(ReturnModel returnModel) {
        LocalDate localDate = transformDate(returnModel.gettDate());

        return new ReturnEntity(localDate, returnModel.getBultenNo());
    }

    public static List<CurrencyEntity> convertModelToEntityCurrency(ReturnModel returnModel) {
        List<CurrencyEntity> list = new ArrayList<>();
        LocalDate localDate = transformDate(returnModel.gettDate());
        for (CurrencyModel curr : returnModel.getCurrencyList()) {
            list.add(new CurrencyEntity(curr.getKod(),
                    localDate, curr.getCurrencyCode(), curr.getCrossOrder(),
                    curr.getCurrencyName(), curr.getUnit(),
                    curr.getName(), curr.getForexBuying(),
                    curr.getForexSelling(), curr.getBanknoteBuying(),
                    curr.getBanknoteSelling(), curr.getCrossRateUSD(),
                    curr.getCrossRateOther()));
        }
        return list;
    }

    private static LocalDate transformDate(String date) {
        date = date.substring(0, 2) + "-" + date.substring(3, 5) + "-" + date.substring(6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }
}