/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author TORREZ PC
 */
public class listaLibro {
    private String titu,cate,carl,aut,fep;

    public listaLibro(String titu, String cate, String carl, String aut, String fep) {
        this.titu = titu;
        this.cate = cate;
        this.carl = carl;
        this.aut = aut;
        this.fep = fep;
    }

    public String getTitu() {
        return titu;
    }

    public String getCate() {
        return cate;
    }

    public String getCarl() {
        return carl;
    }

    public String getAut() {
        return aut;
    }

    public String getFep() {
        return fep;
    }

    public void setTitu(String titu) {
        this.titu = titu;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public void setCarl(String carl) {
        this.carl = carl;
    }

    public void setAut(String aut) {
        this.aut = aut;
    }

    public void setFep(String fep) {
        this.fep = fep;
    }
    
}
