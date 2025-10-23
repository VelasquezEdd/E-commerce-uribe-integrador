package com.example.EcomerceUribe.modelos.mapas;

import com.example.EcomerceUribe.modelos.Cliente;
import com.example.EcomerceUribe.modelos.DTOS.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapa {

    @Mapping(source = "cargo", target = "cargo")
    @Mapping(source = "salario", target = "salario")
    @Mapping(source = "sede", target = "sede")
    ClienteDto clienteDto (Cliente cliente);

    List<ClienteDto> listaToDto(List<Cliente> lista);
}
