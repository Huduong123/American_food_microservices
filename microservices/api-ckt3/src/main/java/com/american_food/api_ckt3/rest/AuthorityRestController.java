package com.american_food.api_ckt3.rest;

import com.american_food.api_ckt3.entity.Authority;
import com.american_food.api_ckt3.service.AuthorityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system")
public class AuthorityRestController {
    private AuthorityService authorityService;

    public AuthorityRestController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping("/authorities")
    public List<Authority> getAuthorities() {
        return authorityService.getAllAuthorities();
    }

    @GetMapping("/authorities/{id}")
    public Authority getAuthority(@PathVariable int id) {
        return authorityService.getAuthorityById(id);
    }

    @PostMapping("/authorities")
    public Authority addAuthority(@RequestBody Authority authority) {
        authority.setId(0);
        return authorityService.createAuthority(authority);
    }

    @PutMapping("/authorities")
    public Authority updateAuthority(@RequestBody Authority authority) {
        Authority authority1 = authorityService.createAuthority(authority);
        return authority1;
    }

    @DeleteMapping("/authorities/{id}")
    public String deleteAuthority(@PathVariable int id) {
        authorityService.deleteAuthority(id);
        return "Authority deleted has id = " + id ;
    }
}
