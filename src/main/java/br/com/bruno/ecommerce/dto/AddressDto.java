package br.com.bruno.ecommerce.dto;

import br.com.bruno.ecommerce.models.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressDto {

    private Long id;
    private String street;
    private Integer number;
    private String complement;
    private Client client;


}
