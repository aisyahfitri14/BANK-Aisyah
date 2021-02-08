/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.model.data;

import lombok.Data;

/**
 *
 * @author Aisyah
 */
@Data
public class AuthDataRequest {
    private String nik;
    private String password;

    public AuthDataRequest(String nik, String password) {
        this.nik = nik;
        this.password = password;
    }
}
