/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author Aisyah
 */
@Entity
@Table(name = "user", catalog = "nasabah", schema = "")
@XmlRootElement
@Data
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByNik", query = "SELECT u FROM User u WHERE u.nik = :nik")
    , @NamedQuery(name = "User.findByNamaLengkap", query = "SELECT u FROM User u WHERE u.namaLengkap = :namaLengkap")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByAlamat", query = "SELECT u FROM User u WHERE u.alamat = :alamat")
    , @NamedQuery(name = "User.findByTempatLahir", query = "SELECT u FROM User u WHERE u.tempatLahir = :tempatLahir")
    , @NamedQuery(name = "User.findByTglLahir", query = "SELECT u FROM User u WHERE u.tglLahir = :tglLahir")
    , @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone")
    , @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status")
    , @NamedQuery(name = "User.findByIsVerified", query = "SELECT u FROM User u WHERE u.isVerified = :isVerified")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "NIK", nullable = false, length = 16)
    private String nik;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nama_lengkap", nullable = false, length = 250)
    private String namaLengkap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "password", nullable = false, length = 250)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "alamat", nullable = false, length = 250)
    private String alamat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tempat_lahir", nullable = false, length = 250)
    private String tempatLahir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tgl_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tglLahir;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "phone", nullable = false, length = 12)
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_verified", nullable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isVerified;

    public User() {
    }

    public User(String nik) {
        this.nik = nik;
    }

    public User(String nik, String namaLengkap, String password, String alamat, String tempatLahir, Date tglLahir, String phone, int status, boolean isVerified) {
        this.nik = nik;
        this.namaLengkap = namaLengkap;
        this.password = password;
        this.alamat = alamat;
        this.tempatLahir = tempatLahir;
        this.tglLahir = tglLahir;
        this.phone = phone;
        this.status = status;
        this.isVerified = isVerified;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nasabah.server.model.User[ nik=" + nik + " ]";
    }
    
}
