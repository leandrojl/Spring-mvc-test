package com.tallerwebi.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ServicioEquipoTest {

    private ServicioEquipo servicioEquipo;
    private RepositorioEquipo repositorioEquipoMock;


    @BeforeEach
    public void setUp() {
        // Crear un mock del repositorio que usará el servicio
        repositorioEquipoMock = mock(RepositorioEquipo.class);


        // Crear la instancia del servicio, inyectando el mock del repositorio
        servicioEquipo = new ServicioEquipoImpl(repositorioEquipoMock);
    }

    @Test
    public void queSePuedaCrearUnEquipoConDosUsuarios(){

        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();

        Equipo equipoCreado = servicioEquipo.crearEquipo(usuario1,usuario2);

        when(repositorioEquipoMock.crearEquipo(usuario1,usuario2)).thenReturn(equipoCreado);


        verify(repositorioEquipoMock, times(1)).crearEquipo(usuario1, usuario2);
    }

    @Test
    public void queUnEquipoConDosUsuariosSePuedaAgregarAUnPartido(){

        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        Partido partido = new Partido();

        Equipo equipoCreado = servicioEquipo.crearEquipo(usuario1,usuario2);

        when(repositorioEquipoMock.crearEquipo(usuario1,usuario2)).thenReturn(equipoCreado);

        servicioEquipo.agregarEquipoAlPartido(equipoCreado, partido);

        when(repositorioEquipoMock.agregarEquipoAlPartido(equipoCreado, partido)).thenReturn(true);

        verify(repositorioEquipoMock, times(1)).crearEquipo(usuario1, usuario2);
        verify(repositorioEquipoMock, times(1)).agregarEquipoAlPartido(equipoCreado, partido);


    }


}
