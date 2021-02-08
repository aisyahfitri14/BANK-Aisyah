/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.service;

import nasabah.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import nasabah.server.model.*;

/**
 *
 * @author Aisyah
 */
@Service
public class MyUserDetailService implements UserDetailsService{
    
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String nik) throws UsernameNotFoundException {
        User user = repo.findByNik(nik)
                .orElseThrow(() -> new UsernameNotFoundException("User not registered"));
        
        return new MyUserDetail(user); 
    }
    
}
