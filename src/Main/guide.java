/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Model.States;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Dell
 */
public class Guide extends javax.swing.JFrame {

    /**
     * Creates new form guide
     */
    private States ships = new States();

    public States getShips() {
        return ships;
    }

    public void setShips(States ships) {
        this.ships = ships;
    }

    public Guide() {
//        initCompo();
initComponents();
        ImageIcon img = new ImageIcon("src\\Icon\\logo.png");
        this.setIconImage(img.getImage());
        setTitle("Hướng dẫn chơi");
        jPanel1.setOpaque(true);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JLabel background = new JLabel(new ImageIcon("src\\Icon\\GUIDE.png"));
        jPanel1.add(background, BorderLayout.CENTER);
        // Thiết lập panel cho JFrame
        setContentPane(jPanel1);
        // Các thiết lập khác cho JFrame
//        setSize(550, 600);
//        background.setBounds(0, 0, 550, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
            }
        });
    }

    public void initCompo() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(550, 600));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(550, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(550, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 600));
        jPanel1.setOpaque(false);

        jTextPane1.setEditable(false);
//        jTextPane1.setBackground(new java.awt.Color(0, 0, 255));
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTextPane1.setText("  Trong game Tàu chiến, bạn sẽ đặt vị trí tàu trên sàn đấu 10x10 ô như hình. Xoay con lăn chuột để xoay tàu ngang hoặc dọc.\n  Đến lượt bạn tấn công thì bạn sẽ bắn tàu chiến bên sân đối phương và ngược lại, nếu bắn trúng sẽ có biểu tượng cháy tàu, còn trượt thì sẽ hiện nút nhắm mục tiêu trật.\n  Ghi nhớ là phá hủy đủ 5 tàu chiến trước thì sẽ thắng! Bạn cần nhanh tay để đoán được vị trí của đối thủ nhé.");
        jTextPane1.setAlignmentX(1.0F);
        jTextPane1.setAlignmentY(1.0F);
        jTextPane1.setCaretColor(new java.awt.Color(255, 193, 37));
        jTextPane1.setDisabledTextColor(new java.awt.Color(238, 118, 0));
        jTextPane1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jTextPane1.setOpaque(false);
        jTextPane1.setSelectionColor(new java.awt.Color(238, 118, 0));
        jScrollPane1.setViewportView(jTextPane1);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(53, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(119, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(550, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(550, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(550, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 600));

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTextPane1.setText("  Trong game Tàu chiến, bạn sẽ đặt vị trí tàu trên bản đồ 10x10 ô như hình. Xoay con lăn chuột để xoay tàu ngang hoặc dọc.\n  Đến lượt bạn tấn công thì bạn sẽ bắn tàu chiến bên sân đối phương và ngược lại, nếu bắn trúng sẽ có biểu tượng cháy tàu, còn trượt thì sẽ hiện nút nhắm mục tiêu trật.\n  Ghi nhớ là phá hủy đủ 5 tàu chiến trước thì sẽ thắng! Bạn cần nhanh tay để đoán được vị trí của đối thủ nhé.");
        jTextPane1.setAlignmentX(1.0F);
        jTextPane1.setAlignmentY(1.0F);
        jTextPane1.setCaretColor(new java.awt.Color(255, 193, 37));
        jTextPane1.setDisabledTextColor(new java.awt.Color(238, 118, 0));
        jTextPane1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jTextPane1.setSelectionColor(new java.awt.Color(238, 118, 0));
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Guide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
