package Model;

import Images.Load;
import Main.BattleShip;
import Main.Home;
import Main.Score;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class States {

    public Battleship battleship;
    public Cruise cruise;
    public Destroyer destroyer1;
    public Destroyer destroyer2;
    public Submarine submarine;
    public Board board;
    public Board boardEnemy;
    public Enemy enemy;
    public boolean levelMax; // true : khó ;; false : dễ
    public long scorePlayer;
    public int sumHitPlayer = 0;
    public int sumMissPlayer = 0;
    public int sumHitBot = 0;
    public int sumMissBot = 0;
    public boolean turn = true; // lượt đánh của người chơi
    public boolean start = false; // trạng thái trò chơi
    public boolean endgame = false; // Kết thúc trận đấu
    public boolean checkWin; // thắng hay thua
    public ArrayList<Hit> hitsEnemy = new ArrayList<>();
    public ArrayList<Hit> hits = new ArrayList<>();

    public States() {
        board = new Board(Load.LoadImage("Board.png"), 25, 60); // y từ 20 tăng lên 60 => +40
        boardEnemy = new Board(Load.LoadImage("Board.png"), 610, 60);
        battleship = new Battleship(Load.LoadImage("Battleship.png"), 5, 20, 620);
        cruise = new Cruise(Load.LoadImage("Cruise.png"), 4, 300, 620);
        destroyer1 = new Destroyer(Load.LoadImage("Destroyer.png"), 3, 20, 680);
        destroyer2 = new Destroyer(Load.LoadImage("Destroyerr.png"), 3, 200, 680);
        submarine = new Submarine(Load.LoadImage("Submarine.png"), 2, 370, 680);
        enemy = new Enemy(this);
        //
    }

    public void resetShips() {
        battleship.rotateTo0();
        battleship.setX(battleship.XStart);
        battleship.setY(battleship.YStart);
        battleship.setPosition();
        battleship.board = false;
        cruise.rotateTo0();
        cruise.setX(cruise.XStart);
        cruise.setY(cruise.YStart);
        cruise.setPosition();
        cruise.board = false;
        destroyer1.rotateTo0();
        destroyer1.setX(destroyer1.XStart);
        destroyer1.setY(destroyer1.YStart);
        destroyer1.setPosition();
        destroyer1.board = false;
        destroyer2.rotateTo0();
        destroyer2.setX(destroyer2.XStart);
        destroyer2.setY(destroyer2.YStart);
        destroyer2.setPosition();
        destroyer2.board = false;
        submarine.rotateTo0();
        submarine.setX(submarine.XStart);
        submarine.setY(submarine.YStart);
        submarine.setPosition();
        submarine.board = false;
    }

    public void createHit(boolean pla, int type, int x, int y) {
        if (pla) { // Kiểm tra lần đánh của người hay máy true là máy, false là người
            if (type == 0) {
                hits.add(new Hit(Load.LoadImage("hit.png"), x, y));
                sumHitBot++;
            } else {
                hits.add(new Hit(Load.LoadImage("failure.png"), x, y));
                sumMissBot++;
            }
        } else if (type == 0) {
            hitsEnemy.add(new Hit(Load.LoadImage("hit.png"), x, y));
            sumHitPlayer++;
        } else {
            hitsEnemy.add(new Hit(Load.LoadImage("failure.png"), x, y));
            sumMissPlayer++;
        }
    }

    public void update() {
        if (start) {
            if (enemy.battleship.getLife() == 0 && enemy.cruise.getLife() == 0 && enemy.destroyer1.getLife() == 0 && enemy.destroyer2.getLife() == 0 && enemy.submarine.getLife() == 0) {
                start = false;
                endgame = true;
                checkWin = true;
                JOptionPane.showMessageDialog(null, "Bạn đã thắng");
                Score rs = new Score();
                rs.setVisible(true);
                rs.jTextField1.setText(String.valueOf(scorePlayer));
                //
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter sm = DateTimeFormatter.ofPattern("hh:mm:ss dd/MM//yyyy");
                String strDate = sm.format(currentDateTime);
                Model.Score score = new Model.Score();
                List<Model.Score> list = score.ReadFile();
                Model.Score score1 = new Model.Score("Noname", String.valueOf(strDate), scorePlayer, sumHitPlayer, sumMissPlayer, 1, true);
                list.add(score1);
                score.WriteFile(list);
            } else if (battleship.getLife() == 0 && cruise.getLife() == 0 && destroyer1.getLife() == 0 && destroyer2.getLife() == 0 && submarine.getLife() == 0) {
                start = false;
                endgame = true;
                checkWin = false;
                JOptionPane.showMessageDialog(null, "Bạn đã thua");
                Score rs = new Score();
                rs.setVisible(true);
//                System.out.println("Điểm của bạn là:"+scorePlayer);
                rs.jTextField1.setText(String.valueOf(scorePlayer));
                //
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter sm = DateTimeFormatter.ofPattern("hh:mm:ss dd/MM//yyyy");
                String strDate = sm.format(currentDateTime);
                Model.Score score = new Model.Score();
                List<Model.Score> list = score.ReadFile();
                Model.Score score1 = new Model.Score("Noname", String.valueOf(strDate), scorePlayer, sumHitPlayer, sumMissPlayer, 1, false);
                list.add(score1);
                score.WriteFile(list);
            } else if (!turn) {
                enemy.shotLevelMax();
            }
        }
    }

    public void draw(Graphics g) {
        board.draw(g);
        boardEnemy.draw(g);
        cruise.draw(g);
        battleship.draw(g);
        destroyer1.draw(g);
        destroyer2.draw(g);
        submarine.draw(g);
        enemy.draw(g);
        for (Hit hit : hits) {
            hit.draw(g);
        }
        int size = hitsEnemy.size();
        for (int i = 0; i < size; i++) {
            hitsEnemy.get(i).draw(g);
        }
//        for (Hit hitsEnemy1 : hitsEnemy)

    }
}
