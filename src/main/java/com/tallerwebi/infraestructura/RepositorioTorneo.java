package com.tallerwebi.infraestructura;


import com.tallerwebi.dominio.Torneo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioTorneo {
    List<Torneo> obtenerTodosLosTorneos();
}
