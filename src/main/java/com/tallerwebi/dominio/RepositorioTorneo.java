package com.tallerwebi.dominio;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioTorneo {
    List<Torneo> obtenerTodosLosTorneos();

    void guardarTorneo(Torneo torneo1);
}
