/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorclaves;

/**
 *
 * @author Francisco
 */
public class Raideo {
    
    private int id;
    
    private int idclave;
    
    private String clave;
    
    private String fecha;
    
    private String tribu;
    
    private String base;

    public Raideo(int id, int idclave, String clave, String fecha, String tribu, String base) {
        this.id = id;
        this.idclave = idclave;
        this.clave = clave;
        this.fecha = fecha;
        this.tribu = tribu;
        this.base = base;
    }

    public int getIdclave() {
        return idclave;
    }

    public void setIdclave(int idclave) {
        this.idclave = idclave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTribu() {
        return tribu;
    }

    public void setTribu(String tribu) {
        this.tribu = tribu;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Raideo{" + "id=" + id + ", idclave=" + idclave + ", clave=" + clave + ", fecha=" + fecha + ", tribu=" + tribu + ", base=" + base + '}';
    }
    
}
