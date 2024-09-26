package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioTorneo;
import com.tallerwebi.dominio.ServicioUsuario;
import com.tallerwebi.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;

public class ControladorUsuarioTest {

    private ControladorUsuario controladorUsuario;
    private ServicioUsuario servicioUsuarioMock;
    private Usuario usuarioMock;
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        usuarioMock = mock(Usuario.class);

        // Crear un mock del servicio
        servicioUsuarioMock = mock(ServicioUsuario.class);

        // Crear el controlador con el servicio simulado (mockeado)
        controladorUsuario = new ControladorUsuario(servicioUsuarioMock);

        // Configurar MockMvc para simular peticiones HTTP
        mockMvc = MockMvcBuilders.standaloneSetup(controladorUsuario).build();
    }



}
