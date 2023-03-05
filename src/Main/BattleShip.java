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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
    private JPanel jpheader = new JPanel();
    public JPanel jscore = new JPanel();
    public JTextField scoreTextfield = new JTextField();
    public JLabel scorelabel = new JLabel();
    public JTextField MissTextfield = new JTextField();
    public JTextField HitTextfield = new JTextField();
    public JTextField MissTextfieldBot = new JTextField();
    public JTextField HitTextfieldBot = new JTextField();

    public BattleShip() {
        this.setSize(1200, 850);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                Component panel = null;
//                // TODO add your handling code here:
//                // Button Exit
//                if (ships.start == true) {
//                    int n = JOptionPane.showConfirmDialog(
//                            panel,
//                            "Trận chiến vẫn chưa kết thúc.\nNếu thoát toàn bộ thành tích trong trận đấu này sẽ mất.\nBạn có muốn thoát không?",
//                            "Thông báo",
//                            JOptionPane.YES_NO_OPTION);
//                    if (n == JOptionPane.YES_OPTION) {
//                        setVisible(false); //you can't see me!
//                        dispose();
//                        new Home().setVisible(true);
//                    }
//                } else {
//                    setVisible(false); //you can't see me!
//                    dispose();
//                    new Home().setVisible(true);
//                }
                Message ms = new Message();
                ms.setVisible(true);
                if (ships.start == true) {
                    ms.jtext.setText("<html>Trận chiến vẫn chưa kết thúc.<br>Nếu thoát toàn bộ thành tích trong trận đấu này sẽ mất.<br>Bạn có muốn thoát không?</html>");
//                    ms.jtext.setSize(400, 400);
                    ms.jtext.setFont(new java.awt.Font("Times New Roman", 1, 20));
                } else {
                    ms.jtext.setText("Bạn có muốn thoát không ?");
                }
                ms.jclose.addActionListener((ActionEvent a)
                        -> {
                    ms.setVisible(false);
                    ms.dispose();
                });
                ms.jconfirm.addActionListener((ActionEvent a)
                        -> {
                    new Home().setVisible(true);
                    ms.setVisible(false);
                    ms.dispose();
                    setVisible(false);
                    dispose();
                });
                ms.jcancel.addActionListener((ActionEvent a)
                        -> {
                    ms.setVisible(false);
                    ms.dispose();
                });
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

    public States getShips() {
        return ships;
    }

    public void setShips(States ships) {
        this.ships = ships;
    }

    public void inforpaleyer() {
        jpheader.setBounds(0, 0, 1200, 60);
        // custom bg color
//        Color colorCustom = new Color(233, 237, 201);
        Color colorCustom = new Color(137, 208, 250);
//        Color colorCustom = new Color(57, 144, 205);
        jpheader.setBackground(colorCustom);
        jpheader.setLayout(null);
        JButton player = new JButton();
        JLabel nameplayer = new JLabel("Xuân Diệu");
        nameplayer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        JButton bot = new JButton();
        JLabel namebot = new JLabel("Bot Pờ Rồ");
        namebot.setFont(new Font("Times New Roman", Font.PLAIN, 16));
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
//        Color colorCustom = new Color(233, 237, 201);
        Color colorCustom = new Color(137, 208, 250);
//        Color colorCustom = new Color(57, 144, 205);
        jscore.setBackground(colorCustom);
        jscore.setLayout(null);
        // custom bg color
        scorelabel.setText("Điểm số");
        scorelabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        scoreTextfield.setEditable(false);
        scorelabel.setBounds(390, 15, 80, 30);
        scoreTextfield.setBounds(450, 15, 80, 30);
        scoreTextfield.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        scoreTextfield.setText(String.valueOf(ships.scorePlayer));
        scorelabel.setVisible(false);
        scoreTextfield.setVisible(false);
        //
        JLabel lbhit = new JLabel("Trúng:");
        lbhit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbhit.setBounds(50, 10, 80, 30);
        HitTextfield.setEditable(false);
        HitTextfield.setBounds(100, 10, 80, 30);
        HitTextfield.setText(String.valueOf(ships.sumHitPlayer));
        HitTextfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        HitTextfield.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        //
        JLabel lbmiss = new JLabel("Trượt:");
        lbmiss.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbmiss.setBounds(350, 10, 80, 30);
        MissTextfield.setEditable(false);
        MissTextfield.setBounds(400, 10, 80, 30);
        MissTextfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        MissTextfield.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        MissTextfield.setText(String.valueOf(ships.sumMissPlayer));
        //
        jpheader.add(scorelabel);
        jpheader.add(scoreTextfield);
        //
        jscore.add(lbhit);
        jscore.add(HitTextfield);
        jscore.add(lbmiss);
        jscore.add(MissTextfield);
        //
        JLabel lbhitbot = new JLabel("Trúng:");
        lbhitbot.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbhitbot.setBounds(650, 10, 80, 30);
        HitTextfieldBot.setEditable(false);
        HitTextfieldBot.setBounds(700, 10, 80, 30);
        HitTextfieldBot.setText(String.valueOf(ships.sumHitBot));
        HitTextfieldBot.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        HitTextfieldBot.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//        System.out.println("Hit of bot" + ships.sumHitBot);
        //
        JLabel lbmissbot = new JLabel("Trượt:");
        lbmissbot.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbmissbot.setBounds(950, 10, 80, 30);
        MissTextfieldBot.setEditable(false);
        MissTextfieldBot.setBounds(1000, 10, 80, 30);
        MissTextfieldBot.setText(String.valueOf(ships.sumMissBot));
        MissTextfieldBot.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        MissTextfieldBot.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//        System.out.println("Miss of bot" + ships.sumMissBot);
        //
        jscore.add(lbhitbot);
        jscore.add(HitTextfieldBot);
        jscore.add(lbmissbot);
        jscore.add(MissTextfieldBot);
        jscore.setOpaque(true);
        //
        jscore.setVisible(false);
        this.getContentPane().add(jscore);
    }

    private void components() {
        jp.setBounds(0, 740, 1200, 100);
        // custom bg color
        Color colorCustom = new Color(137, 208, 250);
//        Color colorCustom = new Color(57, 144, 205);
        jp.setBackground(colorCustom);
        jp.setLayout(null);
        jp.setOpaque(true);
        JButton buttonPlay = new JButton();
        buttonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnStart.png")));
        buttonPlay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonPlay.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPlay.setBounds(700, 0, 140, 50);
        buttonPlay.setOpaque(false);
        buttonPlay.setContentAreaFilled(false);
        buttonPlay.setBorderPainted(false);
//        Color colorCustom2 = new Color(70, 156, 159);
//        buttonPlay.setBackground(colorCustom2);
        buttonPlay.addActionListener((ActionEvent e)
                -> {
            if (ships.battleship.isBoard() && ships.cruise.isBoard() && ships.destroyer1.isBoard() && ships.destroyer2.isBoard() && ships.submarine.isBoard()) {
                mo.canMove = false;
                ships.start = true;
                jp.setVisible(false);
                jscore.setVisible(true);
                scorelabel.setVisible(true);
                scoreTextfield.setVisible(true);
                JOptionPane.showMessageDialog(null, "Mời bạn chơi trước");
                //
                if (ships.levelMax == 2 || ships.levelMax == 3) {
                    ships.enemy.updateMarkPosShip();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng đặt tất cả tàu chiến lên sàn đấu");
//                jp.setVisible(true);
//                jscore.setVisible(false);
            }
        });
        JButton buttonreset = new JButton();
        buttonreset.setOpaque(false);
        buttonreset.setContentAreaFilled(false);
        buttonreset.setBorderPainted(false);
        buttonreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnReset.png")));
//        buttonreset.setBackground(colorCustom2);
        buttonreset.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonreset.setBounds(950, 0, 140, 50);
        buttonreset.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonreset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonreset.addActionListener((ActionEvent e)
                -> {
            if (mo.canMove) {
                ships.resetShips();
                jscore.setVisible(false);
                jp.setVisible(true);

            }
        });
        //
        JButton buttonStop = new JButton();
        buttonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnPause.png")));
        buttonStop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonStop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonStop.setBounds(200, 0, 50, 50);
        buttonStop.setOpaque(false);
        buttonStop.setContentAreaFilled(false);
        buttonStop.setBorderPainted(false);
        buttonStop.addActionListener((ActionEvent e)
                -> {
            Pause ps = new Pause();
            ps.setVisible(true);
            ps.setShips(ships);
            if (ps.getShips().music == true) {
                ps.buttonSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnSound.png")));
            } else {
                ps.buttonSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnMutext.png")));
            }
            ps.buttonReplay.addActionListener((ActionEvent a)
                    -> {
                if (ships.start == true) {
                    Message ms = new Message();
                    ms.jtext.setText("<html>Trận chiến vẫn chưa kết thúc.<br>Nếu thoát toàn bộ thành tích trong trận đấu này sẽ mất.<br>Bạn có muốn thoát không?</html>");
                    ms.setVisible(true);
                    ms.jtext.setFont(new java.awt.Font("Times New Roman", 1, 20));
                    //
                    ms.jclose.addActionListener((ActionEvent ac)
                            -> {
                        ms.setVisible(false);
                        ms.dispose();
                    });
                    ms.jconfirm.addActionListener((ActionEvent ac)
                            -> {

                    });
                    ms.jcancel.addActionListener((ActionEvent ac)
                            -> {
                        ms.setVisible(false);
                        ms.dispose();
                    });
                } else {
//                    ms.jtext.setText("Bạn có muốn thoát không ?");
                    ps.setVisible(false);
                    ps.dispose();
                    this.setVisible(false);
                    dispose();
                    Level lv = new Level();
                    lv.setVisible(true);
                    lv.setShips(ships);
                }
            });
            //
            ps.buttonHome.addActionListener((ActionEvent a)
                    -> {
                if (ships.start == true) {
                    Message ms = new Message();
                    ms.jtext.setText("<html>Trận chiến vẫn chưa kết thúc.<br>Toàn bộ thành tích trong trận đấu này sẽ mất.<br>Bạn có quay về màn hình chính?</html>");
                    ms.setVisible(true);
                    ms.jtext.setFont(new java.awt.Font("Times New Roman", 1, 20));
                    //
                    ms.jclose.addActionListener((ActionEvent ac)
                            -> {
                        ms.setVisible(false);
                        ms.dispose();
                    });
                    ms.jconfirm.addActionListener((ActionEvent ac)
                            -> {
                        ms.setVisible(false);
                        ms.dispose();
                        ps.setVisible(false);
                        ps.dispose();
                        this.setVisible(false);
                        dispose();
                        Home home = new Home();
                        home.setVisible(true);
                        home.setShips(ps.getShips());
                    });
                    ms.jcancel.addActionListener((ActionEvent ac)
                            -> {
                        ms.setVisible(false);
                        ms.dispose();
                    });
                } else {
//                    ms.jtext.setText("Bạn có muốn thoát không ?");
                    ps.setVisible(false);
                    ps.dispose();
                    this.setVisible(false);
                    dispose();
                    Home home = new Home();
                    home.setVisible(true);
                    home.setShips(ps.getShips());
                }
            });
            //
            ps.buttonSound.addActionListener((ActionEvent a)
                    -> {
                if (ps.getShips().music == true) {
                    ships.mp3.stop();
                    ps.getShips().music = false;
                    ships.music = ps.getShips().music;
                    ps.buttonSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnMutext.png")));
                } else {
                    ships.mp3.play();
                    ps.getShips().music = true;
                    ships.music = ps.getShips().music;
                    ps.buttonSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnSound.png")));
                }
            });
        });

        jp.add(buttonPlay);

        jp.add(buttonreset);

        jp.add(buttonStop);

        this.getContentPane()
                .add(jp);
    }

//    public static void main(String[] args)
//    {
//        new BattleShip().start();
//    }
    private void update() {
        ships.update();
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
//        Color colorCustom = new Color(233, 237, 201);
        Color colorCustom = new Color(137, 208, 250);
//        Color colorCustom = new Color(57, 144, 205);
        g.setColor(colorCustom);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        ships.draw(g);
        g.dispose();
        bs.show();
        if (ships.endgame == true) {
            setVisible(false); //you can't see me!
            dispose();
        }
        scoreTextfield.setText(String.valueOf(ships.scorePlayer));
        HitTextfield.setText(String.valueOf(ships.sumHitPlayer));
        MissTextfield.setText(String.valueOf(ships.sumMissPlayer));
        HitTextfieldBot.setText(String.valueOf(ships.sumHitBot));
        MissTextfieldBot.setText(String.valueOf(ships.sumMissBot));
    }

    @Override
    public void run() {
        int count = 0, count1 = 0, count2 = 0;
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / targettime;
            time += (now - lastTime);
            lastTime = now;
            count++;
            if (delta >= 1) {
                draw();
                update();
                delta--;
                frames++;
                count1++;
            }
            if (time >= 1000000000) {
                averageFPS = frames;
                frames = 0;
                time = 0;
                count2++;
            }
        }
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
