package com.example.demo.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Currency")
public class CurrencyModel {
    @JacksonXmlProperty(localName = "CrossOrder", isAttribute = true)
    private int crossOrder;

    @JacksonXmlProperty(localName = "Kod", isAttribute = true)
    private String kod;

    @JacksonXmlProperty(localName = "CurrencyCode", isAttribute = true)
    private String currencyCode;

    @JacksonXmlProperty(localName = "Unit")
    private int unit;

    @JacksonXmlProperty(localName = "Isim")
    private String name;

    @JacksonXmlProperty(localName = "CurrencyName")
    private String currencyName;

    @JacksonXmlProperty(localName = "ForexBuying")
    private float forexBuying;

    @JacksonXmlProperty(localName = "ForexSelling")
    private float forexSelling;

    @JacksonXmlProperty(localName = "BanknoteBuying")
    private float banknoteBuying;

    @JacksonXmlProperty(localName = "BanknoteSelling")
    private float banknoteSelling;

    @JacksonXmlProperty(localName = "CrossRateUSD")
    private float crossRateUSD;

    @JacksonXmlProperty(localName = "CrossRateOther")


    private float crossRateOther;

    public int getCrossOrder() {
        return crossOrder;
    }

    public void setCrossOrder(int crossOrder) {
        this.crossOrder = crossOrder;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public float getForexBuying() {
        return forexBuying;
    }

    public void setForexBuying(float forexBuying) {
        this.forexBuying = forexBuying;
    }

    public float getForexSelling() {
        return forexSelling;
    }

    public void setForexSelling(float forexSelling) {
        this.forexSelling = forexSelling;
    }

    public float getBanknoteBuying() {
        return banknoteBuying;
    }

    public void setBanknoteBuying(float banknoteBuying) {
        this.banknoteBuying = banknoteBuying;
    }

    public float getBanknoteSelling() {
        return banknoteSelling;
    }

    public void setBanknoteSelling(float banknoteSelling) {
        this.banknoteSelling = banknoteSelling;
    }

    public float getCrossRateUSD() {
        return crossRateUSD;
    }

    public void setCrossRateUSD(float crossRateUSD) {
        this.crossRateUSD = crossRateUSD;
    }

    public float getCrossRateOther() {
        return crossRateOther;
    }

    public void setCrossRateOther(float crossRateOther) {
        this.crossRateOther = crossRateOther;
    }

    public CurrencyModel() {

    }

}
