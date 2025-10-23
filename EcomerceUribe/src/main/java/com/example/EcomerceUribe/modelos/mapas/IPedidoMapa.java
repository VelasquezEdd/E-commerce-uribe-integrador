package com.example.EcomerceUribe.modelos.mapas;


import com.example.EcomerceUribe.modelos.DTOS.PedidoDto;
import com.example.EcomerceUribe.modelos.DTOS.ProductoDto;
import com.example.EcomerceUribe.modelos.Pedido;
import com.example.EcomerceUribe.modelos.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPedidoMapa {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "montoTotal", target = "montoTotal")
    @Mapping(source = "fechaCreacion", target = "fechaCreacion")
    PedidoDto pedidoDto (Pedido pedido);

    List<PedidoDto> listaToDto(List<Pedido> lista);

}
