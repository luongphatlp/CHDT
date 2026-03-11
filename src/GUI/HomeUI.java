package GUI;

import DTO.NhanVienDTO;
import DTO.TaiKhoanSession;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.awt.Color;

/**
 *
 * @author THANH NHAN
 */
public class HomeUI extends javax.swing.JFrame {

    Color DefaultColor, ClickColor;

    public HomeUI() {
        com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme.setup();
        initComponents();

        jPanel3.setLayout(new java.awt.BorderLayout());
        DefaultColor = new Color(61, 67, 78);
        ClickColor = new Color(40, 46, 56);

        SP.setBackground(DefaultColor);
        NCC.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);
        
        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSuaThongTinCN = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton14 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        SP = new javax.swing.JPanel();
        sanpham = new javax.swing.JButton();
        NCC = new javax.swing.JPanel();
        nhacungcap = new javax.swing.JButton();
        NH = new javax.swing.JPanel();
        nhaphang = new javax.swing.JButton();
        PN = new javax.swing.JPanel();
        phieunhap = new javax.swing.JButton();
        HD = new javax.swing.JPanel();
        hoadon = new javax.swing.JButton();
        THHD = new javax.swing.JPanel();
        thhoadon = new javax.swing.JButton();
        KM = new javax.swing.JPanel();
        khuyenmai = new javax.swing.JButton();
        BH = new javax.swing.JPanel();
        baohanh = new javax.swing.JButton();
        pnTK = new javax.swing.JPanel();
        thongke = new javax.swing.JButton();
        NV = new javax.swing.JPanel();
        nhanvien = new javax.swing.JButton();
        btnXemTTCN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        PanelMenu = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setForeground(new java.awt.Color(0, 51, 102));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel2.setBackground(new java.awt.Color(61, 67, 78));
        jPanel2.setForeground(new java.awt.Color(232, 247, 250));
        jPanel2.setPreferredSize(new java.awt.Dimension(210, 1080));

