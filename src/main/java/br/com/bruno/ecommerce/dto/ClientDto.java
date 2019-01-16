package br.com.bruno.ecommerce.dto;

import br.com.bruno.ecommerce.models.Cart;
import br.com.bruno.ecommerce.models.Address;
import br.com.bruno.ecommerce.models.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientDto {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String cpf;
    private String company;
    private String cnpj;
    private Address address;
    private ClientType clientType;
}
