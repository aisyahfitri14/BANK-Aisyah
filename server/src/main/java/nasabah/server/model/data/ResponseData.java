/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nasabah.server.model.data;

/**
 *
 * @author Aisyah
 */
public class ResponseData <E> {
    
    private E data;

    public ResponseData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}