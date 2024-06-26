package com.tooster.security.service;

import com.tooster.security.dto.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = null;

    @PostConstruct
    public void loadProductFromDB(){
        productList = IntStream.rangeClosed(1,100)
                .mapToObj(i -> Product.builder()
                        .productId(i)
                        .name("product " + i)
                        .qty(new Random().nextInt(10))
                        .price(new Random().nextInt(5000)).build())
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts(){
        return productList;
    }

    public Product getProductById(int productId){
        return productList.stream()
                .filter(product -> product.getProductId() == productId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Product " + productId + " not found"));
    }

}
