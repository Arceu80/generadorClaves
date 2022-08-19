/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorclaves;

import java.util.HashMap;

/**
 *
 * @author Francisco
 */
public class Raideo {
    
    private int idclave;
    
    private String fecha;
    
    private String tribu;
    
    private String base;
    
    private HashMap<Integer, String> jugadores;

    public Raideo(int idclave, String fecha, String tribu, String base) {
        this.idclave = idclave;
        this.fecha = fecha;
        this.tribu = tribu;
        this.base = base;
        jugadores=new HashMap();
    }

    public int getIdclave() {
        return idclave;
    }

    public void setIdclave(int idclave) {
        this.idclave = idclave;
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
    
    public void anyadirjugador(String j){
        jugadores.put(jugadores.size()+1, j);
    }

    @Override
    public String toString() {
        return "Raideo{" + "idclave=" + idclave + ", fecha=" + fecha + ", tribu=" + tribu + ", base=" + base + ", jugadores=" + jugadores + '}';
    }


    
}
