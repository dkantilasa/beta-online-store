package com.drs.springboot.betaonlinestore.service;

import com.drs.springboot.betaonlinestore.dto.req.ReqParamOrder;
import com.drs.springboot.betaonlinestore.repo.CartRepo;
import com.drs.springboot.betaonlinestore.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

@Service
public class OrderSvc {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CartRepo cartRepo;

    public String makeOrder(ReqParamOrder.ReqMakeOrder param){
        String generateUUIDNo = String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
        long orderId = Long.parseLong(generateUUIDNo.substring( generateUUIDNo.length() - 10));
        int status = 0;
        int price = orderRepo.getTotalPrice(param.getUserId());
        StringBuilder sb = new StringBuilder();

        try{
            orderRepo.makeOrder(orderId,param.getUserId(),status,price);
            sb.append("Order berhasil dibuat");
            cartRepo.removeAll(param.getUserId());
        }catch (Exception e){
            System.out.println(e);
            sb.append(e);
        }

        return sb.toString();

    }

    public String deleteOrder(ReqParamOrder.ReqDeleteOrder param){
        // ADD DATA TO TABLE ORDER HISTORY
        StringBuilder sb = new StringBuilder();
        try{
            orderRepo.deleteOrder(param.getOrderId());
            sb.append("Order berhasil dibatalkan");
        }catch (Exception e){
            System.out.println(e);
            sb.append(e);
        }
        return sb.toString();

    }
}
