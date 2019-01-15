package br.com.bruno.ecommerce.converters;

import br.com.bruno.ecommerce.dto.ProductDto;
import br.com.bruno.ecommerce.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Convert<Product, ProductDto> {

    @Override
    public Product convert(ProductDto dto) {
        return Product.builder()
                .description(dto.getDescription())
                .title(dto.getTitle())
                .pages(dto.getPages())
                .price(dto.getPrice())
                .build();    }

    @Override
    public ProductDto unConvert(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .description(product.getDescription())
                .title(product.getTitle())
                .pages(product.getPages())
                .price(product.getPrice())
                .build();    }
}
