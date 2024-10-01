package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Pais;
import com.tallerwebi.dominio.RepositorioPais;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioPais")
public class RepositorioPaisImpl implements RepositorioPais {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPaisImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarPais(Pais pais) {
        this.sessionFactory.getCurrentSession().save(pais);
    }
}
