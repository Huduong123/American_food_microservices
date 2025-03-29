package com.american_food.api_ckt3.service;

import com.american_food.api_ckt3.dao.AuthorityDAO;
import com.american_food.api_ckt3.entity.Authority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImp implements AuthorityService {
    private AuthorityDAO authorityDAO;

    public AuthorityServiceImp(AuthorityDAO authorityDAO) {
        this.authorityDAO = authorityDAO;
    }

    @Override
    public Authority getAuthorityById(int id) {
        return authorityDAO.getAuthorityById(id);
    }

    @Override
    public List<Authority> getAllAuthorities() {
        return authorityDAO.getAllAuthorities();
    }

    @Override
    public Authority createAuthority(Authority authority) {
        return authorityDAO.createAuthority(authority);
    }

    @Override
    public void deleteAuthority(int id) {
authorityDAO.deleteAuthority(id);
    }
}
