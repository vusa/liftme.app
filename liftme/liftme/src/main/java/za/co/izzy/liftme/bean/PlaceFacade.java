/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.izzy.liftme.bean;

import za.co.izzy.liftme.model.Place;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vusa
 */
@Stateless
public class PlaceFacade extends AbstractFacade<Place> {
    @PersistenceContext(unitName = "SimpleEE6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlaceFacade() {
        super(Place.class);
    }
    
}
