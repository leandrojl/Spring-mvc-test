package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioUsuario")
public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario) {
        return this.repositorioUsuario.crearUsuario(nuevoUsuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario nuevoUsuario) {
        return this.repositorioUsuario.guardarUsuario(nuevoUsuario);
    }

    @Override
    public Usuario agregarAmigo(Usuario usuarioQueQuiereAgregar, Usuario usuarioAgregado) {
        usuarioQueQuiereAgregar.agregarAmigo(usuarioAgregado);  // La lógica de agregar está en la clase Usuario
        return this.repositorioUsuario.agregarAmigo(usuarioQueQuiereAgregar,usuarioAgregado);  // Persistir el cambio
    }

    @Override
    public Usuario buscarUsuario(Usuario usuarioQueBusca, Usuario usuarioBuscado) {

        return this.repositorioUsuario.buscarUsuario(usuarioQueBusca, usuarioBuscado);
    }


}
