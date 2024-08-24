package com.appsdeveloperblogs.ws.productmicroservice.service;


import com.appsdeveloperblogs.ws.productmicroservice.model.CreateProductRestModel;

public interface ProductService {
    String createProduct(CreateProductRestModel product);
}
