package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class ServicioUsuarioTest {

    private RepositorioUsuario repositorioUsuarioMock;
    private ServicioUsuario servicioUsuario;

    @BeforeEach
    public void init(){
        // Mock del repositorio
        this.repositorioUsuarioMock = mock(RepositorioUsuario.class);

        // Instancia real del servicio, inyectando el repositorio mock
        this.servicioUsuario =  new ServicioUsuarioImpl(repositorioUsuarioMock);
    }


    @Test
    public void queUnUsuarioSePuedaCrear() {
        // Dado

        Usuario usuarioEsperado = new Usuario();

        // Simular que el repositorio guarda el usuario y lo devuelve
        when(repositorioUsuarioMock.crearUsuario(usuarioEsperado)).thenReturn(usuarioEsperado);

        Usuario usuario = servicioUsuario.crearUsuario(usuarioEsperado);

        // Entonces (verificaciones)
        assertThat(usuario, notNullValue()); // Verifica que el usuario no sea null
        verify(repositorioUsuarioMock).crearUsuario(usuario); // Verifica que se llamó al método del repositorio
    }

    @Test
    public void queSePuedaCrearUnUsuarioConID(){
        Usuario usuario = new Usuario();

        usuario.setId(1L);


        assertThat(usuario.getId(), is(1L));

    }

    @Test
    public void queDosUsuariosConElMismoIdSonIguales(){
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();

        usuario1.setId(1L);
        usuario2.setId(1L);


        assertThat(usuario1, is(equalTo(usuario2)));

    }

    @Test
    public void queUnUsuarioSePuedaCrearConNombreApellidoManoHabilYUbicacion() {
        // Dado

        Usuario usuarioEsperado = new Usuario("Leandro", "Perez", "Derecha", "Castelar");

        // Simular que el repositorio guarda el usuario y lo devuelve
        when(repositorioUsuarioMock.crearUsuario(usuarioEsperado)).thenReturn(usuarioEsperado);

        Usuario usuario = servicioUsuario.crearUsuario(usuarioEsperado);

        // Entonces (verificaciones)
        assertThat(usuario, notNullValue());
        assertThat(usuario.getNombre(), equalToIgnoringCase("Leandro"));// Verifica que el usuario no sea null
        assertThat(usuario.getApellido(), equalToIgnoringCase("Perez"));
        assertThat(usuario.getManoHabil(), equalToIgnoringCase("Derecha"));
        assertThat(usuario.getUbicacion(), equalToIgnoringCase("Castelar"));
        verify(repositorioUsuarioMock).crearUsuario(usuario); // Verifica que se llamó al método del repositorio
    }

    @Test
    public void queSePuedaCrearUnUsuarioAdministrador(){
        //Dado que tengo un usuario
        Usuario usuarioEsperado = new Usuario();

        //cuando le asigno el rol de administrador
        usuarioEsperado.setPermisoUsuario(PermisoUsuario.ADMINISTRADOR);

        when(repositorioUsuarioMock.crearUsuario(usuarioEsperado)).thenReturn(usuarioEsperado); //simulo el comportamiento del repositorio


        Usuario usuario = servicioUsuario.crearUsuario(usuarioEsperado);


        //entonces el usuario es administrador
        assertThat(usuario.getPermisoUsuario(), is(PermisoUsuario.ADMINISTRADOR));
        verify(repositorioUsuarioMock).crearUsuario(usuario);
    }


    @Test
    public void queSePuedaCrearUnUsuarioRegular(){
        //Dado que tengo un usuario
        Usuario usuarioEsperado = new Usuario();

        usuarioEsperado.setPermisoUsuario(PermisoUsuario.REGULAR);

        when(repositorioUsuarioMock.crearUsuario(usuarioEsperado)).thenReturn(usuarioEsperado); //simulo el comportamiento del repositorio

        Usuario usuario = servicioUsuario.crearUsuario(usuarioEsperado);

        //entonces el usuario es administrador
        assertThat(usuario.getPermisoUsuario(), is(PermisoUsuario.REGULAR));
        verify(repositorioUsuarioMock).crearUsuario(usuario); // Verifica que se llamó al método del repositorio
    }

    @Test
    public void queUnUsuarioSePuedaCrearYSePuedaGuardar() {
        // Dado
        Usuario nuevoUsuario = new Usuario();

        // Simular que el repositorio guarda el usuario y lo devuelve
        when(repositorioUsuarioMock.guardarUsuario(nuevoUsuario)).thenReturn(nuevoUsuario);

        // Cuando (invocas el método real del servicio)
        Usuario usuarioGuardado = servicioUsuario.guardarUsuario(nuevoUsuario);

        // Entonces (verificaciones)
        assertThat(usuarioGuardado, notNullValue()); // Verifica que el usuario guardado no sea null
        verify(repositorioUsuarioMock).guardarUsuario(usuarioGuardado); // Verifica que se llamó al método del repositorio
    }

    @Test
    public void queUnUsuarioPuedaAgregarAAmigosAOtroUsuario(){

        // Crear dos usuarios de prueba
        Usuario usuarioQueQuiereAgregar = new Usuario();
        Usuario usuarioAgregado = new Usuario();

        // Simular el comportamiento del repositorio cuando se agregue un amigo
        when(repositorioUsuarioMock.agregarAmigo(usuarioQueQuiereAgregar, usuarioAgregado)).thenReturn(usuarioAgregado);

        // Llamar al método del servicio para agregar el amigo
        usuarioQueQuiereAgregar.agregarAmigo(usuarioAgregado);
        servicioUsuario.agregarAmigo(usuarioQueQuiereAgregar, usuarioAgregado);

        // Verificar que el amigo fue agregado correctamente
        assertThat(usuarioQueQuiereAgregar.getAmigos(), hasItem(usuarioAgregado));
        verify(repositorioUsuarioMock).agregarAmigo(usuarioQueQuiereAgregar, usuarioAgregado);

    }

    @Test
    public void queUnUsuarioPuedaBuscarAOtroUsuarioEnSuListaDeAmigos(){

        // Crear dos usuarios de prueba
        Usuario usuarioQueBusca = new Usuario();
        Usuario usuarioBuscado = new Usuario();


        //agrega al arraylist del usuario
        usuarioQueBusca.agregarAmigo(usuarioBuscado);

        //agregar al usuario buscado a la lista de amigos del usuario que busca en la base de datos
        servicioUsuario.agregarAmigo(usuarioQueBusca, usuarioBuscado);

        // Simular el comportamiento del repositorio cuando se agregue un amigo
        when(repositorioUsuarioMock.buscarUsuario(usuarioQueBusca, usuarioBuscado)).thenReturn(usuarioBuscado);


        // Llamar al método para buscar al amigo
        Usuario usuarioEncontrado = servicioUsuario.buscarUsuario(usuarioQueBusca, usuarioBuscado);

        // Verificar que el amigo fue agregado correctamente
        assertThat(usuarioBuscado, is(equalTo(usuarioEncontrado)));
        assertThat(usuarioQueBusca.getAmigos(), hasItem(usuarioBuscado));
        verify(repositorioUsuarioMock).buscarUsuario(usuarioQueBusca, usuarioBuscado);

    }
}
