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

public class Test extends JFrame {

    public Test() {
        super("JButton with Image and Text Example");
        // Tạo một ImageIcon từ một tập tin hình ảnh
        ImageIcon icon = new ImageIcon("Images/img/hit.png");

//        // Tạo một JButton và đặt hình ảnh và chữ cho nó
//        JButton button = new JButton("Click me", icon);
//        
//        // Đặt vị trí và kích thước của JButton
//        button.setBounds(50, 50, 200, 100);
//        
//        // Thêm JButton vào JFrame
//        add(button);
//        
//        // Đặt kích thước của JFrame và hiển thị nó
//        setSize(300, 200);
//        setLayout(null);
//        setVisible(true);
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo biểu tượng hình ảnh từ file ảnh
        // Tạo JButton và đặt biểu tượng hình ảnh
        JButton button = new JButton("Click Me", icon);

        // Đặt vị trí của biểu tượng và văn bản trên JButton
        button.setVerticalTextPosition(SwingConstants.LEFT);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);

        // Đặt font cho văn bản trên JButton
        button.setFont(new Font("Arial", Font.BOLD, 14));

        // Thêm JButton vào JFrame
        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}
