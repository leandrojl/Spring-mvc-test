package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

@Service("servicioEquipo")
public interface ServicioEquipo {
    Equipo crearEquipo(Usuario usuario1, Usuario usuario2);

    Boolean agregarEquipoAlPartido(Equipo equipoCreado, Partido partido);
}
