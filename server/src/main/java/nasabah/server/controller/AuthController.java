/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.controller;

import javax.servlet.http.HttpServletRequest;
import nasabah.server.model.data.*;
import nasabah.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aisyah
 */
@RestController
@RequestMapping("api/")
public class AuthController {
    @Autowired
    private AuthService service;
    
    @PostMapping("login")
    public ResponseApi<AuthDataResponse> login(@RequestBody AuthDataRequest request) {
        String responseData = service.login(request);
        if (responseData.equalsIgnoreCase("success")) {
            return ResponseApi.apiOk(service.createAuthenticationResponse(), "You have been logged");
        } else if (responseData.equalsIgnoreCase("failed")) {
            return ResponseApi.apiFailed("Username or password incorect", HttpStatus.UNAUTHORIZED);
        }
        return ResponseApi.apiFailed("Your account locked!", HttpStatus.DESTINATION_LOCKED);
    }
    
    @PostMapping("logout")
    public ResponseMessage logout(HttpServletRequest request) {

        SecurityContextHolder.getContext().setAuthentication(null);

        return new ResponseMessage(null, "You have been logged out.");
    }
}
