package com.example.EcomerceUribe.servicios;

import com.example.EcomerceUribe.modelos.Producto;
import com.example.EcomerceUribe.repositorios.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private IProductoRepositorio repositorio;

    // Guardar producto
    public Producto guardarProducto(Producto datosProducto) {
        try {
            return this.repositorio.save(datosProducto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el producto");
        }
    }

    // Buscar productos por precio unitario
    public List<Producto> buscarPorPrecioUnitario(Integer precioUnitario) {
        return this.repositorio.findByprecioUnitario(precioUnitario);
    }
}
