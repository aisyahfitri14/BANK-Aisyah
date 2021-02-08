/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.repository;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nasabah.server.model.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aisyah
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    public Optional<User> findByNik(String nik);
    
    @Query(value="SELECT * FROM user WHERE NIK = ?1", nativeQuery = true)
    public User userByNIK(String nik);
    
    @Modifying
    @Transactional
    @Query(value="INSERT INTO `user`(`NIK`, `nama_lengkap`, `password`, `alamat`, `tempat_lahir`, `tgl_lahir`, `phone`, `status`, `is_verified`) VALUES (?1,?2,?3,?4,?5,?6)", nativeQuery = true)
    void insertNasabah(String nik, String nama, String alamat, String tempatLahir, Date tglLahir, String phone);
    
    @Modifying
    @Transactional
    @Query(value="UPDATE `user` SET `nama_lengkap`=?2,`alamat`=?3,`tempat_lahir`=?4,`tgl_lahir`=?5,`phone`=?6 WHERE NIK = ?1", nativeQuery = true)
    void updateNasabah(String nik, String nama, String alamat, String tempatLahir, Date tglLahir, String phone);
    
    @Modifying
    @Transactional
    @Query(value="DELETE FROM `user` WHERE NIK = ?1", nativeQuery = true)
    void deleteNasabah(String nik);
    
}
