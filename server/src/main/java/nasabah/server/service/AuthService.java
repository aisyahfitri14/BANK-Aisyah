/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import nasabah.server.model.*;
import nasabah.server.model.data.*;
import nasabah.server.repository.UserRepository;

/**
 *
 * @author Aisyah
 */
@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailService service;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(AuthDataRequest request) {
        MyUserDetail user = (MyUserDetail) service.loadUserByUsername(request.getNik());
        if (user.isAccountNonLocked()) {
            try {
                UsernamePasswordAuthenticationToken authReq
                        = new UsernamePasswordAuthenticationToken(request.getNik(), request.getPassword());
                
                Authentication auth = authManager.authenticate(authReq);
                System.out.println(auth);
                SecurityContextHolder.getContext().setAuthentication(auth);
                return "success";
            } catch (AuthenticationException e) {
                return "failed";
            }
        }

        return "lock";
    }

    public AuthDataResponse createAuthenticationResponse() {
        List<String> authorities = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : auth.getAuthorities()) {
            authorities.add(authority.getAuthority());
        }

        return new AuthDataResponse(authorities);
    }
}
