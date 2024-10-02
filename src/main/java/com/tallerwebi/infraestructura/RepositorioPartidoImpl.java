package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Equipo;
import com.tallerwebi.dominio.Partido;
import com.tallerwebi.dominio.RepositorioPartido;
import com.tallerwebi.dominio.Usuario;

import java.util.List;

public class RepositorioPartidoImpl implements RepositorioPartido {


    @Override
    public List<Partido> obtenerTodosLosPartidos() {
        return List.of();
    }

    @Override
    public Partido agregarDosUsuariosAlPartido(Usuario usuario1, Usuario usuario2, Partido partido) {
        return null;
    }

    @Override
    public Partido agregarDosEquiposAlPartido(Equipo equipo1, Equipo equipo2, Partido partido) {
        return null;
    }
}
