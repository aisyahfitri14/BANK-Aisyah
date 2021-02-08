/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Aisyah
 */
public class MyUserDetail implements UserDetails{
    
    private User user;

    public MyUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getNik();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isIsVerified();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isIsVerified();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isIsVerified();
    }

    @Override
    public boolean isEnabled() {
        return user.isIsVerified();
    }
    
}
