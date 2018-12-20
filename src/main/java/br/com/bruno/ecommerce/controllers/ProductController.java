package br.com.bruno.ecommerce.controllers;

import br.com.bruno.ecommerce.dto.ProductDto;
import br.com.bruno.ecommerce.models.Product;
import br.com.bruno.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto){
        productService.create(productDto);
        return productDto;
    }

    @GetMapping
    public ProductDto select() {
        return null;
    }

}
