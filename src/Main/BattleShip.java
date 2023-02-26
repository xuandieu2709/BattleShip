/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/BattleShip.java to edit this template
 */
package Main;

/**
 *
 * @author Dell
 */
import Input.Mouse;
import Input.MouseDragged;
import Input.MouseWheel;
import Model.States;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BattleShip extends JFrame implements Runnable {

    public static final int WIDTH = 1200, HEIGHT = 800;
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private final int FPS = 30;
    private double targettime = 1000000000 / FPS;
    private double delta = 0;
    private int averageFPS = FPS;

    private JPanel jp = new JPanel();
    private States ships = new States();
    private MouseDragged mo = new MouseDragged(ships);
    private Mouse mou = new Mouse(ships);

    private MouseWheel mw = new MouseWheel();
    //
    private Home home;
    private JPanel jpheader = new JPanel();
    public JPanel jscore = new JPanel();
    public JTextField scoreTextfield = new JTextField();
    public JTextField MissTextfield = new JTextField();
    public JTextField HitTextfield = new JTextField();

    public BattleShip() {
        this.setSize(1200, 850);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Component panel = null;
                // TODO add your handling code here:
                // Button Exit
                if (ships.start == true) {
                    int n = JOptionPane.showConfirmDialog(
                            panel,
                            "Trận chiến vẫn chưa kết thúc.\nNếu thoát toàn bộ thành tích trong trận đấu này sẽ mất.\nBạn có muốn thoát không?",
                            "Thông báo",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        setVisible(false); //you can't see me!
                        dispose();
                        new Home().setVisible(true);
                    }
                } else {
                    setVisible(false); //you can't see me!
                    dispose();
                    new Home().setVisible(true);
                }
            }
        });
        this.setTitle("Tàu chiến");
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);
        canvas.addMouseMotionListener(mo);
        canvas.addMouseListener(mou);
        canvas.addMouseWheelListener(mw);
        inforpaleyer();
        components();
        scorePlayer();
        this.add(canvas);
    }

    private void inforpaleyer() {
        jpheader.setBounds(0, 0, 1200, 60);
        // custom bg color
        Color colorCustom = new Color(233, 237, 201);
        jpheader.setBackground(colorCustom);
        jpheader.setLayout(null);
        JButton player = new JButton();
        JLabel nameplayer = new JLabel("Xuân Diệu");
        JButton bot = new JButton();
        JLabel namebot = new JLabel("Bot Pờ Rồ");
        player.setBounds(25, 5, 50, 50);
        //
        ImageIcon icon = new ImageIcon("Images/img/You.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(player.getWidth(), player.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        player.setIcon(icon);
        //
        nameplayer.setBounds(80, 5, 100, 50);
        bot.setBounds(610, 5, 50, 50);
        //
        ImageIcon icon1 = new ImageIcon("Images/img/Bot.png");
        Image img1 = icon1.getImage();
        Image newimg1 = img1.getScaledInstance(bot.getWidth(), bot.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(newimg1);
        bot.setIcon(icon1);
        //
        namebot.setBounds(665, 5, 100, 50);
        jpheader.add(player);
        jpheader.add(bot);
        jpheader.add(namebot);
        jpheader.add(nameplayer);
        this.getContentPane().add(jpheader);
    }

    private void scorePlayer() {
        jscore.setBounds(0, 650, 1200, 100);
        Color colorCustom = new Color(233, 237, 201);
        jscore.setBackground(colorCustom);
        jscore.setLayout(null);
        // custom bg color
        JLabel scorelabel = new JLabel("Điểm số:");
        scoreTextfield.setEditable(false);
        scorelabel.setBounds(50, 10, 120, 30);
        scoreTextfield.setBounds(250, 10, 120, 30);
        scoreTextfield.setText(String.valueOf(ships.scorePlayer));
        //
        JLabel lbhit = new JLabel("Trúng:");
        lbhit.setBounds(600, 10, 120, 30);
        HitTextfield.setEditable(false);
        HitTextfield.setBounds(650, 10, 120, 30);
        HitTextfield.setText(String.valueOf(ships.sumHitPlayer));
        //
        JLabel lbmiss = new JLabel("Trượt:");
        lbmiss.setBounds(900, 10, 120, 30);
        MissTextfield.setEditable(false);
        MissTextfield.setBounds(950, 10, 120, 30);
        MissTextfield.setText(String.valueOf(ships.sumMissPlayer));
        //
        jscore.add(scorelabel);
        jscore.add(scoreTextfield);
        jscore.add(lbhit);
        jscore.add(HitTextfield);
        jscore.add(lbmiss);
        jscore.add(MissTextfield);
        jscore.setVisible(false);
        this.getContentPane().add(jscore);
    }

    private void components() {
        jp.setBounds(0, 740, 1200, 100);
        // custom bg color
        Color colorCustom = new Color(233, 237, 201);
        jp.setBackground(colorCustom);
        jp.setLayout(null);
        JButton buttonPlay = new JButton("Bắt đầu");
        buttonPlay.setBounds(50, 5, 120, 40);
        buttonPlay.addActionListener((ActionEvent e)
                -> {
            if (ships.battleship.isBoard() && ships.cruise.isBoard() && ships.destroyer1.isBoard() && ships.destroyer2.isBoard() && ships.submarine.isBoard()) {
                mo.canMove = false;
                ships.start = true;
                JOptionPane.showMessageDialog(null, "Mời bạn chơi trước");
                jp.setVisible(false);
                jscore.setVisible(true);

//                jp.revalidate();// Xóa
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng đặt tất cả tàu chiến lên sàn đấu");
            }
        });
        jp.add(buttonPlay);
        JButton buttonreset = new JButton("Sắp xếp lại");
        buttonreset.setBounds(250, 5, 120, 40);
        buttonreset.addActionListener((ActionEvent e)
                -> {
            if (mo.canMove) {
                ships.resetShips();
            }
        });
        jp.add(buttonreset);
        this.getContentPane().add(jp);
    }

//    public static void main(String[] args)
//    {
//        new BattleShip().start();
//    }
    private void update() {
        ships.update();
        if (ships.endgame == true) {
            setVisible(false); //you can't see me!
            dispose();
        }
        scoreTextfield.setText(String.valueOf(ships.scorePlayer));
        HitTextfield.setText(String.valueOf(ships.sumHitPlayer));
        MissTextfield.setText(String.valueOf(ships.sumMissPlayer));

//        System.out.println("Sum Hit:"+ships.sumHitPlayer);
//        System.out.println("Sum Miss:"+ships.sumMissPlayer);
    }
    private void draw() {
        bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        //Empieza dibujo
        Color colorCustom = new Color(233, 237, 201);
//        jp.setBackground(colorCustom);
        g.setColor(colorCustom);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        ships.draw(g);
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / targettime;
            time += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                update();
                draw();
                delta--;
                frames++;
            }
            if (time >= 1000000000) {
                averageFPS = frames;
                frames = 0;
                time = 0;
            }
        }
        this.stop();
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
