/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.edu.co.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Ultrabook;

/**
 *
 * @author Duvan
 */
@Stateless
public class UltrabookDAO extends AbstractFacade<Ultrabook>{

     @PersistenceContext(unitName = "Web_DBAccessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UltrabookDAO() {
        super(Ultrabook.class);
    }
}
