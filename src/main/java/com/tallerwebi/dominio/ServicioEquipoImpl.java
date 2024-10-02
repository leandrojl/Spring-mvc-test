package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioEquipo")
public class ServicioEquipoImpl implements ServicioEquipo {

    private RepositorioEquipo repositorioEquipo;

    @Autowired
    public ServicioEquipoImpl(RepositorioEquipo repositorioEquipo) {

        this.repositorioEquipo = repositorioEquipo;


    }

    @Override
    public Equipo crearEquipo(Usuario usuario1, Usuario usuario2) {
        return this.repositorioEquipo.crearEquipo(usuario1,usuario2);
    }

    @Override
    public Boolean agregarEquipoAlPartido(Equipo equipoCreado, Partido partido) {
        return this.repositorioEquipo.agregarEquipoAlPartido(equipoCreado, partido);
    }
}
