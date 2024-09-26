package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Usuario;

public interface RepositorioUsuario {
    Usuario guardarUsuario(Usuario nuevoUsuario);

    Usuario crearUsuario(Usuario nuevoUsuario);


    Usuario agregarAmigo(Usuario usuarioQueQuiereAgregar, Usuario usuarioAgregado);

    Usuario buscarUsuario(Usuario usuarioQueBusca, Usuario usuarioBuscado);

}
