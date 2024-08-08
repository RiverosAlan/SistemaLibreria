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
public class recibo {
    private String codP,matric,codL,fechaP,fechaD;

    public recibo(String codP, String matric, String codL, String fechaP, String fechaD) {
        this.codP = codP;
        this.matric = matric;
        this.codL = codL;
        this.fechaP = fechaP;
        this.fechaD = fechaD;
    }
    recibo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCodP() {
        return codP;
    }

    public String getMatric() {
        return matric;
    }

    public String getCodL() {
        return codL;
    }

    public String getFechaP() {
        return fechaP;
    }

    public String getFechaD() {
        return fechaD;
    }

    public void setCodP(String codP) {
        this.codP = codP;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public void setCodL(String codL) {
        this.codL = codL;
    }

    public void setFechaP(String fechaP) {
        this.fechaP = fechaP;
    }

    public void setFechaD(String fechaD) {
        this.fechaD = fechaD;
    }
    
}
