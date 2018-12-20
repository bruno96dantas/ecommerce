package br.com.bruno.ecommerce.services;

import br.com.bruno.ecommerce.dto.ProductDto;
import br.com.bruno.ecommerce.models.Product;
import br.com.bruno.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String get() {
        return "Product";
    }


    @Transactional
    public ProductDto create(ProductDto dto) {

        Product product = Product.builder()
                .description(dto.getDescription())
                .title(dto.getTitle())
                .pages(dto.getPages())
                .price(dto.getPrice())
                .build();

        product = productRepository.save(product);

        dto.setId(product.getId());

        return dto;

    }
}
