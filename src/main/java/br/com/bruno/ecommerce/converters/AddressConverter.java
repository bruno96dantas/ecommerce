package br.com.bruno.ecommerce.converters;

import br.com.bruno.ecommerce.dto.AddressDto;
import br.com.bruno.ecommerce.models.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter implements Convert<Address, AddressDto> {

    @Override
    public Address convert(AddressDto dto) {
        return Address.builder()
                .street(dto.getStreet())
                .number(dto.getNumber())
                .complement(dto.getComplement())
                .client(dto.getClient())
                .build();
    }

    @Override
    public AddressDto unConvert(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .complement(address.getComplement())
                .client(address.getClient())
                .build();
    }
}
