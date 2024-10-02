package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioPartido")
public interface ServicioPartido {
    List<Partido> obtenerTodosLosPartidos();

    void agregarDosUsuariosAlPartido(Usuario usuario1, Usuario usuario2, Partido partido);

    void agregarDosEquiposAlPartido(Equipo equipo1, Equipo equipo2, Partido partido);
}
