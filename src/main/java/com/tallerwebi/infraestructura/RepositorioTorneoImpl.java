package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.RepositorioTorneo;
import com.tallerwebi.dominio.Torneo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("repositorioTorneo")
@Transactional
public class RepositorioTorneoImpl implements RepositorioTorneo {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTorneoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Torneo> obtenerTodosLosTorneos() {

        return this.sessionFactory.getCurrentSession().createQuery("FROM Torneo").getResultList();


    }
    //guardo el torneo en la bd
    @Override
    public void guardarTorneo(Torneo torneo) {
        this.sessionFactory.getCurrentSession().save(torneo);
    }
}
