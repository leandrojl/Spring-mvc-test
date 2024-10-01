package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autoincremental
    private Long id;


    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id")  // Esto crea una clave foránea en la tabla Torneo
    private Pais pais;

    public Torneo(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Torneo(String nombre) {
        this.nombre = nombre;

    }

    public Torneo() {

    }

    public String getNombre() {
        return nombre;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Torneo torneo = (Torneo) o;
        return Objects.equals(id, torneo.id) && Objects.equals(nombre, torneo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
