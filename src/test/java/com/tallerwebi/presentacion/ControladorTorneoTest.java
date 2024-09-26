package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioTorneo;
import com.tallerwebi.dominio.Torneo;
import com.tallerwebi.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ControladorTorneoTest {

    private ControladorTorneo controladorTorneo;
    private ServicioTorneo servicioTorneoMock;
    private Usuario usuarioMock;
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        usuarioMock = mock(Usuario.class);

        // Crear un mock del servicio
        servicioTorneoMock = mock(ServicioTorneo.class);

        // Crear el controlador con el servicio simulado (mockeado)
        controladorTorneo = new ControladorTorneo(servicioTorneoMock);

        // Configurar MockMvc para simular peticiones HTTP
        mockMvc = MockMvcBuilders.standaloneSetup(controladorTorneo).build();
    }

    @Test
    public void debeRetornarLaVistaTorneosCuandoSeEjecutaElMetodoMostrarTorneo() throws Exception {

        ControladorTorneo controladorTorneo = new ControladorTorneo(servicioTorneoMock);

        ModelAndView modelAndView = controladorTorneo.mostrarTorneos();

        assertThat(modelAndView.getViewName(), equalToIgnoringCase("mostrar-torneo"));

    }

    @Test
    public void dadaUnaListaDeTorneosObtenerlosEnElModelo() throws Exception {
        //given - when - then

        // Simulamos una lista de torneos
        List<Torneo> torneosMock = Arrays.asList(new Torneo("Torneo1"), new Torneo("Torneo2"));

        // Decimos que el servicio devolverá esta lista de torneos cuando lo llamemos
        when(servicioTorneoMock.obtenerTodosLosTorneos()).thenReturn(torneosMock);

        // Realizar una solicitud GET a la URL /torneos
        mockMvc.perform(get("/torneos"))
                .andExpect(status().isOk()) // Verificar que la respuesta es 200 OK
                .andExpect(view().name("mostrar-torneo")) // Verificar que se está usando la vista "vista-torneos"
                .andExpect(model().attributeExists("torneos")) // Verificar que el modelo tiene el atributo "torneos"
                .andExpect(model().attribute("torneos", torneosMock)); // Verificar que la lista de torneos es la correcta

    }
}
