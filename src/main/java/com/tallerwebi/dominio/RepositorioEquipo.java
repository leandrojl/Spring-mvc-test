package com.tallerwebi.dominio;

import org.springframework.stereotype.Repository;

@Repository("repositorioEquipo")
public interface RepositorioEquipo {
    Equipo crearEquipo(Usuario usuario1, Usuario usuario2);

    Boolean agregarEquipoAlPartido(Equipo equipoCreado, Partido partido);
}
