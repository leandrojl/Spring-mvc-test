package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Partido;
import com.tallerwebi.dominio.RepositorioUsuario;
import com.tallerwebi.dominio.Usuario;
import org.springframework.stereotype.Repository;

@Repository("repositorioUsuario")
public class RepositorioUsuarioImpl implements RepositorioUsuario {


    @Override
    public Usuario guardarUsuario(Usuario nuevoUsuario) {
        return new Usuario();
    }

    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario) {
        return new Usuario();
    }

    @Override
    public Usuario agregarAmigo(Usuario usuarioQueQuiereAgregar, Usuario usuarioAgregado) {
        return new Usuario();
    }

    @Override
    public Usuario buscarUsuario(Usuario usuarioQueBusca, Usuario usuarioBuscado) {
        return new Usuario();
    }

    @Override
    public Boolean guardarPartido(Usuario usuario, Partido partido1) {
        return null;
    }


}
