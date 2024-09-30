package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

import java.util.List;


@Service("servicioTorneo")
//@Transactional -- cuando use una base de datos real esto me va a asegurar que se cumpla de principio a base la consulta o actualizacion a la bd.
public class ServicioTorneoImpl implements ServicioTorneo {

    RepositorioTorneo repositorioTorneo;


    public ServicioTorneoImpl(RepositorioTorneo repositorioTorneoMock) {
        this.repositorioTorneo = repositorioTorneoMock;
    }

    @Override
    public List<Torneo> obtenerTodosLosTorneos() {
        return repositorioTorneo.obtenerTodosLosTorneos();
    }
}
