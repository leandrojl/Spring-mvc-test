package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Pais;
import com.tallerwebi.dominio.RepositorioTorneo;
import com.tallerwebi.dominio.Torneo;
import com.tallerwebi.infraestructura.config.HibernateInfraestructuraTestConfig;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Query;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(SpringExtension.class) //toma las anotaciones de spring @autowired, etc
@ContextConfiguration(classes = {HibernateInfraestructuraTestConfig.class}) //carga la configuracion de hibernate para trabajar en MEMORIA y no ejecutar querys en phpmyadmin u otra base de datos
public class RepositorioTorneoImplTest {

    @Autowired
    private SessionFactory sessionFactory;


    private RepositorioTorneo repositorioTorneo;

 @BeforeEach
 public void init() {


     this.repositorioTorneo = new RepositorioTorneoImpl(sessionFactory);

 }
    @Test
    @Transactional
    public void queSePuedanGuardarUnTorneosEnLaBaseDeDatos(){

        //dado que tengo dos torneos
        Pais pais = new Pais();
        pais.setNombre("Alemania");
        Torneo torneo1 = new Torneo("Torneo de Pádel", pais);



        //cuando lo guardo

        this.repositorioTorneo.guardarTorneo(torneo1);


        String hql = "FROM Torneo WHERE nombre = :nombre AND pais = :pais";

        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter("nombre", "Torneo de Pádel");

        query.setParameter("pais", "Alemania");

        //entonces tengo un torneo

        Torneo torneoObtenido = (Torneo) query.getSingleResult();

        assertThat(torneoObtenido, equalTo(torneo1));

    }
}
