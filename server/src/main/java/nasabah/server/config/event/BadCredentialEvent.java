/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.config.event;

import java.util.Optional;
import nasabah.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;
import nasabah.server.model.*;

/**
 *
 * @author Aisyah
 */
@Component
public class BadCredentialEvent implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    private UserRepository repository;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        updateUserVerifiedStatus(e.getAuthentication().getName());
    }

    private void updateUserVerifiedStatus(String nik) {
        User user = repository.findByNik(nik).get();
        int userStatus = user.getStatus();
        if (userStatus != 3) {
            user.setStatus(user.getStatus() + 1);
        }else{
            user.setIsVerified(false);
        }
        repository.save(user);
    }
}
