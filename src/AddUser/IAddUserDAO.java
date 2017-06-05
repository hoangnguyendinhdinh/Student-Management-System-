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
public interface IAddUserDAO {

    public ArrayList<AddUser> getAll();

    public ArrayList<AddUser> findTENDN(String tenDN);

    public AddUser addNew(AddUser user);

    public AddUser updateByID(AddUser user);

    public ArrayList<AddUser> checkID(String tendangnhap);
}
