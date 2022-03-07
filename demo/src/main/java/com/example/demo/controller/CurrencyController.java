package com.example.demo.controller;

import com.example.demo.Entity.CurrencyEntity;
import com.example.demo.dto.CurrencyModel;
import com.example.demo.service.CurrencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;
import java.util.Map;

@Validated
@RequestMapping("/currency")
@RestController
public class CurrencyController {
    private final CurrencyService cService;
    private final DefaultController defaultController;


    @Autowired
    public CurrencyController(CurrencyService cService, DefaultController defaultController) {
        this.cService = cService;
        this.defaultController = defaultController;
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> forwardRequest(final HttpServletRequest request) {
        return defaultController.forwardRequest(request);
    }

    @GetMapping("/today")
    public List<CurrencyModel> currencyToday() {
        return cService.getTodayCurrency();
    }

    @GetMapping("/{date}")
    public List<CurrencyModel> currencyDate(@PathVariable @NotNull @NumberFormat @Size(min = 8, max = 8) String date) {
        return cService.getDateCurrency(date);
    }

    @GetMapping("/between")
    @ResponseBody
    public Page<CurrencyEntity> getBetweenPage(@RequestParam(name = "start") String startDate,
                                               @RequestParam(name = "end") String endDate,
                                               @RequestParam(name = "page", defaultValue = "0") int page,
                                               @RequestParam(name = "size", defaultValue = "20") int size) {
        startDate = startDate.replaceAll("[^0-9]", "");
        endDate = endDate.replaceAll("[^0-9]", "");
        return cService.getDateBetween(startDate, endDate, page, size);
    }

   /* @GetMapping("/soap")
    @ResponseBody
    public void getSoap(/*@RequestParam(name = "sorguNo") long sorguNo,
                                               @RequestParam(name = "parametre") List<String> parametre) {

    }*/
}