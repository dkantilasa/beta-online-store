package com.drs.springboot.betaonlinestore.controller;

import com.drs.springboot.betaonlinestore.dao.Cart;
import com.drs.springboot.betaonlinestore.dao.Product;
import com.drs.springboot.betaonlinestore.dto.SuccessResponse;
import com.drs.springboot.betaonlinestore.dto.req.ReqParamCart;
import com.drs.springboot.betaonlinestore.service.CartSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CartController {
    @Autowired
    private CartSvc cartSvc;

    @PostMapping("/addToCart")
    public ResponseEntity<SuccessResponse<String>> addToCart(@RequestBody ReqParamCart.ReqAddToCart param){
        return ResponseEntity.ok(new SuccessResponse<>("Success",cartSvc.insertToCart(param)));
    }

    @PostMapping("/removeFromCart/{cartId}")
    public ResponseEntity<SuccessResponse<String>> removerFromCart(@PathVariable long cartId){
        return ResponseEntity.ok(new SuccessResponse<>("Success",cartSvc.removeFromCart(cartId)));
    }

    @PostMapping("/updateQuantity")
    public ResponseEntity<SuccessResponse<String>> updateQuantity(@RequestBody ReqParamCart.ReqUpdateQuantity param){
        return ResponseEntity.ok(new SuccessResponse<>("Success",cartSvc.updateQuantity(param)));
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<SuccessResponse<List<Cart>>> retrieveAllCart(@PathVariable long userId){
        return ResponseEntity.ok(new SuccessResponse<>("Success",cartSvc.retrieveAllCart(userId)));
    }

}
