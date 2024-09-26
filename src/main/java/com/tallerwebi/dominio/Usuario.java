package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String manoHabil;
    private String ubicacion;
    private PermisoUsuario permisoUsuario;
    private List<Usuario> amigos;


    public Usuario(String nombre, String apellido, String manoHabil, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.manoHabil = manoHabil;
        this.ubicacion = ubicacion;
        this.amigos = new ArrayList<>();
    }


    public Usuario() {
        this.amigos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getManoHabil() {
        return manoHabil;
    }

    public void setManoHabil(String manoHabil) {
        this.manoHabil = manoHabil;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setPermisoUsuario(PermisoUsuario permisoUsuario) {
        this.permisoUsuario = permisoUsuario;
    }

    public PermisoUsuario getPermisoUsuario() {
        return this.permisoUsuario;
    }

    public void agregarAmigo(Usuario amigo) {
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
        }
    }

    public List<Usuario> getAmigos() {
        return this.amigos;
    }

    public Usuario buscarUsuario(Usuario usuarioBuscado) {
        if(getAmigos().contains(usuarioBuscado)) {
            return usuarioBuscado;
        }else{
            return null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    //sobre escribo hashcode y equals para que sean los objetos IGUALES por id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
