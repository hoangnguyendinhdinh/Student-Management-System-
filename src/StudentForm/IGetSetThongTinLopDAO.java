/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentForm;

import java.util.ArrayList;

/**
 *
 * @author BKHN
 */
public interface IGetSetThongTinLopDAO {

    public ArrayList<GetSetThongTinLop> getAll();

    public GetSetThongTinLop addNew(GetSetThongTinLop add);

    public ArrayList<GetSetThongTinLop> CheckID(String mamh);
}
