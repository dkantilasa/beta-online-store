package com.drs.springboot.betaonlinestore.controller;

import com.drs.springboot.betaonlinestore.dto.SuccessResponse;
import com.drs.springboot.betaonlinestore.dto.req.ReqParamCart;
import com.drs.springboot.betaonlinestore.dto.req.ReqParamOrder;
import com.drs.springboot.betaonlinestore.service.OrderSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    @Autowired
    private OrderSvc orderSvc;


    @PostMapping("/makeOrder")
    public ResponseEntity<SuccessResponse<String>> makeOrder(@RequestBody ReqParamOrder.ReqMakeOrder param){
        return ResponseEntity.ok(new SuccessResponse<>("Success",orderSvc.makeOrder(param)));
    }

    @PostMapping("/cancelOrder")
    public ResponseEntity<SuccessResponse<String>> makeOrder(@RequestBody ReqParamOrder.ReqDeleteOrder param){
        return ResponseEntity.ok(new SuccessResponse<>("Success",orderSvc.deleteOrder(param)));
    }


}
