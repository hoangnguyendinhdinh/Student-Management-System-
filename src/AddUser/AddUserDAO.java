/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddUser;

import ConnectDatabase.DBConnect;
import Khoa.KhoaDAO;
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
public class AddUserDAO implements IAddUserDAO {

    @Override
    public ArrayList<AddUser> getAll() {
        ArrayList<AddUser> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblDangNhap");
                rs = ps.executeQuery();
                list = new ArrayList<AddUser>();
                while (rs.next()) {
                    AddUser addu = new AddUser();
                    addu.setTendangnhap(rs.getString(1));
                    addu.setMatkhau(rs.getString(2));
                    addu.setHovaten(rs.getString(3));
                    addu.setEmail(rs.getString(4));
                    addu.setVaitro(rs.getString(5));
                    list.add(addu);

                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;

    }

    @Override
    public AddUser addNew(AddUser user) {

        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {

                ps = DBConnect.cnn.prepareStatement("INSERT INTO tblDangNhap VALUES (?,?,?,?,?)");
                ps.setString(1, user.getTendangnhap());
                ps.setString(2, user.getMatkhau());
                ps.setString(3, user.getHovaten());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getVaitro());

                int row = ps.executeUpdate();
                if (row < 1) {
                    user = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
                user = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return null;

    }

    public void deleteUser(String tenDangNhap) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblDangNhap where fldTenDangNhap = ?");
            ps.setString(1, tenDangNhap);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public AddUser updateByID(AddUser user) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update tblDangNhap set fldMatKhau =?, "
                        + "fldHoTen=?,"
                        + "fldEmail=?, fldtype=?,"
                        + " where fldTenDangNhap = ?");

                ps.setString(1, user.getMatkhau());
                ps.setString(2, user.getHovaten());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getVaitro());
                ps.setString(5, user.getTendangnhap());
                int row = ps.executeUpdate();
                if (row < 1) {
                    user = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
                user = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return user;

    }

    @Override
    public ArrayList<AddUser> checkID(String tendangnhap) {
        ArrayList<AddUser> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblDangNhap where fldTenDangNhap=?");
                psCheck.setString(1, tendangnhap);
                rs = psCheck.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    AddUser user = new AddUser();
                    user.setTendangnhap(rs.getString(1));
                    list.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return list;

    }

    @Override
    public ArrayList<AddUser> findTENDN(String tenDN) {

        ArrayList<AddUser> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tbldangNhap where fldTenDangNhap =?");
                ps.setString(1, tenDN);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    AddUser user = new AddUser();
                    user.setTendangnhap(rs.getString(1));
                    user.setMatkhau(rs.getString(2));
                    user.setHovaten(rs.getString(3));
                    user.setEmail(rs.getString(4));
                    user.setVaitro(rs.getString(5));

                    list.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;

    }

}
