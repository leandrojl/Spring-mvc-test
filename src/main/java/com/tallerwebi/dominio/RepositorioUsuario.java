package com.tallerwebi.dominio;

public interface RepositorioUsuario {
    Usuario guardarUsuario(Usuario nuevoUsuario);

    Usuario crearUsuario(Usuario nuevoUsuario);


    Usuario agregarAmigo(Usuario usuarioQueQuiereAgregar, Usuario usuarioAgregado);

    Usuario buscarUsuario(Usuario usuarioQueBusca, Usuario usuarioBuscado);

    Boolean guardarPartido(Usuario usuario, Partido partido1);
}
