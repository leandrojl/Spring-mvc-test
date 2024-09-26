package com.tallerwebi.dominio;

import javax.persistence.Entity;


public class Torneo {

    private String nombre;
    private String ubicacion;

    public Torneo(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Torneo(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
