package com.example.EcomerceUribe.servicios;

import com.example.EcomerceUribe.modelos.Pedido;
import com.example.EcomerceUribe.repositorios.IPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServicio {

    @Autowired
    private IPedidoRepositorio repositorio;

    // Guardar pedido
    public Pedido guardarPedido(Pedido datosPedido) {
        try {
            return this.repositorio.save(datosPedido);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el pedido");
        }
    }

    // Buscar pedidos por fecha de entrega
    public List<Pedido> buscarPorFechaEntrega(LocalDate fechaEntrega) {
        return this.repositorio.findByfechaEntrega(fechaEntrega);
    }
}
