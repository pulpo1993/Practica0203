/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Persona;

/**
 *
 * @author saito
 */
public class GestionDato {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public boolean insertarPersona(Persona p) {
        boolean retorno = false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        retorno = true;
        return retorno;
    }
    
    public List<Persona> leerPersona() {
        List<Persona> retorno = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        retorno = em.createQuery("SELECT p FROM Persona P ORDER BY p.id").getResultList();
        em.getTransaction().commit();
        return retorno; 
    }
}
