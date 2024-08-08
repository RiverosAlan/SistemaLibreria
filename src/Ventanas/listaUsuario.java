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
public class listaUsuario {
    private String car,nom,pat,mat,fech,carr,tel;
    public listaUsuario(String car,String nom,String pat,String mat,String fech,String carr,String tel)
            {
                this.car=car;
                this.carr=carr;
                this.fech=fech;
                this.mat=mat;
                this.nom=nom;
                this.pat=pat;
                this.tel=tel;
            }

    public String getCar() {
        return car;
    }

    public String getNom() {
        return nom;
    }

    public String getPat() {
        return pat;
    }

    public String getMat() {
        return mat;
    }

    public String getFech() {
        return fech;
    }

    public String getCarr() {
        return carr;
    }

    public String getTel() {
        return tel;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public void setFech(String fech) {
        this.fech = fech;
    }

    public void setCarr(String carr) {
        this.carr = carr;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
            
}