        btnSuaThongTinCN.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnSuaThongTinCN.setForeground(new java.awt.Color(236, 240, 241));
        btnSuaThongTinCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        btnSuaThongTinCN.setText("Sửa thông tin");
        btnSuaThongTinCN.setBorderPainted(false);
        btnSuaThongTinCN.setContentAreaFilled(false);
        btnSuaThongTinCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaThongTinCNMouseClicked(evt);
            }
        });
        btnSuaThongTinCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinCNActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(193, 220, 223));
        jButton5.setFont(new java.awt.Font("Roboto", 2, 33)); // NOI18N
        jButton5.setForeground(new java.awt.Color(236, 240, 241));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bars-staggered_1.png"))); // NOI18N
        jButton5.setText("Menu");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(236, 240, 241));
        jSeparator1.setForeground(new java.awt.Color(236, 240, 241));

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton14.setForeground(new java.awt.Color(236, 240, 241));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jButton14.setText("Đăng xuất");
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(236, 240, 241));
        jSeparator2.setForeground(new java.awt.Color(236, 240, 241));

        SP.setBackground(new java.awt.Color(61, 67, 78));

        sanpham.setBackground(new java.awt.Color(61, 67, 78));
        sanpham.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        sanpham.setForeground(new java.awt.Color(236, 240, 241));
        sanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mobile-notch (1)_1.png"))); // NOI18N
        sanpham.setText(" Sản phẩm");
        sanpham.setBorderPainted(false);
        sanpham.setContentAreaFilled(false);
        sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sanphamMouseClicked(evt);
            }
        });
        sanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanphamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SPLayout = new javax.swing.GroupLayout(SP);
        SP.setLayout(SPLayout);
        SPLayout.setHorizontalGroup(
            SPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sanpham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SPLayout.setVerticalGroup(
            SPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sanpham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NCC.setBackground(new java.awt.Color(61, 67, 78));
        NCC.setPreferredSize(new java.awt.Dimension(0, 49));

        nhacungcap.setBackground(new java.awt.Color(61, 67, 78));
        nhacungcap.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        nhacungcap.setForeground(new java.awt.Color(236, 240, 241));
        nhacungcap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/supplier_1.png"))); // NOI18N
        nhacungcap.setText(" Nhà cung cấp");
        nhacungcap.setBorderPainted(false);
        nhacungcap.setContentAreaFilled(false);
        nhacungcap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhacungcapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout NCCLayout = new javax.swing.GroupLayout(NCC);
        NCC.setLayout(NCCLayout);
        NCCLayout.setHorizontalGroup(
            NCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NCCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nhacungcap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NCCLayout.setVerticalGroup(
            NCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NCCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nhacungcap)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        NH.setBackground(new java.awt.Color(61, 67, 78));

        nhaphang.setBackground(new java.awt.Color(61, 67, 78));
        nhaphang.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        nhaphang.setForeground(new java.awt.Color(236, 240, 241));
        nhaphang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/inbox-in.png"))); // NOI18N
        nhaphang.setText(" Nhập hàng");
        nhaphang.setBorderPainted(false);
        nhaphang.setContentAreaFilled(false);
        nhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhaphangMouseClicked(evt);
            }
        });
        nhaphang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhaphangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NHLayout = new javax.swing.GroupLayout(NH);
        NH.setLayout(NHLayout);
        NHLayout.setHorizontalGroup(
            NHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nhaphang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NHLayout.setVerticalGroup(
            NHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nhaphang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PN.setBackground(new java.awt.Color(61, 67, 78));
        PN.setPreferredSize(new java.awt.Dimension(0, 49));

        phieunhap.setBackground(new java.awt.Color(61, 67, 78));
        phieunhap.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        phieunhap.setForeground(new java.awt.Color(236, 240, 241));
        phieunhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file-import (2).png"))); // NOI18N
        phieunhap.setText(" Phiếu nhập");
        phieunhap.setBorderPainted(false);
        phieunhap.setContentAreaFilled(false);
        phieunhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phieunhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PNLayout = new javax.swing.GroupLayout(PN);
        PN.setLayout(PNLayout);
        PNLayout.setHorizontalGroup(
            PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phieunhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PNLayout.setVerticalGroup(
            PNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phieunhap)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        HD.setBackground(new java.awt.Color(61, 67, 78));
        HD.setPreferredSize(new java.awt.Dimension(0, 49));

        hoadon.setBackground(new java.awt.Color(61, 67, 78));
        hoadon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        hoadon.setForeground(new java.awt.Color(236, 240, 241));
        hoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document-paid_1.png"))); // NOI18N
        hoadon.setText(" Hóa đơn");
        hoadon.setBorderPainted(false);
        hoadon.setContentAreaFilled(false);
        hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hoadonMouseClicked(evt);
            }
        });
        hoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoadonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HDLayout = new javax.swing.GroupLayout(HD);
        HD.setLayout(HDLayout);
        HDLayout.setHorizontalGroup(
            HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HDLayout.createSequentialGroup()
                .addComponent(hoadon)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        HDLayout.setVerticalGroup(
            HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HDLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(hoadon)
                .addContainerGap())
        );

        THHD.setBackground(new java.awt.Color(61, 67, 78));

        thhoadon.setBackground(new java.awt.Color(61, 67, 78));
        thhoadon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        thhoadon.setForeground(new java.awt.Color(236, 240, 241));
        thhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/point-of-sale-bill.png"))); // NOI18N
        thhoadon.setText(" TH - Hóa đơn");
        thhoadon.setBorderPainted(false);
        thhoadon.setContentAreaFilled(false);
        thhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thhoadonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout THHDLayout = new javax.swing.GroupLayout(THHD);
        THHD.setLayout(THHDLayout);
        THHDLayout.setHorizontalGroup(
            THHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(THHDLayout.createSequentialGroup()
                .addComponent(thhoadon)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        THHDLayout.setVerticalGroup(
            THHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(THHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(thhoadon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        KM.setBackground(new java.awt.Color(61, 67, 78));
        KM.setPreferredSize(new java.awt.Dimension(0, 49));

        khuyenmai.setBackground(new java.awt.Color(61, 67, 78));
        khuyenmai.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        khuyenmai.setForeground(new java.awt.Color(236, 240, 241));
        khuyenmai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/percent_discount_32dp_000000_FILL0_wght400_GRAD0_opsz40.png"))); // NOI18N
        khuyenmai.setText(" Khuyến mãi");
        khuyenmai.setBorderPainted(false);
        khuyenmai.setContentAreaFilled(false);
        khuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                khuyenmaiMouseClicked(evt);
            }
        });
        khuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khuyenmaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KMLayout = new javax.swing.GroupLayout(KM);
        KM.setLayout(KMLayout);
        KMLayout.setHorizontalGroup(
            KMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(khuyenmai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        KMLayout.setVerticalGroup(
            KMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KMLayout.createSequentialGroup()
                .addComponent(khuyenmai)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        BH.setBackground(new java.awt.Color(61, 67, 78));

        baohanh.setBackground(new java.awt.Color(61, 67, 78));
        baohanh.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        baohanh.setForeground(new java.awt.Color(236, 240, 241));
        baohanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/warranty_1.png"))); // NOI18N
        baohanh.setText(" Bảo hành");
        baohanh.setBorderPainted(false);
        baohanh.setContentAreaFilled(false);
        baohanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baohanhMouseClicked(evt);
            }
        });
        baohanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baohanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BHLayout = new javax.swing.GroupLayout(BH);
        BH.setLayout(BHLayout);
        BHLayout.setHorizontalGroup(
            BHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BHLayout.createSequentialGroup()
                .addComponent(baohanh)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BHLayout.setVerticalGroup(
            BHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BHLayout.createSequentialGroup()
                .addComponent(baohanh)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pnTK.setBackground(new java.awt.Color(61, 67, 78));
        pnTK.setPreferredSize(new java.awt.Dimension(0, 49));

        thongke.setBackground(new java.awt.Color(61, 67, 78));
        thongke.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        thongke.setForeground(new java.awt.Color(236, 240, 241));
        thongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chart-simple (1)_1.png"))); // NOI18N
        thongke.setText(" Thống kê");
        thongke.setBorderPainted(false);
        thongke.setContentAreaFilled(false);
        thongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongkeMouseClicked(evt);
            }
        });
        thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTKLayout = new javax.swing.GroupLayout(pnTK);
        pnTK.setLayout(pnTKLayout);
        pnTKLayout.setHorizontalGroup(
            pnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTKLayout.createSequentialGroup()
                .addComponent(thongke)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnTKLayout.setVerticalGroup(
            pnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTKLayout.createSequentialGroup()
                .addComponent(thongke)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        NV.setBackground(new java.awt.Color(61, 67, 78));

        nhanvien.setBackground(new java.awt.Color(61, 67, 78));
        nhanvien.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        nhanvien.setForeground(new java.awt.Color(236, 240, 241));
        nhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/member-list.png"))); // NOI18N
        nhanvien.setText(" Nhân viên");
        nhanvien.setBorderPainted(false);
        nhanvien.setContentAreaFilled(false);
        nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhanvienMouseClicked(evt);
            }
        });
        nhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanvienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NVLayout = new javax.swing.GroupLayout(NV);
        NV.setLayout(NVLayout);
        NVLayout.setHorizontalGroup(
            NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nhanvien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NVLayout.setVerticalGroup(
            NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nhanvien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXemTTCN.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnXemTTCN.setForeground(new java.awt.Color(236, 240, 241));
        btnXemTTCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user (4).png"))); // NOI18N
        btnXemTTCN.setText(" Xem thông tin");
        btnXemTTCN.setBorderPainted(false);
        btnXemTTCN.setContentAreaFilled(false);
        btnXemTTCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXemTTCNMouseClicked(evt);
            }
        });
        btnXemTTCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTTCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NCC, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addComponent(NH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PN, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addComponent(NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HD, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(THHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(KM, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(BH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnTK, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                    .addComponent(btnXemTTCN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSuaThongTinCN)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(THHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXemTTCN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaThongTinCN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addGap(51, 51, 51))
        );

        jPanel4.setBackground(new java.awt.Color(116, 151, 151));
        jPanel4.setPreferredSize(new java.awt.Dimension(1710, 1080));
        jPanel4.setLayout(new java.awt.BorderLayout());

        PanelMenu.setkEndColor(new java.awt.Color(142, 122, 188));
        PanelMenu.setkGradientFocus(1000);
        PanelMenu.setkStartColor(new java.awt.Color(75, 47, 141));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("ROG Fonts", 1, 80)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("tnftn ");

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(471, 471, 471)
                        .addComponent(jLabel1))
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(748, 748, 748)
                        .addComponent(jLabel2)))
                .addContainerGap(746, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(423, Short.MAX_VALUE))
        );

        jPanel4.add(PanelMenu, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1952, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 2166, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void baohanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baohanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_baohanhActionPerformed

    private void btnSuaThongTinCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinCNActionPerformed
        // TODO add your handling code here:
        DTO.TaiKhoanSession.capnhat();
        
        NhanVienUI nvGUI = new NhanVienUI();
        NhanVienDTO nvDN = DTO.TaiKhoanSession.nvDangNhap;
        
        SuaNhanVienUI suaForm = new SuaNhanVienUI();
        
        String ma = nvDN.getMaNV();
        String hoten = nvDN.getHotenNV();
        String email = nvDN.getEmailNV();
        java.util.Date ns = nvDN.getNgaySinh();
        String cv = nvDN.getChucVu();
        String tt = "1";
       
        
        suaForm.setThongTin(ma, hoten, email, ns, cv, "1");
        
        suaForm.quyenAmdin(false);
        
        suaForm.setVisible(true);
        suaForm.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnSuaThongTinCNActionPerformed

    private void thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongkeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thongkeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void nhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanvienActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sanphamMouseClicked
        SP.setBackground(ClickColor);
        NCC.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);

        SanPhamUI s = new SanPhamUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_sanphamMouseClicked

    private void nhacungcapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhacungcapMouseClicked
        NCC.setBackground(ClickColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);

        NhaCungCapUI s = new NhaCungCapUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_nhacungcapMouseClicked

    private void khuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khuyenmaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_khuyenmaiActionPerformed

    private void nhaphangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhaphangActionPerformed

    }//GEN-LAST:event_nhaphangActionPerformed

    private void sanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanphamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sanphamActionPerformed

    private void nhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhaphangMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(ClickColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);

        NhapHangUI s = new NhapHangUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_nhaphangMouseClicked

    private void phieunhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phieunhapMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(ClickColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);

        PhieuNhapUI s = new PhieuNhapUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();


    }//GEN-LAST:event_phieunhapMouseClicked

    private void hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hoadonMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(ClickColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);
        HoaDonUI s = new HoaDonUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();

    }//GEN-LAST:event_hoadonMouseClicked

    private void thhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thhoadonMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(ClickColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);
        
        THHoaDonUI s = new THHoaDonUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
        
    }//GEN-LAST:event_thhoadonMouseClicked

    private void khuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_khuyenmaiMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);
        
        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(ClickColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);

        KhuyenMaiUI s = new KhuyenMaiUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
        

    }//GEN-LAST:event_khuyenmaiMouseClicked

    private void baohanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baohanhMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(ClickColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(DefaultColor);
        
        BaoHanhUI s = new BaoHanhUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();

    }//GEN-LAST:event_baohanhMouseClicked

    private void thongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongkeMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(ClickColor);
        NV.setBackground(DefaultColor);

        ThongKeUI s = new ThongKeUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_thongkeMouseClicked

    private void nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhanvienMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        KM.setBackground(DefaultColor);
        BH.setBackground(DefaultColor);
        pnTK.setBackground(DefaultColor);
        NV.setBackground(ClickColor);

        NhanVienUI s = new NhanVienUI ();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_nhanvienMouseClicked

    private void hoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoadonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_hoadonActionPerformed

    private void btnSuaThongTinCNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaThongTinCNMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnSuaThongTinCNMouseClicked

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        // TODO add your handling code here:
        Login s = new Login();
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton14MouseClicked

    private void btnXemTTCNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXemTTCNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXemTTCNMouseClicked

    private void btnXemTTCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTTCNActionPerformed
        // TODO add your handling code here:
        
        XemTTCaNhanUI xemForm = new XemTTCaNhanUI() ;
        xemForm.setVisible(true);
        xemForm.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnXemTTCNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
           ex.printStackTrace();
        }
        //</editor-fold>
        try {
            com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme.setup();
        } catch (Exception ex) {

        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new HomeUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BH;
    private javax.swing.JPanel HD;
    private javax.swing.JPanel KM;
    private javax.swing.JPanel NCC;
    private javax.swing.JPanel NH;
    private javax.swing.JPanel NV;
    private javax.swing.JPanel PN;
    private keeptoo.KGradientPanel PanelMenu;
    private javax.swing.JPanel SP;
    private javax.swing.JPanel THHD;
    private javax.swing.JButton baohanh;
    private javax.swing.JButton btnSuaThongTinCN;
    private javax.swing.JButton btnXemTTCN;
    private javax.swing.JButton hoadon;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton khuyenmai;
    private javax.swing.JButton nhacungcap;
    private javax.swing.JButton nhanvien;
    private javax.swing.JButton nhaphang;
    private javax.swing.JButton phieunhap;
    private javax.swing.JPanel pnTK;
    private javax.swing.JButton sanpham;
    private javax.swing.JButton thhoadon;
    private javax.swing.JButton thongke;
    // End of variables declaration//GEN-END:variables
}
