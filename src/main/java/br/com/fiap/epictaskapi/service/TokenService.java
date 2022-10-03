package br.com.fiap.epictaskapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.UserRepository;

public class TokenService {
    
    @Autowired
    UserRepository repository;

    public boolean validate(String token) {

        try{
            JWT.require(Algorithm.HMAC512("secret")).build().verify(token);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    public Authentication getAuthenticationToken(String token) {
        String email = JWT.require(Algorithm.HMAC512("secret")).build().verify(token).getSubject();
        
        Optional<User> optional = repository.findByEmail(email);
        if (optional.isEmpty()) return null;
        var user = optional.get();
        Authentication authentication = 
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        
        return authentication;
    }
    
}
