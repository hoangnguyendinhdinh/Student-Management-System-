/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BangDiem;

import Check.Check;
import LopHoc.ILopHocDAO;
import LopHoc.LopHoc;
import MonHoc.IMonHocDAO;
import MonHoc.MonHoc;
import SinhVien.ISinhVienDAO;
import SinhVien.SinhVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BKHN
 */
public final class frmBangDiem extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbmHS;
    private DefaultComboBoxModel dcbmLanThi;
    private DefaultButtonModel dbm;
    private DefaultComboBoxModel dcbmMaSV;
    private DefaultComboBoxModel dcbmMaMH;
    private DefaultComboBoxModel dcbmMaLop;
    ArrayList<SinhVien> listsv = null;
    ArrayList<MonHoc> listmh = null;
    ArrayList<BangDiem> listbdiem = null;
    ArrayList<LopHoc> listML = null;

    /**
     * Creates new form frmBangDiem
     */
    public frmBangDiem() {
        try {
            initComponents();
            dtm = new DefaultTableModel();
            dcbmHS = new DefaultComboBoxModel();
            dcbmLanThi = new DefaultComboBoxModel();
            dcbmMaSV = new DefaultComboBoxModel();
            dcbmMaMH = new DefaultComboBoxModel();
            dcbmMaLop = new DefaultComboBoxModel();
            dbm = new DefaultButtonModel();

            //Load Mon Hoc
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("MonHoc.MonHocDAO").newInstance();
            listmh = monHocDAO.getAll();
            for (MonHoc mh : listmh) {
                dcbmMaMH.addElement(mh.getMamh());
            }
            jcbMaMH.setModel(dcbmMaMH);
            //Load Ma Lop
            ILopHocDAO lopHocDAO = (ILopHocDAO) Class.forName("LopHoc.LopHocDAO").newInstance();
            listML = lopHocDAO.getAll();
            for (LopHoc lopHoc : listML) {
                dcbmMaLop.addElement(lopHoc.getMalop());
            }
            jcbMaLop.setModel(dcbmMaLop);
            //Load Ma sv
            try {
                ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("SinhVien.SinhVienDAO").newInstance();
                listsv = sinhVienDAO.getAll();
                dcbmMaSV.removeAllElements();
                for (SinhVien sv : listsv) {
                    dcbmMaSV.addElement(sv.getMasv());

                }

                jcbMasv.setModel(dcbmMaSV);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Load Lan Thi
            dcbmLanThi.addElement("0");
            dcbmLanThi.addElement("1");
            dcbmLanThi.addElement("2");
            dcbmLanThi.addElement("3");
            dcbmLanThi.addElement("4");
            dcbmLanThi.addElement("5");
            dcbmLanThi.addElement("6");
            jcbLanthi.setModel(dcbmLanThi);

            //Load He So
            dcbmHS.addElement("0");
            dcbmHS.addElement("1");
            dcbmHS.addElement("2");
            dcbmHS.addElement("3");
            dcbmHS.addElement("4");
            jcbHeSo.setModel(dcbmHS);

            //Ten Bang
            dtm.addColumn("Mã Sinh Viên");
            dtm.addColumn("Mã Môn Học");
            dtm.addColumn("Lần Thi");
            dtm.addColumn("Hệ Số");
            dtm.addColumn("Điểm");
            dtm.addColumn("Trạng Thái");
            loadData();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadData() {

        try {
            IBangDiemDAO bangDiemDAO = (IBangDiemDAO) Class.forName("BangDiem.BangDiemDAO").newInstance();
            listbdiem = bangDiemDAO.getAll();
            for (BangDiem bd : listbdiem) {
                dtm.addRow(toObjectData(bd));

            }
            jtbbangdiem.setModel(dtm);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Object[] toObjectData(BangDiem bd) {
        Object[] objects = {bd.getMasv(), bd.getMamh(), bd.getLanthi(), bd.getHeso(), bd.getDiem(), bd.isTrangthai()};
        return objects;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbLanthi = new javax.swing.JComboBox();
        jcbHeSo = new javax.swing.JComboBox();
        jcbMaLop = new javax.swing.JComboBox();
        jcbMasv = new javax.swing.JComboBox();
        jcbMaMH = new javax.swing.JComboBox();
        jrbTrangthai = new javax.swing.JRadioButton();
        jtfDiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jbNew = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbbangdiem = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 255, 0));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));

        jLabel1.setBackground(new java.awt.Color(0, 255, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KẾT QUẢ HỌC TẬP");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jPanel1.setBackground(new java.awt.Color(0, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Mã Lớp ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Mã Sinh Viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Mã Môn Học");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Lần Thi");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Điểm");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Hệ Số");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Trạng Thái");

        jcbLanthi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbHeSo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbMaLop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMaLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcbMaLopMouseReleased(evt);
            }
        });
        jcbMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMaLopActionPerformed(evt);
            }
        });
        jcbMaLop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbMaLopKeyReleased(evt);
            }
        });

        jcbMaMH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jrbTrangthai.setText("Đạt/Không đạt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbMaMH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbMasv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbMaLop, 0, 95, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43)
                                .addComponent(jtfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(38, 38, 38)
                                .addComponent(jcbLanthi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jrbTrangthai))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jcbHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbLanthi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jcbHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jrbTrangthai))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jcbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jPanel2.setLayout(new java.awt.GridLayout(4, 1));

        jbNew.setBackground(new java.awt.Color(153, 153, 255));
        jbNew.setForeground(new java.awt.Color(0, 51, 51));
        jbNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/plusitem.png"))); // NOI18N
        jbNew.setText("AddNew");
        jbNew.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewActionPerformed(evt);
            }
        });
        jPanel2.add(jbNew);

        jbUpdate.setBackground(new java.awt.Color(204, 204, 0));
        jbUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jbUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        jbUpdate.setText("Update");
        jbUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(jbUpdate);

        jbDelete.setBackground(new java.awt.Color(255, 255, 204));
        jbDelete.setForeground(new java.awt.Color(255, 0, 0));
        jbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        jbDelete.setText("Delete");
        jbDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jbDelete);

        jbExit.setForeground(new java.awt.Color(51, 255, 255));
        jbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        jbExit.setText("Reset");
        jbExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });
        jPanel2.add(jbExit);

        jScrollPane3.setBackground(new java.awt.Color(0, 255, 0));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));

        jtbbangdiem.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jtbbangdiem = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        jtbbangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jtbbangdiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbbangdiemMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbbangdiemMouseReleased(evt);
            }
        });
        jtbbangdiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbbangdiemKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtbbangdiem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        // TODO add your handling code here:
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            String masv = listsv.get(jcbMasv.getSelectedIndex()).getMasv();
            String mamh = listmh.get(jcbMasv.getSelectedIndex()).getMamh();
            int lanthi = jcbLanthi.getSelectedIndex();
            try {
                new BangDiemDAO().delBangDiem(masv, mamh, lanthi);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            loadData();
            jbNew.setEnabled(true);
            jbUpdate.setEnabled(false);
            jbDelete.setEnabled(false);
            jcbMasv.setEnabled(true);
            jcbMaMH.setEnabled(true);
            jcbLanthi.setEnabled(true);
            jcbMaLop.setEnabled(true);
        }
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jbNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewActionPerformed
        // TODO add your handling code here:
        if (!checkinfo()) {
            return;
        }
        String diem = jtfDiem.getText();
        int lanthi = jcbLanthi.getSelectedIndex();
        int heso = jcbHeSo.getSelectedIndex();
        boolean trangthai = jrbTrangthai.isSelected();
        String masv = listsv.get(jcbMasv.getSelectedIndex()).getMasv();
        String mamh = listmh.get(jcbMasv.getSelectedIndex()).getMamh();

        float diemsv;
        diemsv = Float.parseFloat(diem);
        if (diemsv > 10 || diemsv < 0) {
            JOptionPane.showMessageDialog(this, "Điểm phải nhập là số từ 0 - 10. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (lanthi == 0) {
            JOptionPane.showMessageDialog(this, "Lần Thi phải lớn hơn 0.Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (heso == 0) {
            JOptionPane.showMessageDialog(this, "Lần Thi phải lớn hơn 0.Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BangDiem bd = new BangDiem(masv, mamh, lanthi, heso, diemsv, trangthai);
        boolean result = new BangDiemDAO().CheckID(masv, mamh, lanthi);
        if (result) {
            JOptionPane.showMessageDialog(this, "Dữ liệu bị trùng, vui lòng kiểm tra lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            BangDiem insert = new BangDiemDAO().addNew(bd);
            if (insert != null) {
                showAll();
            }

        }

    }//GEN-LAST:event_jbNewActionPerformed
    public void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        ArrayList<BangDiem> bangDiems = new BangDiemDAO().getAll();
        for (BangDiem bd : bangDiems) {
            Vector v = new Vector();
            v.add(bd.getMasv());
            v.add(bd.getMamh());
            v.add(bd.getLanthi());
            v.add(bd.getHeso());
            v.add(bd.getDiem());
            if (bd.isTrangthai() == true) {
                v.add("Đạt");
            } else {
                v.add("Không đạt");

            }
            dtm.addRow(v);
        }
        resetForm();
    }

    public void resetForm() {
        jtfDiem.setText("");
        jcbHeSo.setSelectedItem(null);
        jcbLanthi.setSelectedItem(null);
        jcbMaMH.setSelectedItem(null);
        jcbMaLop.setSelectedItem(null);
        jcbMasv.setSelectedItem(null);
        jrbTrangthai.setSelected(true);

    }


    private void jcbMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMaLopActionPerformed
        // TODO add your handling code here:
        jcbMasv.setSelectedItem("");
        try {
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("SinhVien.SinhVienDAO").newInstance();
            listsv = sinhVienDAO.findByIDLop(listML.get(jcbMaLop.getSelectedIndex()).getMalop());
            dcbmMaSV.removeAllElements();
            for (SinhVien sv : listsv) {
                dcbmMaSV.addElement(sv.getMasv());

            }

            jcbMasv.setModel(dcbmMaSV);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbMaLopActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_jbExitActionPerformed
    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkSpace(jtfDiem.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập điểm sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfDiem.setText("");
            jtfDiem.requestFocus();
            return false;
        }
        return true;
    }
    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        // TODO add your handling code here:
        if (!checkinfo()) {
            return;
        }
        String diem = jtfDiem.getText();
        int lanthi = jcbLanthi.getSelectedIndex();
        int heso = jcbHeSo.getSelectedIndex();
        boolean trangthai = jrbTrangthai.isSelected();
        String masv = listsv.get(jcbMasv.getSelectedIndex()).getMasv();
        String mamh = listmh.get(jcbMasv.getSelectedIndex()).getMamh();

        float diemsv;
        diemsv = Float.parseFloat(diem);
        if (diemsv > 10 || diemsv < 0) {
            JOptionPane.showMessageDialog(this, "Điểm phải nhập là số từ 0 - 10. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jtfDiem.requestFocus();
            return;
        }

        if (lanthi == 0) {
            JOptionPane.showMessageDialog(this, "Lần Thi phải lớn hơn 0. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (heso == 0) {
            JOptionPane.showMessageDialog(this, "Hệ số phải lớn hơn 0. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BangDiem bd = new BangDiem(masv, mamh, lanthi, heso, diemsv, trangthai);
        BangDiem updateID = new BangDiemDAO().upDate(bd);
        if (updateID != null) {
            showAll();
        }
        jbNew.setEnabled(true);
        jbUpdate.setEnabled(false);
        jbDelete.setEnabled(false);
        jcbMasv.setEnabled(true);
        jcbMaMH.setEnabled(true);
        jcbLanthi.setEnabled(true);
        jcbMaLop.setEnabled(true);
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jtbbangdiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbbangdiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbbangdiemMouseClicked

    private void jtbbangdiemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbbangdiemMouseReleased
        // TODO add your handling code here:
        jcbMasv.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 0).toString());
        jcbMaMH.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 1).toString());
        jcbLanthi.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 2).toString());
        jcbHeSo.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 3).toString());
        jtfDiem.setText(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 4).toString());
        String trangthai = jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 5).toString();
        if (trangthai.equals("true")) {
            jrbTrangthai.setSelected(true);
        } else {
            jrbTrangthai.setSelected(false);

        }
        jbNew.setEnabled(false);
        jbUpdate.setEnabled(true);
        jbDelete.setEnabled(true);
        jcbMasv.setEnabled(false);
        jcbMaMH.setEnabled(false);
        jcbLanthi.setEnabled(false);
        jcbMaLop.setEnabled(false);
    }//GEN-LAST:event_jtbbangdiemMouseReleased

    private void jcbMaLopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMaLopMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMaLopMouseReleased

    private void jcbMaLopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMaLopKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMaLopKeyReleased

    private void jtbbangdiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbbangdiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbbangdiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbNew;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox jcbHeSo;
    private javax.swing.JComboBox jcbLanthi;
    private javax.swing.JComboBox jcbMaLop;
    private javax.swing.JComboBox jcbMaMH;
    private javax.swing.JComboBox jcbMasv;
    private javax.swing.JRadioButton jrbTrangthai;
    private javax.swing.JTable jtbbangdiem;
    private javax.swing.JTextField jtfDiem;
    // End of variables declaration//GEN-END:variables
}
