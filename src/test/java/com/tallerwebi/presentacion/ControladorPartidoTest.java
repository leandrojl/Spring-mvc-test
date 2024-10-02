package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class ControladorPartidoTest {



    private ControladorPartido controladorPartido;
    private ServicioPartido servicioPartidoMock;
    private Partido partidoMock;
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        partidoMock = mock(Partido.class);

        // Crear un mock del servicio
        servicioPartidoMock = mock(ServicioPartido.class);

        // Crear el controlador con el servicio simulado (mockeado)
        controladorPartido = new ControladorPartido(servicioPartidoMock);

        // Configurar MockMvc para simular peticiones HTTP
        mockMvc = MockMvcBuilders.standaloneSetup(controladorPartido).build();
    }

    @Test
    public void debeRetornarLaVistaPartidosCuandoSeEjecutaElMetodoMostrarPartidos() throws Exception {

        ControladorPartido controladorPartido = new ControladorPartido(servicioPartidoMock);

        ModelAndView modelAndView = controladorPartido.mostrarPartidos();

        assertThat(modelAndView.getViewName(), equalToIgnoringCase("mostrar-partidos"));

    }

    @Test
    public void dadaUnaListaDePartidosObtenerlosEnElModelo() throws Exception {
        //given - when - then

        // Simulamos una lista de partidos
        List<Partido> partidosMock = Arrays.asList(new Partido("Partido 1"), new Partido("Partido 2"));

        // Decimos que el servicio devolverá esta lista de torneos cuando lo llamemos
        when(servicioPartidoMock.obtenerTodosLosPartidos()).thenReturn(partidosMock);

        // Realizar una solicitud GET a la URL /torneos
        mockMvc.perform(get("/partidos"))
                .andExpect(status().isOk()) // Verificar que la respuesta es 200 OK
                .andExpect(view().name("mostrar-partido")) // Verificar que se está usando la vista "vista-torneos"
                .andExpect(model().attributeExists("partidos")) // Verificar que el modelo tiene el atributo "torneos"
                .andExpect(model().attribute("partidos", partidosMock)); // Verificar que la lista de torneos es la correcta

    }

}
