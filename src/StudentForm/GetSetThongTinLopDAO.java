/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentForm;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BKHN
 */
public class GetSetThongTinLopDAO implements IGetSetThongTinLopDAO {

    @Override
    public ArrayList<GetSetThongTinLop> getAll() {
        ArrayList<GetSetThongTinLop> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblDangKiHocTap");
                rs = ps.executeQuery();

                list = new ArrayList<GetSetThongTinLop>();
                while (rs.next()) {
                    GetSetThongTinLop getLop = new GetSetThongTinLop();
                    getLop.setMalopdangki(rs.getString(1));
                    getLop.setMamh(rs.getString(2));
                    getLop.setTenmonhoc(rs.getString(3));
                    getLop.setThoigianhoc(rs.getString(4));
                    getLop.setPhonghoc(rs.getString(5));
                    getLop.setSotrinh(rs.getInt(6));

                    list.add(getLop);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GetSetThongTinLopDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public ArrayList<GetSetThongTinLop> CheckID(String thongtinlop) {
        ArrayList<GetSetThongTinLop> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblDangKiHocTap where fldMaLopDangKi=?");
                psCheck.setString(1, thongtinlop);
                rs = psCheck.executeQuery();
                list = new ArrayList<GetSetThongTinLop>();
                while (rs.next()) {
                    GetSetThongTinLop getSet = new GetSetThongTinLop();
                    getSet.setMalopdangki(rs.getString(1));
                    list.add(getSet);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GetSetThongTinLopDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return list;

    }

    @Override
    public GetSetThongTinLop addNew(GetSetThongTinLop add) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO KetQuaDangKi values (?,?,?,?,?)");
                ps.setString(1, add.getMssv());
                ps.setString(2, add.getMalopdangki());
                ps.setString(3, add.getMamh());
                ps.setString(4, add.getThoigianhoc());
                ps.setString(5, add.getPhonghoc());
                int row = ps.executeUpdate();
                if (row < 1) {
                    add = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GetSetThongTinLopDAO.class.getName()).log(Level.SEVERE, null, ex);
                add = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return add;
    }

}
