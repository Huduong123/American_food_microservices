package com.american_food.api_ckt3.service;

import com.american_food.api_ckt3.entity.Authority;

import java.util.List;

public interface AuthorityService {
    Authority getAuthorityById(int id);
    List<Authority> getAllAuthorities();
    Authority createAuthority(Authority authority);
    void deleteAuthority(int id);
}
