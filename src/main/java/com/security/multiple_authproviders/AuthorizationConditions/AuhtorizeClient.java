package com.security.multiple_authproviders.AuthorizationConditions;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class AuhtorizeClient {
    public boolean condition(String  name){
        if(name.equals(SecurityContextHolder.getContext().getAuthentication().getName()))
        return true;
        else
            return false;
    }
}
