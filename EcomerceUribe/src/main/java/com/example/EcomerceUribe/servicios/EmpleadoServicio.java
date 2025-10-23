package com.example.EcomerceUribe.servicios;

import com.example.EcomerceUribe.modelos.Empleado;
import com.example.EcomerceUribe.repositorios.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmpleadoServicio {

    @Autowired
    private IEmpleadoRepositorio repositorio;

    // Guardar empleado
    public Empleado guardarEmpleado(Empleado datosEmpleado) {
        try {
            return this.repositorio.save(datosEmpleado);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el empleado");
        }
    }

    // Buscar empleados por salario
    public List<Empleado> buscarPorSalario(Integer salario) {
        return this.repositorio.findByCalificacion(salario);
    }
}
