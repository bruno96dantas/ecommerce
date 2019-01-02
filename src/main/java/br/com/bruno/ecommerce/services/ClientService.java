package br.com.bruno.ecommerce.services;

import br.com.bruno.ecommerce.dto.ClientDto;
import br.com.bruno.ecommerce.models.Client;
import br.com.bruno.ecommerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDto create(ClientDto clientDto) {
        Client client = convert(clientDto);

        client = clientRepository.save(client);

        clientDto.setId(client.getId());

        return clientDto;
    }

    @Transactional
    public ClientDto update(ClientDto clientDto) {

        Client client = clientRepository.findById(clientDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(clientDto.getId() + " Not found!"));

        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        client.setCart(clientDto.getCart());
        client.setAddress(clientDto.getAddress());
        client.setClientType(clientDto.getClientType());

        client = clientRepository.save(client);

        return unConvert(client);
    }

    public List<ClientDto> getAll() {

        List<Client> clientList = clientRepository.findAll();

        return clientList.stream()
                .map(this::unConvert)
                .collect(toList());
    }

    public void delete(Integer clientId) {

        clientRepository.deleteById(clientId);
    }

    private Client convert(ClientDto dto) {
        return Client.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .cart(dto.getCart())
                .address(dto.getAddress())
                .clientType(dto.getClientType())
                .build();
    }

    private ClientDto unConvert (Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .email(client.getEmail())
                .password(client.getPassword())
                .cart(client.getCart())
                .address(client.getAddress())
                .clientType(client.getClientType())
                .build();
    }

}
