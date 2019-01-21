package br.com.bruno.ecommerce.services;

import br.com.bruno.ecommerce.converters.ClientConverter;
import br.com.bruno.ecommerce.dto.ClientDto;
import br.com.bruno.ecommerce.models.Client;
import br.com.bruno.ecommerce.models.ClientType;
import br.com.bruno.ecommerce.models.PessoaFisica;
import br.com.bruno.ecommerce.models.PessoaJuridica;
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

    @Autowired
    private ClientConverter clientConverter;

    @Transactional
    public ClientDto create(ClientDto clientDto) {
        Client client = clientConverter.convert(clientDto);

        client = clientRepository.save(client);

        clientDto.setId(client.getId());

        return clientDto;
    }

    @Transactional
    public ClientDto update(ClientDto clientDto) {

        Client client = clientRepository.findById(clientDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(clientDto.getId() + " Not found!"));

        if (client.getClientType().equals(ClientType.PF)) {
            client.setEmail(clientDto.getEmail());
            client.setPassword(clientDto.getPassword());
            client.setAddress(clientDto.getAddress());
            ((PessoaFisica) client).setName(clientDto.getName());
            ((PessoaFisica) client).setCpf(clientDto.getCpf());
        } else if (client.getClientType().equals(ClientType.PJ)) {
            client.setEmail(clientDto.getEmail());
            client.setPassword(clientDto.getPassword());
            client.setAddress(clientDto.getAddress());
            ((PessoaJuridica) client).setCompany(clientDto.getCompany());
            ((PessoaJuridica) client).setCnpj(clientDto.getCnpj());
        }

        client = clientRepository.save(client);

        return clientConverter.unConvert(client);
    }

    public List<ClientDto> getAll() {

        List<Client> clientList = clientRepository.findAll();

        return clientList.stream()
                .map(x -> clientConverter.unConvert(x))
                .collect(toList());
    }

    public void delete(Long clientId) {

        clientRepository.deleteById(clientId);
    }


}
