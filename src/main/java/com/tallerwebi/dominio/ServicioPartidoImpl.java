package com.tallerwebi.dominio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("servicioPartido")
@Transactional
public class ServicioPartidoImpl implements ServicioPartido {


    RepositorioPartido repositorioPartido;


    @Autowired
    public ServicioPartidoImpl(RepositorioPartido repositorioPartido) {


        this.repositorioPartido = repositorioPartido;
    }

    @Override
    public List<Partido> obtenerTodosLosPartidos() {
        return this.repositorioPartido.obtenerTodosLosPartidos();
    }

    @Override
    public void agregarDosUsuariosAlPartido(Usuario usuario1, Usuario usuario2, Partido partido) {
        this.repositorioPartido.agregarDosUsuariosAlPartido(usuario1, usuario2, partido);

    }

    @Override
    public void agregarDosEquiposAlPartido(Equipo equipo1, Equipo equipo2, Partido partido) {
        this.repositorioPartido.agregarDosEquiposAlPartido(equipo1,equipo2,partido);
    }


}
