package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Torneo;
import com.tallerwebi.dominio.ServicioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorTorneo {

    private final ServicioTorneo servicioTorneo;

    @Autowired
    public ControladorTorneo(ServicioTorneo servicioTorneo) {
        this.servicioTorneo = servicioTorneo;
    }

    @GetMapping("/torneos") //getmapping es exclusiva para peticiones http get
    public ModelAndView mostrarTorneos() {
        // Spring crea el modelo automáticamente
        List<Torneo> torneos = servicioTorneo.obtenerTodosLosTorneos(); // Obtener la lista

        ModelMap model = new ModelMap();

        model.addAttribute("torneos", torneos); // Agregar la lista al modelo

        return new ModelAndView("mostrar-torneo", model);// Retornar el nombre de la vista
    }
}
