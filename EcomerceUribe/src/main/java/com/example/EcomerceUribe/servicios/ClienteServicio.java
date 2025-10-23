package com.example.EcomerceUribe.servicios;

import com.example.EcomerceUribe.modelos.Cliente;
import com.example.EcomerceUribe.repositorios.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private IClienteRepositorio repositorio;

    // Guardar cliente
    public Cliente guardarCliente(Cliente datosCliente) {
        try {
            return this.repositorio.save(datosCliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el cliente");
        }
    }

    // Buscar clientes por calificación
    public List<Cliente> buscarPorCalificacion(Double calificacion) {
        return this.repositorio.findByCalificacion(calificacion);
    }
}
