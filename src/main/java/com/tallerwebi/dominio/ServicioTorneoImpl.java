package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("servicioTorneo")
@Transactional // cuando use una base de datos real esto me va a asegurar que se cumpla de principio a base la consulta o actualizacion a la bd.
public class ServicioTorneoImpl implements ServicioTorneo {

    RepositorioTorneo repositorioTorneo;


    @Autowired
    public ServicioTorneoImpl(RepositorioTorneo repositorioTorneo) {
        this.repositorioTorneo = repositorioTorneo;
    }

    @Override
    public List<Torneo> obtenerTodosLosTorneos() {
        return repositorioTorneo.obtenerTodosLosTorneos();
    }
}
