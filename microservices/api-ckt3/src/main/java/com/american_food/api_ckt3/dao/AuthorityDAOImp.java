package com.american_food.api_ckt3.dao;

import com.american_food.api_ckt3.entity.Authority;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorityDAOImp implements  AuthorityDAO {
    private EntityManager em;

    public AuthorityDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public Authority getAuthorityById(int id) {
        return em.find(Authority.class, id);
    }

    @Override
    public List<Authority> getAllAuthorities() {
        TypedQuery<Authority> query = em.createQuery("select a from Authority a", Authority.class);
        return query.getResultList();
    }

    @Override
    public Authority createAuthority(Authority authority) {
        return em.merge(authority);
    }

    @Override
    public void deleteAuthority(int id) {
        em.remove(em.find(Authority.class, id));
    }
}
