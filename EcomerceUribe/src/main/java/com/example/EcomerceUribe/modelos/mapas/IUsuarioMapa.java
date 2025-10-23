package com.example.EcomerceUribe.modelos.mapas;

import com.example.EcomerceUribe.modelos.DTOS.UsuarioEspecialDto;
import com.example.EcomerceUribe.modelos.DTOS.UsuarioGenericoDto;
import com.example.EcomerceUribe.modelos.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface IUsuarioMapa {

    //Se construyen 2 funciones por mapa

    //1. Que transforme un modelo a un DTO

    @Mapping(source = "nombres", target = "nombres")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "documento", target = "documento")
    UsuarioGenericoDto convertir_usuario_a_usuariogenericodto(Usuario usuario);

    //2. Que transforme una list<modelo> en una list<DTO>
    List<UsuarioGenericoDto> convertir_lista_a_listadtogenerico(List<Usuario> lista);

    @Mapping(source = "nombres", target = "nombres")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "documento", target = "documento")
    @Mapping(source = "contraseña", target = "contraseña")
    UsuarioEspecialDto convertir_usuario_a_usuarioespecialdto(Usuario usuario);

    //2. Que transforme una list<modelo> en una list<DTO>
    List<UsuarioEspecialDto> convertir_lista_a_listadtoespecial(List<Usuario> lista);

}
