/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package battleship;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    
    public MyFrame() {
        // Set the title of the JFrame
        setTitle("My Frame");
        
        // Set the size of the JFrame
        setSize(550, 600);
        Color  colorCustom   = new Color(233, 237, 201);
        // Create a JPanel to act as the content pane
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("Images/bg.png"); // Replace with your image file path
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBackground(colorCustom);
        // Set the content pane to the JPanel with the image background
        setContentPane(contentPane);
        
        // Set the JFrame to be visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyFrame();
    }
}