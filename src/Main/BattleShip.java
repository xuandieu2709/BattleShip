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
    public JLabel namebot = new JLabel();

    public BattleShip() {
        this.setSize(1200, 850);
        ImageIcon img = new ImageIcon("src\\source\\logo.png");
        this.setIconImage(img.getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Message ms = new Message((JFrame) e.getWindow(), true);
                if (ships.start == true) {
                    ms.jtext.setText("<html><h2 style='text-align: center;'>Trận chiến vẫn chưa kết thúc."
                            + "<br>Nếu thoát toàn bộ thành tích trong trận đấu này sẽ mất."
                            + "<br>Bạn có muốn thoát không?</h2></html>");
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
                    ms.setVisible(false);
                    ms.dispose();
                    setVisible(false);
                    dispose();
                    Home home = new Home(ships.music);
                    home.getShips().mp3 = ships.mp3;
                    home.setVisible(true);

                    System.out.println("Home MUSIC" + home.getShips().music + "\t" + "BT mussic" + ships.music);
                });
                ms.jcancel.addActionListener((ActionEvent a)
                        -> {
                    ms.setVisible(false);
                    ms.dispose();
                });
                ms.setVisible(true);
            }
        });
        ImageIcon imgg = new ImageIcon("src\\Icon\\logo.png");
        this.setIconImage(imgg.getImage());
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
        JLabel nameplayer = new JLabel("Bạn");
        nameplayer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        JButton bot = new JButton();
        namebot.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        player.setBounds(25, 5, 50, 50);
        //
        ImageIcon icon = new ImageIcon("Images/img/Youu.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(player.getWidth(), player.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        player.setIcon(icon);
        player.setOpaque(false);
        player.setContentAreaFilled(false);
        player.setBorderPainted(false);
        //
        nameplayer.setBounds(80, 5, 100, 50);
        bot.setBounds(610, 5, 50, 50);
        //
        ImageIcon icon1 = new ImageIcon("Images/img/Bott.png");
        Image img1 = icon1.getImage();
        Image newimg1 = img1.getScaledInstance(bot.getWidth(), bot.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(newimg1);
        bot.setIcon(icon1);
        bot.setOpaque(false);
        bot.setContentAreaFilled(false);
        bot.setBorderPainted(false);
        //
        namebot.setBounds(665, 5, 100, 50);
        jpheader.add(player);
        jpheader.add(bot);
        jpheader.add(namebot);
        jpheader.add(nameplayer);
        this.getContentPane().add(jpheader);
    }

    private void scorePlayer() {
        jscore.setBounds(0, 650, 1200, 200);
//        Color colorCustom = new Color(233, 237, 201);
        Color colorCustom = new Color(137, 208, 250);
//        Color colorCustom = new Color(57, 144, 205);
        jscore.setBackground(colorCustom);
        jscore.setLayout(null);
        // custom bg color
        scorelabel.setText("Điểm số");
        scorelabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        scoreTextfield.setEditable(false);
        scorelabel.setBounds(400, 15, 80, 30);
        scoreTextfield.setBounds(480, 15, 100, 30);
        scoreTextfield.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        scoreTextfield.setText(String.valueOf(ships.scorePlayer));
        scorelabel.setVisible(false);
        scoreTextfield.setVisible(false);
        //
        scoreTextfield.setEditable(false);
        scoreTextfield.setBackground(new java.awt.Color(38, 70, 83));
        scoreTextfield.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        scoreTextfield.setForeground(new java.awt.Color(255, 255, 255));
        scoreTextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        scoreTextfield.setText("0");
        scoreTextfield.setToolTipText("");
        scoreTextfield.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scoreTextfield.setPreferredSize(new java.awt.Dimension(150, 70));
        scoreTextfield.setRequestFocusEnabled(false);
        //
        JLabel lbhit = new JLabel("Trúng:");
        lbhit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lbhit.setBounds(50, 10, 80, 30);
        HitTextfield.setEditable(false);
        HitTextfield.setBounds(130, 10, 80, 30);
        HitTextfield.setText(String.valueOf(ships.sumHitPlayer));
//        HitTextfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        HitTextfield.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        //
        HitTextfield.setEditable(false);
        HitTextfield.setBackground(new java.awt.Color(38, 70, 83));
        HitTextfield.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        HitTextfield.setForeground(new java.awt.Color(255, 255, 255));
        HitTextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        HitTextfield.setText("0");
        HitTextfield.setToolTipText("");
        HitTextfield.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        HitTextfield.setPreferredSize(new java.awt.Dimension(150, 70));
        HitTextfield.setRequestFocusEnabled(false);
        //
        JLabel lbmiss = new JLabel("Trượt:");
        lbmiss.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lbmiss.setBounds(350, 10, 80, 30);
        MissTextfield.setEditable(false);
        MissTextfield.setBounds(430, 10, 80, 30);
//        MissTextfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        MissTextfield.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        MissTextfield.setText(String.valueOf(ships.sumMissPlayer));
        //
        MissTextfield.setEditable(false);
        MissTextfield.setBackground(new java.awt.Color(38, 70, 83));
        MissTextfield.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        MissTextfield.setForeground(new java.awt.Color(255, 255, 255));
        MissTextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MissTextfield.setText("0");
        MissTextfield.setToolTipText("");
        MissTextfield.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MissTextfield.setPreferredSize(new java.awt.Dimension(150, 70));
        MissTextfield.setRequestFocusEnabled(false);
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
        lbhitbot.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lbhitbot.setBounds(650, 10, 80, 30);
        HitTextfieldBot.setEditable(false);
        HitTextfieldBot.setBounds(730, 10, 80, 30);
        HitTextfieldBot.setText(String.valueOf(ships.sumHitBot));
//        HitTextfieldBot.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        HitTextfieldBot.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//        System.out.println("Hit of bot" + ships.sumHitBot);
        //
        HitTextfieldBot.setEditable(false);
        HitTextfieldBot.setBackground(new java.awt.Color(38, 70, 83));
        HitTextfieldBot.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        HitTextfieldBot.setForeground(new java.awt.Color(255, 255, 255));
        HitTextfieldBot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        HitTextfieldBot.setText("0");
        HitTextfieldBot.setToolTipText("");
        HitTextfieldBot.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        HitTextfieldBot.setPreferredSize(new java.awt.Dimension(150, 70));
        HitTextfieldBot.setRequestFocusEnabled(false);
        //
        JLabel lbmissbot = new JLabel("Trượt:");
        lbmissbot.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lbmissbot.setBounds(950, 10, 80, 30);
        MissTextfieldBot.setEditable(false);
        MissTextfieldBot.setBounds(1030, 10, 80, 30);
        MissTextfieldBot.setText(String.valueOf(ships.sumMissBot));
//        MissTextfieldBot.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        MissTextfieldBot.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        //
        MissTextfieldBot.setEditable(false);
        MissTextfieldBot.setBackground(new java.awt.Color(38, 70, 83));
        MissTextfieldBot.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        MissTextfieldBot.setForeground(new java.awt.Color(255, 255, 255));
        MissTextfieldBot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MissTextfieldBot.setText("0");
        MissTextfieldBot.setToolTipText("");
        MissTextfieldBot.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MissTextfieldBot.setPreferredSize(new java.awt.Dimension(150, 70));
        MissTextfieldBot.setRequestFocusEnabled(false);
//        System.out.println("Miss of bot" + ships.sumMissBot);
        //
        JButton buttonStop = new JButton();
        buttonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnContu.png")));
        buttonStop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonStop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonStop.setBounds(570, 70, 50, 50);
        buttonStop.setOpaque(false);
        buttonStop.setContentAreaFilled(false);
        buttonStop.setBorderPainted(false);
        buttonStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonStop.addActionListener((ActionEvent e)
                -> {
            Pause ps = new Pause(this, true);
            ps.getShips().music = ships.music;
            ps.getShips().mp3 = ships.mp3;
            if (ps.getShips().music == true) {
                ps.buttonSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnSound.png")));
            } else {
                ps.buttonSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnMutext.png")));
            }
            ps.buttonContunine.addActionListener((ActionEvent a)
                    -> {
                ps.setVisible(false);
                ps.dispose();
            });
            ps.buttonReplay.addActionListener((ActionEvent a)
                    -> {
                if (ships.start == true) {
                    Message ms = new Message(this, true);
                    ms.jtext.setText("<html><h2 style='text-align: center;'>Trận chiến vẫn chưa kết thúc."
                            + "<br>Nếu chơi lại toàn bộ thành tích trong trận đấu này sẽ mất."
                            + "<br>Bạn có muốn không?</h2></html>");
                    ms.jtext.setFont(new java.awt.Font("Times New Roman", 1, 24));
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
                        Level lv = new Level();
                        lv.getShips().music = ships.music;
                        lv.getShips().mp3 = ships.mp3;
                        lv.setVisible(true);
                    });
                    ms.jcancel.addActionListener((ActionEvent ac)
                            -> {
                        ms.setVisible(false);
                        ms.dispose();
                    });
                    ms.setVisible(true);
                } else {
//                    ms.jtext.setText("Bạn có muốn thoát không ?");
                    ps.setVisible(false);
                    ps.dispose();
                    this.setVisible(false);
                    dispose();
                    Level lv = new Level();
                    lv.getShips().music = ships.music;
                    lv.getShips().mp3 = ships.mp3;
                    lv.setVisible(true);
                }
            });
            //
            ps.buttonHome.addActionListener((ActionEvent a)
                    -> {
                if (ships.start == true) {
                    Message ms = new Message(this, true);
                    ms.jtext.setText("<html><h2 style='text-align: center;'>Trận chiến vẫn chưa kết thúc.<br>Toàn bộ thành tích trong trận đấu này sẽ mất.<br>Bạn có muốn quay về màn hình chính không ?</h2></html>");
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
                        Home home = new Home(ships.music);
                        home.getShips().music = ships.music;
                        home.getShips().mp3 = ships.mp3;
                        home.setVisible(true);
                    });
                    ms.jcancel.addActionListener((ActionEvent ac)
                            -> {
                        ms.setVisible(false);
                        ms.dispose();
                    });
                    ms.setVisible(true);
                } else {
//                    ms.jtext.setText("Bạn có muốn thoát không ?");
                    ps.setVisible(false);
                    ps.dispose();
                    this.setVisible(false);
                    dispose();
                    Home home = new Home(ships.music);
                    home.getShips().music = ships.music;
                    home.getShips().mp3 = ships.mp3;
                    home.setVisible(true);
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
            ps.setVisible(true);
        });
        jscore.add(lbhitbot);
        jscore.add(HitTextfieldBot);
        jscore.add(lbmissbot);
        jscore.add(MissTextfieldBot);
        jscore.setOpaque(true);
        jscore.add(buttonStop);
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
        jp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JButton buttonPlay = new JButton();
        buttonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnStart.png")));
        buttonPlay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonPlay.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonPlay.setBounds(700, 0, 140, 50);
        buttonPlay.setOpaque(false);
        buttonPlay.setContentAreaFilled(false);
        buttonPlay.setBorderPainted(false);
        buttonPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
//                JOptionPane.showMessageDialog(null, "Mời bạn chơi trước");
                Turn turn = new Turn(this, true);
                turn.jtext.setText("<html><h2 style='text-align: center;'>Mời bạn chơi trước!</h2></html>");
                turn.setVisible(true);
                //
                if (ships.levelMax == 2 || ships.levelMax == 3) {
                    ships.enemy.updateMarkPosShip();
                }
            } else {
//                JOptionPane.showMessageDialog(null, "Vui lòng đặt tất cả tàu chiến lên sàn đấu!");
                Turn turn = new Turn(this, true);
                turn.jtext.setText("<html><h2 style='text-align: center;'>Vui lòng đặt tất cả tàu chiến lên sàn đấu!</h2></html>");
                turn.setVisible(true);//              
                jp.setVisible(true);
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
        buttonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnContu.png")));
        buttonStop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonStop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonStop.setBounds(200, 0, 50, 50);
        buttonStop.setOpaque(false);
        buttonStop.setContentAreaFilled(false);
        buttonStop.setBorderPainted(false);
        buttonStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonStop.addActionListener((ActionEvent e)
                -> {
            Pause ps = new Pause(this, true);
            ps.getShips().music = ships.music;
            ps.getShips().mp3 = ships.mp3;
            if (ps.getShips().music == true) {
                ps.buttonSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnSound.png")));
            } else {
                ps.buttonSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btnMutext.png")));
            }
            ps.buttonContunine.addActionListener((ActionEvent a)
                    -> {
                ps.setVisible(false);
                ps.dispose();
            });
            ps.buttonReplay.addActionListener((ActionEvent a)
                    -> {
                if (ships.start == true) {
                    Message ms = new Message();
                    ms.jtext.setText("<html><h2 style='text-align: center;'>Trận chiến vẫn chưa kết thúc."
                            + "<br>Nếu thoát toàn bộ thành tích trong trận đấu này sẽ mất."
                            + "<br>Bạn có muốn không?</h2></html>");
                    ms.setVisible(true);
                    ms.jtext.setFont(new java.awt.Font("Times New Roman", 1, 24));
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
                        Level lv = new Level();
                        lv.getShips().music = ships.music;
                        lv.getShips().mp3 = ships.mp3;
                        lv.setVisible(true);
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
                    lv.getShips().music = ships.music;
                    lv.getShips().mp3 = ships.mp3;
                    lv.setVisible(true);
                }
            });
            //
            ps.buttonHome.addActionListener((ActionEvent a)
                    -> {
                if (ships.start == true) {
                    Message ms = new Message(this, true);
                    ms.jtext.setText("<html><h2 style='text-align: center;'>Trận chiến vẫn chưa kết thúc.<br>Toàn bộ thành tích trong trận đấu này sẽ mất.<br>Bạn có quay về màn hình chính?</h2></html>");
                    ms.jtext.setFont(new java.awt.Font("Times New Roman", 1, 20));
                    //
                    ms.setVisible(true);
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
                        Home home = new Home(ships.music);
                        home.getShips().music = ships.music;
                        home.getShips().mp3 = ships.mp3;
                        home.setVisible(true);
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
                    Home home = new Home(ships.music);
                    home.getShips().music = ships.music;
                    home.getShips().mp3 = ships.mp3;
                    home.setVisible(true);

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
            ps.setVisible(true);
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
        scoreTextfield.setText(String.valueOf(ships.scorePlayer));
        HitTextfield.setText(String.valueOf(ships.sumHitPlayer));
        MissTextfield.setText(String.valueOf(ships.sumMissPlayer));
        HitTextfieldBot.setText(String.valueOf(ships.sumHitBot));
        MissTextfieldBot.setText(String.valueOf(ships.sumMissBot));
    }

    public void endgame() {
        if (ships.endgame == true && ships.checkWin == true) {
            Score rs = new Score(this, true);
            rs.jTextField1.setText(String.valueOf(ships.scorePlayer));
            rs.jtitle.setText("Thắng");
            rs.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(false); //you can't see me!
                    dispose();
                    Home home = new Home(ships.music);
                    home.getShips().music = ships.music;
                    home.getShips().mp3 = ships.mp3;
                    home.setVisible(true);
                }
            });
            //
            switch (ships.levelMax) {
                case 1:
                    rs.jbtext.setText("Cấp độ: Dễ");
                    rs.ships.levelMax = 1;
                    break;
                case 2:
                    rs.jbtext.setText("Cấp độ: Vừa");
                    rs.ships.levelMax = 2;
                    break;
                case 3:
                    rs.jbtext.setText("Cấp độ: Khó");
                    rs.ships.levelMax = 3;
                    break;
            }
            rs.jbtnREPLAY.addActionListener((ActionEvent a)
                    -> {
                rs.setVisible(false);
                rs.dispose();
                setVisible(false); //you can't see me!
                dispose();
                Level lv = new Level();
                lv.getShips().music = ships.music;
                lv.getShips().mp3 = ships.mp3;
                lv.setVisible(true);
            });
            rs.jbtnBACK.addActionListener((ActionEvent a)
                    -> {
                rs.setVisible(false);
                rs.dispose();
                setVisible(false);
                dispose();
                Home home = new Home(ships.music);
                home.getShips().music = ships.music;
                home.getShips().mp3 = ships.mp3;
                home.setVisible(true);
            });
            rs.setVisible(true);
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter sm = DateTimeFormatter.ofPattern("hh:mm:ss dd/MM/yyyy");
            String strDate = sm.format(currentDateTime);
            Model.Score score = new Model.Score();
            List<Model.Score> list = score.ReadFile();
            Model.Score score1 = new Model.Score();
            switch (ships.levelMax) {
                case 3:
                    score1 = new Model.Score("Noname", String.valueOf(strDate), ships.scorePlayer, ships.sumHitPlayer, ships.sumMissPlayer, 3, true);
                    break;
                case 2:
                    score1 = new Model.Score("Noname", String.valueOf(strDate), ships.scorePlayer, ships.sumHitPlayer, ships.sumMissPlayer, 2, true);
                    break;
                default:
                    score1 = new Model.Score("Noname", String.valueOf(strDate), ships.scorePlayer, ships.sumHitPlayer, ships.sumMissPlayer, 1, true);
                    break;
            }
            list.add(score1);
            score.WriteFile(list);
            running = false;
        } else if (ships.endgame == true && ships.checkWin == false) {
            Score rs = new Score(this, true);
            rs.jTextField1.setText(String.valueOf(ships.scorePlayer));
            rs.jtitle.setText("Thua");
            rs.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(false); //you can't see me!
                    dispose();
                    Home home = new Home(ships.music);
                    home.getShips().music = ships.music;
                    home.getShips().mp3 = ships.mp3;
                    home.setVisible(true);
                }
            });
            switch (ships.levelMax) {
                case 1:
                    rs.jbtext.setText("Cấp độ: Dễ");
                    rs.ships.levelMax = 1;
                    break;
                case 2:
                    rs.jbtext.setText("Cấp độ: Vừa");
                    rs.ships.levelMax = 2;
                    break;
                case 3:
                    rs.jbtext.setText("Cấp độ: Khó");
                    rs.ships.levelMax = 3;
                    break;
            }
            rs.jbtnREPLAY.addActionListener((ActionEvent a)
                    -> {
                rs.setVisible(false);
                rs.dispose();
                setVisible(false); //you can't see me!
                dispose();
                Level lv = new Level();
                lv.getShips().music = ships.music;
                lv.getShips().mp3 = ships.mp3;
                lv.setVisible(true);
            });
            rs.jbtnBACK.addActionListener((ActionEvent a)
                    -> {
                rs.setVisible(false);
                rs.dispose();
                setVisible(false);
                dispose();
                Home home = new Home(ships.music);
                home.getShips().music = ships.music;
                home.getShips().mp3 = ships.mp3;
                home.setVisible(true);
            });
            rs.setVisible(true);
//                System.out.println("Điểm của bạn là:"+scorePlayer);
            //
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter sm = DateTimeFormatter.ofPattern("hh:mm:ss dd/MM/yyyy");
            String strDate = sm.format(currentDateTime);
            Model.Score score = new Model.Score();
            List<Model.Score> list = score.ReadFile();
            Model.Score score1 = new Model.Score();
            switch (ships.levelMax) {
                case 3:
                    score1 = new Model.Score("Noname", String.valueOf(strDate), ships.scorePlayer, ships.sumHitPlayer, ships.sumMissPlayer, 3, false);
                    break;
                case 2:
                    score1 = new Model.Score("Noname", String.valueOf(strDate), ships.scorePlayer, ships.sumHitPlayer, ships.sumMissPlayer, 2, false);
                    break;
                case 1:
                    score1 = new Model.Score("Noname", String.valueOf(strDate), ships.scorePlayer, ships.sumHitPlayer, ships.sumMissPlayer, 1, false);
                    break;
            }
            list.add(score1);
            score.WriteFile(list);
            running = false;
        }
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
                update();
                draw();
                endgame();
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
