/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Model.States;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Dell
 */
public class Score extends javax.swing.JDialog {

    public Home home;
    public States ships = new States();
    public int level;

    /**
     * Creates new form Result
     */
    public Score() {
        init();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false); //you can't see me!
                dispose();
                new Home().setVisible(true);
            }
        });
    }
    public Score(JFrame owner, boolean modal) {
        super(owner, modal);
        init();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void init() {
        jPanel1 = new javax.swing.JPanel();
        jbtnBACK = new javax.swing.JButton();
        jbtnREPLAY = new javax.swing.JButton();
        jtitle = new javax.swing.JLabel("", SwingConstants.CENTER);
        jTextField1 = new javax.swing.JTextField();
        jbtext = new javax.swing.JLabel("", SwingConstants.CENTER);
        // jpanel
        jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER)) {
            private final Image backgroundImage = new ImageIcon("src\\Icon\\Score.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(70, 156, 159));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(70, 156, 159));
        jPanel1.setAutoscrolls(true);
        jPanel1.setOpaque(false);

        jbtnBACK.setBackground(new java.awt.Color(38, 70, 83));
        jbtnBACK.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jbtnBACK.setForeground(new java.awt.Color(255, 255, 255));
        jbtnBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/buttonEXIT.png"))); // NOI18N
        jbtnBACK.setMaximumSize(new java.awt.Dimension(150, 70));
        jbtnBACK.setMinimumSize(new java.awt.Dimension(150, 70));
        jbtnBACK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBACKActionPerformed(evt);
            }
        });

        jbtnREPLAY.setBackground(new java.awt.Color(38, 70, 83));
        jbtnREPLAY.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jbtnREPLAY.setForeground(new java.awt.Color(255, 255, 255));
        jbtnREPLAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/buttonREPLAY.png"))); // NOI18N
        jbtnREPLAY.setMaximumSize(new java.awt.Dimension(150, 70));
        jbtnREPLAY.setMinimumSize(new java.awt.Dimension(150, 70));
        jbtnREPLAY.setPreferredSize(new java.awt.Dimension(150, 70));
        jbtnREPLAY.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnREPLAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnREPLAYActionPerformed(evt);
            }
        });

        jtitle.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jtitle.setForeground(new java.awt.Color(255, 255, 255));
        jtitle.setText("Thắng");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(38, 70, 83));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 70));
        jTextField1.setRequestFocusEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jbtext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jbtext.setForeground(new java.awt.Color(38,70,83));
        jbtext.setText("jbtext");
        jbtext.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbtnBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnREPLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jbtext, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnREPLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
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
        jbtnBACK = new javax.swing.JButton();
        jbtnREPLAY = new javax.swing.JButton();
        jtitle = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jbtext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(70, 156, 159));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(70, 156, 159));
        jPanel1.setAutoscrolls(true);
        jPanel1.setOpaque(false);

        jbtnBACK.setBackground(new java.awt.Color(38, 70, 83));
        jbtnBACK.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jbtnBACK.setForeground(new java.awt.Color(255, 255, 255));
        jbtnBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/buttonEXIT.png"))); // NOI18N
        jbtnBACK.setMaximumSize(new java.awt.Dimension(150, 70));
        jbtnBACK.setMinimumSize(new java.awt.Dimension(150, 70));
        jbtnBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBACKActionPerformed(evt);
            }
        });

        jbtnREPLAY.setBackground(new java.awt.Color(38, 70, 83));
        jbtnREPLAY.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jbtnREPLAY.setForeground(new java.awt.Color(255, 255, 255));
        jbtnREPLAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/buttonREPLAY.png"))); // NOI18N
        jbtnREPLAY.setMaximumSize(new java.awt.Dimension(150, 70));
        jbtnREPLAY.setMinimumSize(new java.awt.Dimension(150, 70));
        jbtnREPLAY.setPreferredSize(new java.awt.Dimension(150, 70));
        jbtnREPLAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnREPLAYActionPerformed(evt);
            }
        });

        jtitle.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jtitle.setForeground(new java.awt.Color(255, 255, 255));
        jtitle.setText("Thắng");

        jTextField1.setBackground(new java.awt.Color(38, 70, 83));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 70));
        jTextField1.setRequestFocusEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jbtext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jbtext.setForeground(new java.awt.Color(38, 70, 83));
        jbtext.setText("jbtext");
        jbtext.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbtnBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnREPLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jbtext, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnREPLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jbtnREPLAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnREPLAYActionPerformed
        // TODO add your handling code here:
//        setVisible(false); //you can't see me!
//        dispose();
//        Level lv = new Level();
//        lv.getShips().music = ships.music;
//        lv.getShips().mp3 = ships.mp3;
//        lv.setVisible(true);

    }//GEN-LAST:event_jbtnREPLAYActionPerformed

    private void jbtnBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBACKActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbtnBACKActionPerformed

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
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Score().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JLabel jbtext;
    public javax.swing.JButton jbtnBACK;
    public javax.swing.JButton jbtnREPLAY;
    public javax.swing.JLabel jtitle;
    // End of variables declaration//GEN-END:variables
}
