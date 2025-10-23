package com.example.EcomerceUribe.modelos.mapas;


import com.example.EcomerceUribe.modelos.DTOS.ProductoDto;
import com.example.EcomerceUribe.modelos.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductoMapa {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "categorias", target = "categorias")
    @Mapping(source = "precioUnitario", target = "precioUnitario")
    @Mapping(source = "marca", target = "marca")
    @Mapping(source = "aplicaDescuento", target = "aplicaDescuento")
    ProductoDto productoToDto (Producto producto);

    List<ProductoDto> listaToDto(List<Producto> lista);
}
