/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.edu.co.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author VAL
 */
public abstract class AbstractFacade<T> {
  
    
    private Class<T> entityClass;
    
    public AbstractFacade(Class<T> entityClass){
        this.entityClass= entityClass;
    }   
    protected abstract EntityManager getEntityManager();
    public void create(T entity){
       getEntityManager().persist(entity);
    }
    
    public void edit(T entity){
        getEntityManager().merge(entity);
    }
    
    public void remove(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
       }
    
    public Object find(Object id){
        return getEntityManager().find(entityClass,id);
    }
    
    public List<T> findAll(){
    CriteriaQuery cq=getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    Query q=getEntityManager().createQuery(cq);
    return q.getResultList();
    }
}
