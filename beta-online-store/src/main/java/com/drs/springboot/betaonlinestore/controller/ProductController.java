package com.drs.springboot.betaonlinestore.controller;

import com.drs.springboot.betaonlinestore.dao.Product;
import com.drs.springboot.betaonlinestore.dto.CurrencyConversion;
import com.drs.springboot.betaonlinestore.dto.SuccessResponse;
import com.drs.springboot.betaonlinestore.dto.req.ReqParamProduct;
import com.drs.springboot.betaonlinestore.service.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    @Autowired
    private ProductSvc productSvc;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/product")
    public ResponseEntity<SuccessResponse<List<Product>>> getAllProduct(){
        return ResponseEntity.ok(new SuccessResponse<>("Success",productSvc.retrieveAllProduct()));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<SuccessResponse<List<Product>>> getProductByid(@PathVariable long id){
        return ResponseEntity.ok(new SuccessResponse<>("Success",productSvc.getProductById(id)));
    }

    @GetMapping("/convertProduct/productId/{productId}/to/{to}")
    public ResponseEntity<SuccessResponse<List<Product>>> convertProduct(@PathVariable long productId,@PathVariable String to){
        List<Product> res = productSvc.getProductById(productId);
        Map<String,String> uriVariables= new HashMap<>();
        uriVariables.put("from","USD");
        uriVariables.put("to",to);
        uriVariables.put("quantity",String.valueOf(res.get(0).getPrice()));
        ResponseEntity<CurrencyConversion> responseEntity =  restTemplate.
                getForEntity("http://localhost:8100/currency-conversion/from/{from}/to/{to}/quantity/{quantity}",
                        CurrencyConversion.class,
                        uriVariables);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        res.get(0).setPrice(currencyConversion.getTotalCalculatedAmount());


        return ResponseEntity.ok(new SuccessResponse<>("Success", res));
    }
}
