package GUI;

import DTO.NhanVienDTO;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.awt.Color;

/**
 *
 * @author THANH NHAN
 */
public class HomeUserUI extends javax.swing.JFrame {

    Color DefaultColor, ClickColor;

    public HomeUserUI() {
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

        BH.setBackground(DefaultColor);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSuaThongTin = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnDangXuat = new javax.swing.JButton();
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
        BH = new javax.swing.JPanel();
        baohanh = new javax.swing.JButton();
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

        btnSuaThongTin.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnSuaThongTin.setForeground(new java.awt.Color(236, 240, 241));
        btnSuaThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        btnSuaThongTin.setText("Sửa thông tin");
        btnSuaThongTin.setBorderPainted(false);
        btnSuaThongTin.setContentAreaFilled(false);
        btnSuaThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaThongTinMouseClicked(evt);
            }
        });
        btnSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(193, 220, 223));
        jButton5.setFont(new java.awt.Font("Roboto", 2, 33)); // NOI18N
        jButton5.setForeground(new java.awt.Color(236, 240, 241));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bars-staggered_1.png"))); // NOI18N
        jButton5.setText("USER");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(236, 240, 241));
        jSeparator1.setForeground(new java.awt.Color(236, 240, 241));

        btnDangXuat.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(236, 240, 241));
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setContentAreaFilled(false);
        btnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseClicked(evt);
            }
        });
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(baohanh)
                .addContainerGap())
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
                            .addComponent(BH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnXemTTCN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSuaThongTin)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDangXuat)
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
                .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXemTTCN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaThongTin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat)
                .addGap(51, 51, 51))
        );

        jPanel4.setBackground(new java.awt.Color(116, 151, 151));
        jPanel4.setPreferredSize(new java.awt.Dimension(1710, 1080));
        jPanel4.setLayout(new java.awt.BorderLayout());

        PanelMenu.setkEndColor(new java.awt.Color(103, 141, 171));
        PanelMenu.setkGradientFocus(1000);
        PanelMenu.setkStartColor(new java.awt.Color(71, 138, 164));

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
                        .addGap(660, 660, 660)
                        .addComponent(jLabel2)))
                .addContainerGap(746, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
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

    private void btnSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinActionPerformed
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
        
        suaForm.setThongTin(ma, hoten, email, ns, cv,"1");
        
        suaForm.quyenAmdin(false);
        
        suaForm.setVisible(true);
        suaForm.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnSuaThongTinActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sanphamMouseClicked
        SP.setBackground(ClickColor);
        NCC.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);

        BH.setBackground(DefaultColor);


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

        BH.setBackground(DefaultColor);


        NhaCungCapUI s = new NhaCungCapUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_nhacungcapMouseClicked

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
   
        BH.setBackground(DefaultColor);
      

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
    
        BH.setBackground(DefaultColor);
   

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
        
        BH.setBackground(DefaultColor);
        
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
        
        BH.setBackground(DefaultColor);
        
        
        THHoaDonUI s = new THHoaDonUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();
        
    }//GEN-LAST:event_thhoadonMouseClicked

    private void baohanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baohanhMouseClicked
        // TODO add your handling code here:
        NCC.setBackground(DefaultColor);
        SP.setBackground(DefaultColor);
        NH.setBackground(DefaultColor);
        PN.setBackground(DefaultColor);

        HD.setBackground(DefaultColor);
        THHD.setBackground(DefaultColor);
        
        BH.setBackground(ClickColor);
        
        
        BaoHanhUI s = new BaoHanhUI();
        jPanel4.removeAll();
        jPanel4.add(s, java.awt.BorderLayout.CENTER);
        jPanel4.revalidate();
        jPanel4.repaint();

    }//GEN-LAST:event_baohanhMouseClicked

    private void hoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoadonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_hoadonActionPerformed

    private void btnSuaThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaThongTinMouseClicked
        // TODO add your handling code here:
        SuaThongTinUI s = new SuaThongTinUI();
        s.setVisible(true);
        
    }//GEN-LAST:event_btnSuaThongTinMouseClicked

    private void btnDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseClicked
        // TODO add your handling code here:
        Login s = new Login();
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDangXuatMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new HomeUserUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BH;
    private javax.swing.JPanel HD;
    private javax.swing.JPanel NCC;
    private javax.swing.JPanel NH;
    private javax.swing.JPanel PN;
    private keeptoo.KGradientPanel PanelMenu;
    private javax.swing.JPanel SP;
    private javax.swing.JPanel THHD;
    private javax.swing.JButton baohanh;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnSuaThongTin;
    private javax.swing.JButton btnXemTTCN;
    private javax.swing.JButton hoadon;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton nhacungcap;
    private javax.swing.JButton nhaphang;
    private javax.swing.JButton phieunhap;
    private javax.swing.JButton sanpham;
    private javax.swing.JButton thhoadon;
    // End of variables declaration//GEN-END:variables
}
