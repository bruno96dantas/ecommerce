package br.com.bruno.ecommerce.services;

import br.com.bruno.ecommerce.converters.ProductConverter;
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

    @Autowired
    private ProductConverter productConverter;

    @Transactional
    public ProductDto create(ProductDto dto) {

        Product product = productConverter.convert(dto);

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

        return productConverter.unConvert(product);

    }


    public List<ProductDto> getAll() {

        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(x -> productConverter.unConvert(x))
                .collect(toList());

//        List<ProductDto> productDtoList = new ArrayList<>();
//
//        for (Product product : productList) {
//            productDtoList.add(unConvert(product));
//        }
//
//        return productDtoList;
    }

    public void delete(Long productId) {

        productRepository.deleteById(productId);

    }

}
