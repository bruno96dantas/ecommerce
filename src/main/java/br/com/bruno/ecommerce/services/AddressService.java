package br.com.bruno.ecommerce.services;

import br.com.bruno.ecommerce.converters.AddressConverter;
import br.com.bruno.ecommerce.dto.AddressDto;
import br.com.bruno.ecommerce.models.Address;
import br.com.bruno.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressConverter addressConverter;

    @Transactional
    public AddressDto create(AddressDto dto) {

        Address address = addressConverter.convert(dto);

        address = addressRepository.save(address);

        dto.setId(address.getId());

        return dto;
    }

    @Transactional
    public AddressDto update(AddressDto dto) {

        Address address = addressRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException(dto.getId() + " Not found"));

        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setComplement(dto.getComplement());
        address.setClient(dto.getClient());

        address = addressRepository.save(address);

        return addressConverter.unConvert(address);
    }

    public List<AddressDto> getAll() {

        List<Address> addressList = addressRepository.findAll();

        return addressList.stream()
                .map(x -> addressConverter.unConvert(x))
                .collect(toList());
    }

    public void delete (Long addressId) {

        addressRepository.deleteById(addressId);
    }
}
