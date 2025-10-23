package com.example.EcomerceUribe.modelos.mapas;

import com.example.EcomerceUribe.modelos.DTOS.EmpleadoDto;
import com.example.EcomerceUribe.modelos.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEmpleadoMapa {

    @Mapping(source = "cargo", target = "cargo")
    @Mapping(source = "salario", target = "salario")
    @Mapping(source = "sede", target = "sede")
    EmpleadoDto empleadoDto (Empleado empleado);

    List<EmpleadoDto> listaToDto(List<Empleado> lista);
}
