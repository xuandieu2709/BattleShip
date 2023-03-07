/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {

    public Test() {
        JFrame mainFrame = new JFrame("Cửa sổ chính");
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Mở cửa sổ con");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(mainFrame, "Cửa sổ con", true);
                dialog.setSize(200, 200);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setUndecorated(true);
                dialog.setVisible(true);
            }
        });

        mainFrame.add(button);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}
