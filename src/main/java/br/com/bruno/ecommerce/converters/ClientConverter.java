package br.com.bruno.ecommerce.converters;

import br.com.bruno.ecommerce.dto.ClientDto;
import br.com.bruno.ecommerce.models.Client;
import br.com.bruno.ecommerce.models.PessoaFisica;
import br.com.bruno.ecommerce.models.PessoaJuridica;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter implements Convert<Client, ClientDto> {

    @Override
    public Client convert(ClientDto dto) {
        Client client = new Client();

        switch (dto.getClientType()) {
            case PF:
                client = PessoaFisica.builder()
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .name(dto.getName())
                        .cpf(dto.getCpf())
                        .address(dto.getAddress())
                        .build();

            case PJ:
                client = PessoaJuridica.builder()
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .company(dto.getCompany())
                        .cnpj(dto.getCnpj())
                        .address(dto.getAddress())
                        .build();
        }

        return client;
    }

    @Override
    public ClientDto unConvert(Client client) {

        ClientDto clientDto = new ClientDto();

        if (client.getClass().equals(PessoaJuridica.class)) {

            clientDto = ClientDto.builder()
                    .id(client.getId())
                    .email(client.getEmail())
                    .password(client.getPassword())
                    .company(((PessoaJuridica) client).getCompany())
                    .cnpj(((PessoaJuridica) client).getCnpj())
                    .address(client.getAddress())
                    .clientType(client.getClientType())
                    .build();
        } else if (client.getClass().equals(PessoaFisica.class)) {
            clientDto = ClientDto.builder()
                    .id(client.getId())
                    .email(client.getEmail())
                    .password(client.getPassword())
                    .name(((PessoaFisica) client).getName())
                    .cpf(((PessoaFisica) client).getCpf())
                    .address(client.getAddress())
                    .clientType(client.getClientType())
                    .build();
        }

        return clientDto;
    }
}
