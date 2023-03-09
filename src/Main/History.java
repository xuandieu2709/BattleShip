/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Model.Score;
import Model.States;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class History extends javax.swing.JFrame {

    private States ships = new States();

    public States getShips() {
        return ships;
    }

    public void setShips(States ships) {
        this.ships = ships;
    }

    /**
     * Creates new form History
     */
    public History() {
        init();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                Home home = new Home(ships.music);
                home.getShips().music = ships.music;
                home.getShips().mp3 = ships.mp3;
                home.setVisible(true);
                home.setVisible(true);
            }
        ;
        });
        Model.Score s = new Model.Score();
        // Tạo DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel();
        List<Model.Score> scores = s.ReadFile();
//        tableModel.addColumn("Người chơi");

        tableModel.addColumn(
                "Thời gian");
        tableModel.addColumn(
                "Điểm số");
        tableModel.addColumn(
                "Đánh trúng");
        tableModel.addColumn(
                "Đánh trượt");
        tableModel.addColumn(
                "Mức độ");
        tableModel.addColumn(
                "Kết quả");
        // score.getName(), 
        for (Score score : scores) {
            Object[] row = {score.getTimeplay(), score.getScore(),
                score.getSumHit(), score.getSumMiss(), ((score.getLevel() == 3) ? "Khó" : (score.getLevel() == 2) ? "Vừa" : "Dễ"), (score.isResult() == true ? "Thắng" : "Thua")};
            tableModel.addRow(row);
        }
        // Thiết lập DefaultTableModel cho JTable

        jTable1.setModel(tableModel);
    }

    private void init() {
        jPanel1 = new javax.swing.JPanel();
        jBUTTONRESET = new javax.swing.JButton();
        jBUTTONBACK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER)) {
            private final Image backgroundImage = new ImageIcon("src\\Icon\\THANHTICH.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(70, 156, 159));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(70, 156, 159));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setForeground(new java.awt.Color(70, 156, 159));

        jBUTTONRESET.setBackground(new java.awt.Color(38, 70, 83));
        jBUTTONRESET.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jBUTTONRESET.setForeground(new java.awt.Color(255, 255, 255));
        jBUTTONRESET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/buttonRESETCORE.png"))); // NOI18N
        jBUTTONRESET.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBUTTONRESET.setMaximumSize(new java.awt.Dimension(150, 70));
        jBUTTONRESET.setMinimumSize(new java.awt.Dimension(150, 70));
        jBUTTONRESET.setPreferredSize(new java.awt.Dimension(150, 70));
        jBUTTONRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUTTONRESETActionPerformed(evt);
            }
        });

        jBUTTONBACK.setBackground(new java.awt.Color(38, 70, 83));
        jBUTTONBACK.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jBUTTONBACK.setForeground(new java.awt.Color(255, 255, 255));
        jBUTTONBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/buttonEXIT.png"))); // NOI18N
        jBUTTONBACK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBUTTONBACK.setMaximumSize(new java.awt.Dimension(150, 70));
        jBUTTONBACK.setMinimumSize(new java.awt.Dimension(150, 70));
        jBUTTONBACK.setPreferredSize(new java.awt.Dimension(150, 70));
        jBUTTONBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUTTONBACKActionPerformed(evt);
            }
        });

//        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
//        jTable1.setForeground(new java.awt.Color(0, 102, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 15));
        jTable1.getTableHeader().setBackground(new Color(208, 114, 35));
        jTable1.getTableHeader().setForeground(new Color(38, 70, 83));
//        jTable1.setSelectionBackground(new java.awt.Color());
        jTable1.setSelectionForeground(new java.awt.Color(208, 114, 35));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.setShowGrid(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.setOpaque(false);
        ((DefaultTableCellRenderer) jTable1.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jBUTTONBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBUTTONRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(126, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jBUTTONBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBUTTONRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBUTTONRESET = new javax.swing.JButton();
        jBUTTONBACK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(70, 156, 159));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(70, 156, 159));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setForeground(new java.awt.Color(70, 156, 159));

        jBUTTONRESET.setBackground(new java.awt.Color(38, 70, 83));
        jBUTTONRESET.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jBUTTONRESET.setForeground(new java.awt.Color(255, 255, 255));
        jBUTTONRESET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/buttonRESETCORE.png"))); // NOI18N
        jBUTTONRESET.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBUTTONRESET.setMaximumSize(new java.awt.Dimension(150, 70));
        jBUTTONRESET.setMinimumSize(new java.awt.Dimension(150, 70));
        jBUTTONRESET.setPreferredSize(new java.awt.Dimension(150, 70));
        jBUTTONRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUTTONRESETActionPerformed(evt);
            }
        });

        jBUTTONBACK.setBackground(new java.awt.Color(38, 70, 83));
        jBUTTONBACK.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jBUTTONBACK.setForeground(new java.awt.Color(255, 255, 255));
        jBUTTONBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/buttonEXIT.png"))); // NOI18N
        jBUTTONBACK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBUTTONBACK.setMaximumSize(new java.awt.Dimension(150, 70));
        jBUTTONBACK.setMinimumSize(new java.awt.Dimension(150, 70));
        jBUTTONBACK.setPreferredSize(new java.awt.Dimension(150, 70));
        jBUTTONBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUTTONBACKActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 102, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(196, 209, 82));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jBUTTONBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBUTTONRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBUTTONBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBUTTONRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBUTTONBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUTTONBACKActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
        Home home = new Home(ships.music);
        home.getShips().music = ships.music;
        home.getShips().mp3 = ships.mp3;
        home.setVisible(true);
    }//GEN-LAST:event_jBUTTONBACKActionPerformed

    private void jBUTTONRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUTTONRESETActionPerformed
        // TODO add your handling code here:
        Message ms = new Message(this, true);
        ms.jtext.setText("<html><h2 style='text-align: center;'>Toàn bộ điểm số sẽ bị xóa.<br>Bạn có muốn không ?</h2></html>");
        ms.jclose.addActionListener((ActionEvent a)
                -> {
            ms.setVisible(false);
            ms.dispose();
        });
        ms.jconfirm.addActionListener((ActionEvent a)
                -> {
            Model.Score s = new Model.Score();
            List<Model.Score> list = new ArrayList<>();
            s.WriteFile(list);
            // Tạo DefaultTableModel
            DefaultTableModel tableModel = new DefaultTableModel();
            List<Model.Score> scores = s.ReadFile();
            tableModel.addColumn("Người chơi");
            tableModel.addColumn("Thời gian");
            tableModel.addColumn("Điểm số");
            tableModel.addColumn("Đánh trúng");
            tableModel.addColumn("Đánh trượt");
            tableModel.addColumn("Mức độ");
            tableModel.addColumn("Kết quả");
            for (Score score : scores) {
                Object[] row = {score.getName(), score.getTimeplay(), score.getScore(),
                    score.getSumHit(), score.getSumMiss(), ((score.getLevel() == 3) ? "Khó" : (score.getLevel() == 2) ? "Vừa" : "Dễ"), (score.isResult() == true ? "Thắng" : "Thua")};
                tableModel.addRow(row);
            }
            ms.setVisible(false);
            ms.dispose();
// Thiết lập DefaultTableModel cho JTable
            jTable1.setModel(tableModel);
        });
        ms.jcancel.addActionListener((ActionEvent a)
                -> {
            ms.setVisible(false);
            ms.dispose();
        });
        ms.setVisible(true);
    }//GEN-LAST:event_jBUTTONRESETActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new History().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBUTTONBACK;
    private javax.swing.JButton jBUTTONRESET;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
