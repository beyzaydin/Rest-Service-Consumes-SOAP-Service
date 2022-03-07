package com.example.demo.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "Tarih_Date")
public class ReturnModel {

    @JacksonXmlProperty(localName = "Tarih", isAttribute = true)
    private String tDate;

    @JacksonXmlProperty(localName = "Date", isAttribute = true)
    private String date;

    @JacksonXmlProperty(localName = "Bulten_No", isAttribute = true)
    private String bultenNo;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Currency")
    private List<CurrencyModel> currencyList;

    public ReturnModel(String tDate, String date, String bultenNo) {
        this.tDate = tDate;
        this.date = date;
        this.bultenNo = bultenNo;
    }

    public ReturnModel() {

    }

    public String gettDate() {
        return tDate;
    }

    public void settDate(String tDate) {
        this.tDate = tDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBultenNo() {
        return bultenNo;
    }

    public void setBultenNo(String bultenNo) {
        this.bultenNo = bultenNo;
    }

    public List<CurrencyModel> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<CurrencyModel> currencyList) {
        this.currencyList = currencyList;
    }
}
