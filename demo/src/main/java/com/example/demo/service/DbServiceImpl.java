package com.example.demo.service;

import com.example.demo.Entity.CurrencyEntity;
import com.example.demo.Entity.QCurrencyEntity;
import com.example.demo.Entity.ReturnEntity;
import com.example.demo.dto.CurrencyModel;
import com.example.demo.dto.ModelToEntity;
import com.example.demo.dto.ReturnModel;
import com.example.demo.repository.CurrencyRepository;
import com.example.demo.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.querydsl.core.types.Predicate;

import java.net.URI;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DbServiceImpl implements DbService {
    private final CurrencyRepository currencyRepository;
    private final ReturnRepository returnRepository;
    private final RestTemplate restTemplate;


    @Value("${urls.today}")
    private String url;

    @Autowired
    public DbServiceImpl(CurrencyRepository currencyRepository,
                         ReturnRepository returnRepository,
                         RestTemplate restTemplate) {
        this.currencyRepository = currencyRepository;
        this.returnRepository = returnRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void saveToday() {
        if (isEmpty(LocalDate.now()))
            save(url + "today.xml");
    }

    @Override
    public void saveDate(LocalDate localDate) {
        String date = localDate.toString();

        String day = date.substring(8);
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String datePath = year + month + "/" + day + month + year + ".xml";

        if (isEmpty(localDate))
            save(url + datePath);
    }

    private void save(String url) {
        ReturnModel ret = xmlDeseriliazier(url);
        ReturnEntity retEntity = ModelToEntity.convertModelToEntityReturn(ret);

        returnRepository.save(retEntity);

        List<CurrencyEntity> list = ModelToEntity.convertModelToEntityCurrency(ret);
        for (CurrencyEntity curr : list) {
            currencyRepository.save(curr);
        }
    }

    public List<CurrencyModel> getDate(LocalDate date) {
        QCurrencyEntity currencyEntity = QCurrencyEntity.currencyEntity;
        Predicate isDateEqual = currencyEntity.tDate.eq(date);
        Iterable currencyEntities = currencyRepository.findAll(isDateEqual);

        return ModelToEntity.convertEntityToModelCurrency(currencyEntities);
    }

    @Override
    public Page<CurrencyEntity> getDateBetween(LocalDate start, LocalDate end, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("tDate").ascending());

        long numOfDaysBetween = ChronoUnit.DAYS.between(start, end);
        List<LocalDate> dates = IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(start::plusDays)
                .collect(Collectors.toList());

        for (LocalDate d : dates) {
            try {
                if (isEmpty(d))
                    saveDate(d);
            } catch (HttpClientErrorException e) {
            }
        }

        QCurrencyEntity currencyEntity = QCurrencyEntity.currencyEntity;
        Predicate isDateBetween = currencyEntity.tDate.between(start, end);
        Page<CurrencyEntity> currencyEntities = currencyRepository.findAll(isDateBetween, pageRequest);
        return currencyEntities;
        /*System.out.println(currencyEntities.getTotalPages());
        return ModelToEntity.convertEntityToModelCurrency(currencyEntities);*/
    }


    public ReturnModel xmlDeseriliazier(String url) {
        HttpHeaders headers = new HttpHeaders();
        RequestEntity<ReturnModel> returnModelRequestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));
        ParameterizedTypeReference<ReturnModel> typeRef = new ParameterizedTypeReference<ReturnModel>() {
        };
        ResponseEntity<ReturnModel> resEntity = restTemplate.exchange(returnModelRequestEntity, typeRef);

        return resEntity.getBody();
    }

    public boolean isEmpty(LocalDate date) {
        return getDate(date).isEmpty();
    }

}
