package com.drs.springboot.betaonlinestore.service;

import com.drs.springboot.betaonlinestore.dao.Cart;
import com.drs.springboot.betaonlinestore.dao.Product;
import com.drs.springboot.betaonlinestore.dto.req.ReqParamCart;
import com.drs.springboot.betaonlinestore.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CartSvc {
    @Autowired
    private CartRepo cartRepo;

    public String insertToCart(ReqParamCart.ReqAddToCart param){
        Random rand = new Random();
        // Generate random integers in range 0 to 999
        long id = rand.nextInt(1000);
        StringBuilder sb = new StringBuilder();
        try{
            cartRepo.insertToCart(id, param.getUserId(), param.getProductId(),param.getQty());
            sb.append("produk berhasil ditambahkan");
        }catch (Exception e){
            System.out.println(e);
            sb.append(e);
        }


        return sb.toString();
    }

    public String removeFromCart(long cartId){
        StringBuilder sb = new StringBuilder();
        try{
            cartRepo.deleteCart(cartId);
            sb.append("produk berhasil dihapus dari keranjang");
        }catch (Exception e){
            System.out.println(e);
            sb.append(e);
        }
        return sb.toString();
    }

    public String removeAll(long userId){
        StringBuilder sb = new StringBuilder();
        try{
            cartRepo.removeAll(userId);
            sb.append("produk berhasil dihapus dari keranjang");
        }catch (Exception e){
            System.out.println(e);
            sb.append(e);
        }
        return sb.toString();
    }

    public String updateQuantity(ReqParamCart.ReqUpdateQuantity param){
        StringBuilder sb = new StringBuilder();
        try{
            cartRepo.updateQuantity(param.getQty(),param.getCartId());
            sb.append("produk berhasil diupdate");
        }catch (Exception e){
            System.out.println(e);
            sb.append(e);
        }
        return sb.toString();
    }

    public List<Cart> retrieveAllCart(long userId){
        return cartRepo.retrieveAllCart(userId);
    }

}
