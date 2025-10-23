package com.example.EcomerceUribe.servicios;

import com.example.EcomerceUribe.modelos.DTOS.UsuarioGenericoDto;
import com.example.EcomerceUribe.modelos.Usuario;
import com.example.EcomerceUribe.modelos.mapas.IUsuarioMapa;
import com.example.EcomerceUribe.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repositorio;
    @Autowired
    private IUsuarioMapa mapa;

    //Declaro funciones para activar los servicios disponibles del API

    //1. ACTIVADO EL SERVICIO DE GUARDADO

    public UsuarioGenericoDto guardarUsuariogenerico(Usuario datosUsuario) {
        //LOGICA DE NEGOCIO
        //Validación de correo duplicado
        if (this.repositorio.findByCorreo(datosUsuario.getCorreo()).isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un usuario registrado con el coreo ingresado"
            );
        }

        //Validación de que el nombre no está vacío
        if (datosUsuario.getNombres() == null || datosUsuario.getNombres().isBlank()) {
                        throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El nombre del usuario es obligatorio"
                );
            }


        //Validación de que la contraseña es mínima
        if (datosUsuario.getContraseña().length() < 6) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "La contraseña debe tener minimo 6 caracteres"
                );
            }

        //Intentar guardar el usuario
        Usuario usuarioQueGuardoElRepo = this.repositorio.save(datosUsuario);
        if (usuarioQueGuardoElRepo == null) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al guardar el usuario en la base de datos"
            );
        }

        //Retornar el DTO al controlador
        return this.mapa.convertir_usuario_a_usuariogenericodto(usuarioQueGuardoElRepo);
    }
}
