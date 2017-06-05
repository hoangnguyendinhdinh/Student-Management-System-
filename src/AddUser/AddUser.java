/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddUser;

import java.util.ArrayList;

/**
 *
 * @author BKHN
 */
public class AddUser {

    private String tendangnhap;
    private String matkhau;
    private String hovaten;
    private String email;
    private String vaitro;
    private ArrayList<AddUser> listUser;

 
    public void setListUser(ArrayList<AddUser> listUser) {
        this.listUser = listUser;
    }

    public AddUser() {
    }

    public AddUser(String tendangnhap, String matkhau, String hovaten, String email, String vaitro) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.hovaten = hovaten;
        this.email = email;
        this.vaitro = vaitro;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

}
