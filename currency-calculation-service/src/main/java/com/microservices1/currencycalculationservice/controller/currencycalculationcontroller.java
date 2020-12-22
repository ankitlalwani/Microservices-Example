package com.microservices1.currencycalculationservice.controller;

import com.microservices1.currencycalculationservice.bean.CalculatedAmount;
import com.microservices1.currencycalculationservice.facade.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class currencycalculationcontroller {


    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount CalculateAmount(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CalculatedAmount> responseEntity = new RestTemplate().getForEntity(("http://localhost:8001/currency-exchange/from/{from}/to/{to}"),
        CalculatedAmount.class,uriVariables);

        CalculatedAmount calculatedAmount = responseEntity.getBody();

        return new CalculatedAmount(calculatedAmount.getId(),calculatedAmount.getFrom(),calculatedAmount.getTo(),calculatedAmount.getPort(),
                calculatedAmount.getconversionMultiple(),quantity,quantity.multiply(calculatedAmount.getconversionMultiple()));
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount CalculateAmountFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CalculatedAmount calculatedAmount = currencyExchangeProxy.retrieveExchangeValue(from,to);

        return new CalculatedAmount(calculatedAmount.getId(),calculatedAmount.getFrom(),calculatedAmount.getTo(),calculatedAmount.getPort(),
                calculatedAmount.getconversionMultiple(),quantity,quantity.multiply(calculatedAmount.getconversionMultiple()));
    }
}
