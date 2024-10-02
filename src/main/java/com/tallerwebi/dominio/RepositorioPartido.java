package com.tallerwebi.dominio;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPartido {
    List<Partido> obtenerTodosLosPartidos();

    Partido agregarDosUsuariosAlPartido(Usuario usuario1, Usuario usuario2, Partido partido);

    Partido agregarDosEquiposAlPartido(Equipo equipo1, Equipo equipo2, Partido partido);
}
