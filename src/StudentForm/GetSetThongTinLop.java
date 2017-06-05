/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentForm;

/**
 *
 * @author BKHN
 */
public class GetSetThongTinLop {

    private String malopdangki;
    private String mamh;
    private int sotrinh;
    private String tenmonhoc;
    private String thoigianhoc;
    private String phonghoc;
    private String mssv;

    GetSetThongTinLop(String mssv, String malopdangki, String mamh, String thoigianhoc, String phonghoc) {
        this.malopdangki = malopdangki;
        this.mamh = mamh;
        this.sotrinh = sotrinh;
        this.tenmonhoc = tenmonhoc;
        this.thoigianhoc = thoigianhoc;
        this.phonghoc = phonghoc;
        this.mssv = mssv;
    }

    GetSetThongTinLop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMalopdangki() {
        return malopdangki;
    }

    public void setMalopdangki(String malopdangki) {
        this.malopdangki = malopdangki;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public int getSotrinh() {
        return sotrinh;
    }

    public void setSotrinh(int sotrinh) {
        this.sotrinh = sotrinh;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    public String getThoigianhoc() {
        return thoigianhoc;
    }

    public void setThoigianhoc(String thoigianhoc) {
        this.thoigianhoc = thoigianhoc;
    }

    public String getPhonghoc() {
        return phonghoc;
    }

    public void setPhonghoc(String phonghoc) {
        this.phonghoc = phonghoc;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

}
