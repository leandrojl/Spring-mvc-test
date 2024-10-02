package com.tallerwebi.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServicioPartidoTest {

    private ServicioPartidoImpl servicioPartido;
    private RepositorioPartido repositorioPartidoMock;
    private Partido partidoMock;

    @BeforeEach
    public void setUp() {
        // Crear un mock del repositorio que usará el servicio
        repositorioPartidoMock = mock(RepositorioPartido.class);

        partidoMock = mock(Partido.class);

        // Crear la instancia del servicio, inyectando el mock del repositorio
        servicioPartido = new ServicioPartidoImpl(repositorioPartidoMock);
    }

    @Test
    public void queSePuedaCrearUnPartidoConNombre() {

        Partido partido = new Partido();

        partido.setNombre("El Partido de la fecha");

        String nombreEsperado= "El Partido de la fecha";

        assertEquals(nombreEsperado, partido.getNombre());



    }

    @Test
    public void queSePuedaCrearUnPartidoConNombreYPais() {
        // Given: Datos de entrada (nombre y ubicación del torneo)
        String nombrePartido = "Partido importante";
        Pais pais = new Pais();
        pais.setNombre("Alemania");

        // When: Se crea un nuevo torneo con esos datos
        Partido partido = new Partido(nombrePartido, pais);

        // Then: Se verifica que el nombre y la ubicación son los correctos
        assertEquals(nombrePartido, partido.getNombre());
        assertEquals(pais, partido.getPais());
    }

    @Test
    public void queSeLlameAlMetodoAgregarUsuarioEnElPartido() {

        Usuario usuario1 = new Usuario();



        partidoMock.agregarUsuarioAlPartido(usuario1);



        verify(partidoMock, times(1)).agregarUsuarioAlPartido(usuario1);

    }

    @Test
    public void queSePuedaAgregarDosUsuariosAUnPartido() {

        // Arrange: Preparar los datos de prueba
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        Partido partido = new Partido();

        // Act: Llamar al método del servicio que queremos probar
        servicioPartido.agregarDosUsuariosAlPartido(usuario1, usuario2, partido);

        // Simular la acción del repositorio cuando se llame agregarDosUsuariosAlPartido
        when(repositorioPartidoMock.agregarDosUsuariosAlPartido(usuario1, usuario2, partido))
                .thenReturn(partido);


        // Assert: Verificar que el método del repositorio se llamó con los parámetros correctos
        verify(repositorioPartidoMock, times(1)).agregarDosUsuariosAlPartido(usuario1, usuario2, partido);
    }



    @Test
    public void queSePuedanAgregarDosEquiposAlPartido(){
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();

        Partido partido = new Partido();

        servicioPartido.agregarDosEquiposAlPartido(equipo1,equipo2,partido);

        when(repositorioPartidoMock.agregarDosEquiposAlPartido(equipo1, equipo2, partido)).thenReturn(partido);


        verify(repositorioPartidoMock, times(1)).agregarDosEquiposAlPartido(equipo1,equipo2,partido);

    }


}
