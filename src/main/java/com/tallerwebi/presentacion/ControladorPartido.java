package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Partido;
import com.tallerwebi.dominio.ServicioPartido;
import com.tallerwebi.dominio.ServicioTorneo;
import com.tallerwebi.dominio.Torneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorPartido {


    private final ServicioPartido servicioPartido;

    @Autowired
    public ControladorPartido(ServicioPartido servicioPartido) {

        this.servicioPartido = servicioPartido;
    }

    @GetMapping("/partidos") //getmapping es exclusiva para peticiones http get
    public ModelAndView mostrarPartidos() {
        // Spring crea el modelo automáticamente
        List<Partido> partidos = servicioPartido.obtenerTodosLosPartidos(); // Obtener la lista

        ModelMap model = new ModelMap();

        model.addAttribute("partidos", partidos); // Agregar la lista al modelo

        return new ModelAndView("mostrar-partidos", model);// Retornar el nombre de la vista
    }


}
