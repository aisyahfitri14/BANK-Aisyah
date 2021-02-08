/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.service;

import java.util.Date;
import java.util.List;
import nasabah.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nasabah.server.model.*;
import nasabah.server.model.data.ResponseApi;

/**
 *
 * @author Aisyah
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    
    public List<User> getAllData() {
        return repo.findAll();
    }
    
    public User getDataByNik(String nik){
        return repo.userByNIK(nik);
    }
    
    public User newNasabah(User user){
        String nik = user.getNik();
        String nama = user.getNamaLengkap();
        String alamat = user.getAlamat();
        String tempatLahir = user.getTempatLahir();
        Date tglLahir = user.getTglLahir();
        String phone = user.getPhone();
        
        repo.insertNasabah(nik, nama, alamat, tempatLahir, tglLahir, phone);
        
        return user;
    }
    
    public User updateNasabah(User user, String nik){
        String nama = user.getNamaLengkap();
        String alamat = user.getAlamat();
        String tempatLahir = user.getTempatLahir();
        Date tglLahir = user.getTglLahir();
        String phone = user.getPhone();
        
        repo.updateNasabah(nik, nama, alamat, tempatLahir, tglLahir, phone);
        
        return user;
    }
    
    public void deleteNasabah(String nik){
        repo.deleteNasabah(nik);
        
    }
}
