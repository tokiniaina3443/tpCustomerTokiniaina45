/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.tokiniaina.tpcustomer.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.tokiniaina.tpcustomer.entities.Discount;

/**
 *
 * @author Tokiniaina
 */
@Stateless
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public void persist(Discount discount) {
        em.persist(discount);
    }

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}
