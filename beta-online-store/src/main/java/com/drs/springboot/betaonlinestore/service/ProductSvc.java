package com.drs.springboot.betaonlinestore.service;

import com.drs.springboot.betaonlinestore.dao.Product;
import com.drs.springboot.betaonlinestore.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSvc {

    @Autowired
    private ProductRepo productRepo;
    public List<Product> retrieveAllProduct(){
        return productRepo.getAllProduct();
    }

    public List<Product> getProductById(long id){
        return productRepo.getProductById(id);
    }
}
