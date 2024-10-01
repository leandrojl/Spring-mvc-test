package com.tallerwebi.infraestructura;


import com.tallerwebi.dominio.Pais;
import com.tallerwebi.dominio.RepositorioPais;
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
import javax.transaction.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HibernateInfraestructuraTestConfig.class})
public class RepositorioPaisImplTest {

    @Autowired
    private SessionFactory sessionFactory;

    private RepositorioPais repositorioPais;

    @BeforeEach
    public void init() {
        this.repositorioPais =  new RepositorioPaisImpl(sessionFactory);

    }


    @Test
    @Transactional
    public void dadoQueExisteUnRepositorioPaisCuandoGuardoUnPaisEntoncesLoEncuentroEnLaBaseDeDatos(){
        //dado que tengo dos torneos
        Pais pais = new Pais();
        pais.setNombre("Alemania");

        //cuando lo guardo

        this.repositorioPais.guardarPais(pais);


        String hql = "FROM Pais WHERE nombre = :nombre";

        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter("nombre", "Alemania");



        //entonces tengo un torneo

        Pais paisObtenido = (Pais) query.getSingleResult();

        assertThat(paisObtenido, equalTo(pais));
    }


}
