package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Torneo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("repositorioTorneo")
public class RepositorioTorneoImpl implements RepositorioTorneo {




    @Override
    public List<Torneo> obtenerTodosLosTorneos() {
        // Simulación de una lista de torneos
        List<Torneo> torneos = new ArrayList<>();
        torneos.add(new Torneo("Torneo de Pádel", "Madrid"));
        torneos.add(new Torneo("Torneo de Verano", "Barcelona"));
        torneos.add(new Torneo("Torneo de Invierno", "Valencia"));

        return torneos;
    }
}
