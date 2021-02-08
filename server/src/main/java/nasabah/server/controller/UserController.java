/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.controller;

import java.util.List;
import nasabah.server.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import nasabah.server.model.*;
import nasabah.server.model.data.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Aisyah
 */
@RestController
public class UserController {
    
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    
    @GetMapping("all")
    public List<User> getAll(){
        return service.getAllData();
    } 
    
    @GetMapping("search")
    public User byNIK(@RequestBody User user){
        String nik = user.getNik();
        return service.getDataByNik(nik);
    }
    
    @PostMapping
    public User newNasabah(@RequestBody User user){
        return service.newNasabah(user);
    }
    
    @PutMapping("{nik}")
    public User updateNasabah(@RequestBody User user, @PathVariable String nik){
        return service.updateNasabah(user, nik);
    }
    
    @DeleteMapping()
    public String deleteNasabah(@RequestBody User user){
        try {
            service.deleteNasabah(user.getNik());
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }
}
