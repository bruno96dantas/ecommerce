package br.com.bruno.ecommerce.services;

import br.com.bruno.ecommerce.dto.ProductDto;
import br.com.bruno.ecommerce.models.Product;
import br.com.bruno.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public ProductDto create(ProductDto dto) {

        Product product = convert(dto);

        product = productRepository.save(product);

        dto.setId(product.getId());

        return dto;

    }


    @Transactional
    public ProductDto update(ProductDto dto){

        Product product = productRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException(dto.getId() + " Not found!"));

        product.setDescription(dto.getDescription());
        product.setPages(dto.getPages());
        product.setPrice(dto.getPrice());
        product.setTitle(dto.getTitle());

        product = productRepository.save(product);

        return unConvert(product);

    }


    public List<ProductDto> getAll() {

        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(this::unConvert)
                .collect(toList());

//        List<ProductDto> productDtoList = new ArrayList<>();
//
//        for (Product product : productList) {
//            productDtoList.add(unConvert(product));
//        }
//
//        return productDtoList;
    }

    public void delete(Integer productId) {

        productRepository.deleteById(productId);

    }

    private Product convert(ProductDto dto) {
        return Product.builder()
                .description(dto.getDescription())
                .title(dto.getTitle())
                .pages(dto.getPages())
                .price(dto.getPrice())
                .build();
    }

    private ProductDto unConvert(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .description(product.getDescription())
                .title(product.getTitle())
                .pages(product.getPages())
                .price(product.getPrice())
                .build();
    }
}
