/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author HP 245 G4
 */
public class listaPrestamo {
    private String ID,matri,libro,cat,carr,fecha,estado;

    public listaPrestamo(String ID, String matri, String libro, String cat, String carr, String fecha, String estado) {
        this.ID = ID;
        this.matri = matri;
        this.libro = libro;
        this.cat = cat;
        this.carr = carr;
        this.fecha = fecha;
        this.estado = estado;
        
    }

    

    public String getID() {
        return ID;
    }

    public String getMatri() {
        return matri;
    }

    public String getLibro() {
        return libro;
    }

    public String getCat() {
        return cat;
    }

    public String getCarr() {
        return carr;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setMatri(String ced) {
        this.matri = matri;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public void setCarr(String carr) {
        this.carr = carr;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "listaPrestamo{" + "ID=" + ID + ", matri=" + matri + ", libro=" + libro + ", cat=" + cat + ", carr=" + carr + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

   
    
    
    
}
