package MonHoc;

import java.util.ArrayList;

public interface IMonHocDAO {

    public ArrayList<MonHoc> getAll();

    public ArrayList<MonHoc> findIDMaMH(String maMH);

    public MonHoc addNew(MonHoc mh);

    public MonHoc updateByID(MonHoc mh);

    public ArrayList<MonHoc> CheckID(String mamh);
}
