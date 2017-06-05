
package GiaoVien;

import java.util.ArrayList;

public interface IGiaoVienDAO {

    public ArrayList<GiaoVien> getAll();

    public ArrayList<GiaoVien> findByIDMonHoc(String mamh);

    public GiaoVien addNew(GiaoVien gv);

    public GiaoVien updateByID(GiaoVien gv);

    public ArrayList<GiaoVien> CheckID(String magv);

}
