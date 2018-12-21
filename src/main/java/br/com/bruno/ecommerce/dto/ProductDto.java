package br.com.bruno.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {

    private Integer id;
    private String title;
    private String description;
    private Integer pages;
    private Double price;

}
