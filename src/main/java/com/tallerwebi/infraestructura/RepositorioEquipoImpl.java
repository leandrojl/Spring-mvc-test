package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Equipo;
import com.tallerwebi.dominio.Partido;
import com.tallerwebi.dominio.RepositorioEquipo;
import com.tallerwebi.dominio.Usuario;
import org.hibernate.SessionFactory;

public class RepositorioEquipoImpl implements RepositorioEquipo {

    private SessionFactory sessionFactory;

    @Override
    public Equipo crearEquipo(Usuario usuario1, Usuario usuario2) {
        return null;
    }

    @Override
    public Boolean agregarEquipoAlPartido(Equipo equipoCreado, Partido partido) {
        return null;
    }
}
