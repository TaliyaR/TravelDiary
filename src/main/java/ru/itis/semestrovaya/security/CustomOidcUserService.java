package ru.itis.semestrovaya.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import ru.itis.semestrovaya.repositories.UsersRepository;

public class CustomOidcUserService extends OidcUserService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        return super.loadUser(userRequest);

//        try {
//            return processOidUser(userRequest, oidUser)
//        }
    }
}
