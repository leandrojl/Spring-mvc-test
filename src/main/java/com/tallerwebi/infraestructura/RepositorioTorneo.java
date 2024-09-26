package com.tallerwebi.infraestructura;


import com.tallerwebi.dominio.Torneo;

import java.util.List;

public interface RepositorioTorneo {
    List<Torneo> obtenerTodosLosTorneos();
}
