package br.com.bruno.ecommerce.controllers;

import br.com.bruno.ecommerce.dto.ProductDto;
import br.com.bruno.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity create(@RequestBody ProductDto productDto) {
        productService.create(productDto);

        return ResponseEntity.ok(productDto);
    }

    @GetMapping
    public ResponseEntity findAll() {

        return ResponseEntity.ok(productService.getAll());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ProductDto productDto) {
        productService.update(productDto);

        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity delete(@PathVariable("productId") Long productId) {

        productService.delete(productId);

        return ResponseEntity.ok().build();
    }

}
