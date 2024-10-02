package com.tallerwebi.dominio;

public interface ServicioUsuario {
    Usuario crearUsuario(Usuario nuevoUsuario);

    Usuario guardarUsuario(Usuario nuevoUsuario);


    Usuario agregarAmigo(Usuario usuario1, Usuario usuario2);

    Usuario buscarUsuario(Usuario usuarioQueBusca, Usuario usuarioBuscado);

    Boolean guardarPartido(Usuario usuario, Partido partido1);
}
