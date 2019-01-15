package br.com.bruno.ecommerce.converters;

import br.com.bruno.ecommerce.dto.ClientDto;
import br.com.bruno.ecommerce.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter implements Convert<Client, ClientDto> {

    @Override
    public Client convert(ClientDto dto) {
        return Client.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .address(dto.getAddress())
                .clientType(dto.getClientType())
                .build();
    }

    @Override
    public ClientDto unConvert(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .email(client.getEmail())
                .password(client.getPassword())
                .address(client.getAddress())
                .clientType(client.getClientType())
                .build();
    }
}
