package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioTorneo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServicioTorneoTest {

    private ServicioTorneoImpl servicioTorneo;
    private RepositorioTorneo repositorioTorneoMock;

    @BeforeEach
    public void setUp() {
        // Crear un mock del repositorio que usará el servicio
        repositorioTorneoMock = mock(RepositorioTorneo.class);

        // Crear la instancia del servicio, inyectando el mock del repositorio
        servicioTorneo = new ServicioTorneoImpl(repositorioTorneoMock);
    }

    @Test
    public void queSePuedaCrearUnTorneoConNombre() {
        // Given: Datos de entrada (nombre y ubicación del torneo)
        String nombreTorneo = "Torneo de Pádel";


        // When: Se crea un nuevo torneo con esos datos
        Torneo torneo = new Torneo(nombreTorneo);

        // Then: Se verifica que el nombre y la ubicación son los correctos
        assertEquals(nombreTorneo, torneo.getNombre());

    }

    @Test
    public void queSePuedaCrearUnTorneoConNombreYUbicacion() {
        // Given: Datos de entrada (nombre y ubicación del torneo)
        String nombreTorneo = "Torneo de Pádel";
        String ubicacionTorneo = "Madrid";

        // When: Se crea un nuevo torneo con esos datos
        Torneo torneo = new Torneo(nombreTorneo, ubicacionTorneo);

        // Then: Se verifica que el nombre y la ubicación son los correctos
        assertEquals(nombreTorneo, torneo.getNombre());
        assertEquals(ubicacionTorneo, torneo.getUbicacion());
    }

    @Test
    public void queSeDevuelvanTodosLosTorneos() {
        // given: una lista simulada de torneos que devuelve el repositorio
        List<Torneo> torneosEsperados = Arrays.asList(new Torneo("Torneo1"), new Torneo("Torneo2"));

        // Simular el comportamiento del repositorio para que devuelva esa lista
        when(repositorioTorneoMock.obtenerTodosLosTorneos()).thenReturn(torneosEsperados);

        // when: llamamos al método del servicio que queremos testear
        List<Torneo> torneosObtenidos = servicioTorneo.obtenerTodosLosTorneos();

        // then: verificar que la lista obtenida es la misma que la lista esperada
        assertEquals(torneosEsperados, torneosObtenidos);

        // Verificar que el repositorio fue llamado una vez
        verify(repositorioTorneoMock, times(1)).obtenerTodosLosTorneos();
    }
}

