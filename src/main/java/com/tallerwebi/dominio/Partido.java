package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.List;

public class Partido {

    private String nombre;
    private Pais pais;
    private List<Usuario> usuarios;

    public Partido(String nombre) {

        this.nombre = nombre;
        this.usuarios = new ArrayList<Usuario>();
    }

    public Partido() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public Partido(String nombrePartido, Pais pais) {
        this.nombre = nombrePartido;
        this.pais = pais;
        this.usuarios = new ArrayList<Usuario>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void agregarUsuarioAlPartido(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }
}
