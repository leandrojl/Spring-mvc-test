package com.tallerwebi.infraestructura;

import com.tallerwebi.config.HibernateConfig;
import com.tallerwebi.dominio.Torneo;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HibernateConfig.class) //carga la configuracion de hibernate
public class RepositorioTorneoImplTest {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTorneoImplTest(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;
    }


    @Test
    public void queSePuedanGuardarDosTorneosEnLaBaseDeDatos(){

        //dado que tengo dos torneos
        Torneo torneo1 = new Torneo("Torneo de Pádel", "Madrid");
        Torneo torneo2 = new Torneo("Torneo de Verano", "Barcelona");


        //cuando lo guardo



        //entonces tengo dos torneos


    }
}
