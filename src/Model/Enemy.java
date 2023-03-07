package Model;

import Images.Load;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Enemy implements GameObject {

    public Battleship battleship;
    public Cruise cruise;
    public Destroyer destroyer1;
    public Destroyer destroyer2;
    public Submarine submarine;
    private States ships;
    public char[][] board
            = {
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}
            }; // Ký tự * đại diện cho vị trí trống
    public char[][] boardEnemy
            = {
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}
            };
    public int[][] positionShips = new int[5][3];

    public Enemy(States ships) {
        this.ships = ships;
        setShipsEnemys();
        setImages();
    }

    // Tấn công vào một vị trí trên bảng
    public void shot() {
        int x;
        int y;
        boolean exist = true;
        while (exist) {
            boolean hit = false;
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (boardEnemy[x][y] == '*') {
                boardEnemy[x][y] = 'x'; // Ký tự x đại diện cho vị trí bị bắn trúng
                int posBor = getBoardPost(x, y);
                int X = ships.board.boxBoard[posBor][0];
                int Y = ships.board.boxBoard[posBor][2];
                //
                if (ships.battleship.getX1() <= X && ships.battleship.getX2() > X && ships.battleship.getY1() <= Y && ships.battleship.getY2() > Y) {
                    ships.battleship.reduceLife();
                    hit = true;
                }
                if (ships.cruise.getX1() <= X && ships.cruise.getX2() > X && ships.cruise.getY1() <= Y && ships.cruise.getY2() > Y) {
                    ships.cruise.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 4"+(score+=40));
                }
                if (ships.destroyer1.getX1() <= X && ships.destroyer1.getX2() > X && ships.destroyer1.getY1() <= Y && ships.destroyer1.getY2() > Y) {
                    ships.destroyer1.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 3"+(score+=30));
                }
                if (ships.destroyer2.getX1() <= X && ships.destroyer2.getX2() > X && ships.destroyer2.getY1() <= Y && ships.destroyer2.getY2() > Y) {
                    ships.destroyer2.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 3"+(score+=30));
                }
                if (ships.submarine.getX1() <= X && ships.submarine.getX2() > X && ships.submarine.getY1() <= Y && ships.submarine.getY2() > Y) {
                    ships.submarine.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 2"+(score+=20));
                }
                //
                if (hit) {
                    ships.createHit(true, 0, X, Y);
                } else {
                    ships.createHit(true, 1, X, Y);
                }
                exist = false;
            }
        }
        ships.turn = true;
    }

    //
    public void shotLevelMax() {
        int x;
        int y;
        boolean exist = true;
        while (exist) {
            boolean hit = false;
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (boardEnemy[x][y] == '+') {
                boardEnemy[x][y] = 'x'; // Ký tự x đại diện cho vị trí bị bắn trúng
                int posBor = getBoardPost(x, y);
                int X = ships.board.boxBoard[posBor][0];
                int Y = ships.board.boxBoard[posBor][2];
                //
                if (ships.battleship.getX1() <= X && ships.battleship.getX2() > X && ships.battleship.getY1() <= Y && ships.battleship.getY2() > Y) {
                    ships.battleship.reduceLife();
                    hit = true;
                }
                if (ships.cruise.getX1() <= X && ships.cruise.getX2() > X && ships.cruise.getY1() <= Y && ships.cruise.getY2() > Y) {
                    ships.cruise.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 4"+(score+=40));
                }
                if (ships.destroyer1.getX1() <= X && ships.destroyer1.getX2() > X && ships.destroyer1.getY1() <= Y && ships.destroyer1.getY2() > Y) {
                    ships.destroyer1.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 3"+(score+=30));
                }
                if (ships.destroyer2.getX1() <= X && ships.destroyer2.getX2() > X && ships.destroyer2.getY1() <= Y && ships.destroyer2.getY2() > Y) {
                    ships.destroyer2.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 3"+(score+=30));
                }
                if (ships.submarine.getX1() <= X && ships.submarine.getX2() > X && ships.submarine.getY1() <= Y && ships.submarine.getY2() > Y) {
                    ships.submarine.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 2"+(score+=20));
                }
                //
                if (hit) {
                    ships.createHit(true, 0, X, Y);
                } else {
                    ships.createHit(true, 1, X, Y);
                }
                exist = false;
            }
        }
        ships.turn = true;
//        int x;
//        int y;
//        boolean exist = true;
//        System.out.println("Board Bot");
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print(board[i][j]);
//                System.out.print("\t");
//                if (j == 9) {
//                    System.out.println("\n");
//                }
//            }
//        }
//        while (exist) {
//            boolean hit = false;
////            x = (int) (Math.random() * 10);
////            y = (int) (Math.random() * 10);
//            int X = 0;
//            int Y = 0;
//            PointShip point = new PointShip();
//            for (PointShip p : ships.listPoint) {
//                if (!p.isIsHit()) {
//                    X = p.getX();
//                    Y = p.getY();
//                    p.setIsHit(true);
//                    point = p;
//                    break;
//                }
//            }
//            x = getPositionPoint(point).getX();
//            y = getPositionPoint(point).getY();
//            if (boardEnemy[x][y] == '*') { // Nếu vị trí trống
//                boardEnemy[x][y] = 'x';
//                System.out.println("Board You");
//                for (int i = 0; i < 10; i++) {
//                    for (int j = 0; j < 10; j++) {
//                        System.out.print(boardEnemy[i][j]);
//                        System.out.print("\t");
//                        if (j == 9) {
//                            System.out.println("\n");
//                        }
//                    }
//                }
//                if (ships.battleship.getX1() <= X && ships.battleship.getX2() > X && ships.battleship.getY1() <= Y && ships.battleship.getY2() > Y) {
//                    ships.battleship.reduceLife();
//                    hit = true;
////                    System.out.println("Bắn trúng tàu 5: "+(score+=50));
//                }
//                if (ships.cruise.getX1() <= X && ships.cruise.getX2() > X && ships.cruise.getY1() <= Y && ships.cruise.getY2() > Y) {
//                    ships.cruise.reduceLife();
//                    hit = true;
////                    System.out.println("Bắn trúng tàu 4"+(score+=40));
//                }
//                if (ships.destroyer1.getX1() <= X && ships.destroyer1.getX2() > X && ships.destroyer1.getY1() <= Y && ships.destroyer1.getY2() > Y) {
//                    ships.destroyer1.reduceLife();
//                    hit = true;
////                    System.out.println("Bắn trúng tàu 3"+(score+=30));
//                }
//                if (ships.destroyer2.getX1() <= X && ships.destroyer2.getX2() > X && ships.destroyer2.getY1() <= Y && ships.destroyer2.getY2() > Y) {
//                    ships.destroyer2.reduceLife();
//                    hit = true;
////                    System.out.println("Bắn trúng tàu 3"+(score+=30));
//                }
//                if (ships.submarine.getX1() <= X && ships.submarine.getX2() > X && ships.submarine.getY1() <= Y && ships.submarine.getY2() > Y) {
//                    ships.submarine.reduceLife();
//                    hit = true;
////                    System.out.println("Bắn trúng tàu 2"+(score+=20));
//                }
//                if (hit) {
//                    ships.createHit(true, 0, X, Y);
//                } else {
//                    ships.createHit(true, 1, X, Y);
//                }
//                exist = false;
//            }
//        }
//        ships.turn = true;
    }

    // shotlevelmedium
    //
    public void shotLevelMedium() {
        int x;
        int y;
        boolean exist = true;
        while (exist) {
            boolean hit = false;
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (boardEnemy[x][y] == '+' || boardEnemy[x][y] == 'o') {
                boardEnemy[x][y] = 'x'; // Ký tự x đại diện cho vị trí bị bắn trúng
                int posBor = getBoardPost(x, y);
                int X = ships.board.boxBoard[posBor][0];
                int Y = ships.board.boxBoard[posBor][2];
                //
                if (ships.battleship.getX1() <= X && ships.battleship.getX2() > X && ships.battleship.getY1() <= Y && ships.battleship.getY2() > Y) {
                    ships.battleship.reduceLife();
                    hit = true;
                }
                if (ships.cruise.getX1() <= X && ships.cruise.getX2() > X && ships.cruise.getY1() <= Y && ships.cruise.getY2() > Y) {
                    ships.cruise.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 4"+(score+=40));
                }
                if (ships.destroyer1.getX1() <= X && ships.destroyer1.getX2() > X && ships.destroyer1.getY1() <= Y && ships.destroyer1.getY2() > Y) {
                    ships.destroyer1.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 3"+(score+=30));
                }
                if (ships.destroyer2.getX1() <= X && ships.destroyer2.getX2() > X && ships.destroyer2.getY1() <= Y && ships.destroyer2.getY2() > Y) {
                    ships.destroyer2.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 3"+(score+=30));
                }
                if (ships.submarine.getX1() <= X && ships.submarine.getX2() > X && ships.submarine.getY1() <= Y && ships.submarine.getY2() > Y) {
                    ships.submarine.reduceLife();
                    hit = true;
//                    System.out.println("Bắn trúng tàu 2"+(score+=20));
                }
                //
                if (hit) {
                    ships.createHit(true, 0, X, Y);
                } else {
                    ships.createHit(true, 1, X, Y);
                }
                exist = false;
            }
        }
        ships.turn = true;
    }

    //
    // Lấy tọa độ ô trên sàn đấu thông qua X,Y từ list PointShip
    public void updateMarkPosShip() {
        int count = 0;
        int x, y;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (PointShip p : ships.listPoint) {
                    if (i == getPositionPoint(p).getX() && j == getPositionPoint(p).getY()) {
                        boardEnemy[i][j] = '+';
                        count++;
                        break;
                    }
                }
                if (count == 17) {
                    System.out.println("Da them du");
                    break;
                }
            }
        }
        int countt = 0;
        boolean check = true;
        if (ships.levelMax == 2) {
            while (check) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (boardEnemy[x][y] == '*') {
                    boardEnemy[x][y] = 'o';
                    countt++;
                    if (countt == 17) {
                        break;
                    }
                }
            }

        }
//        System.out.println("Board You");
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print(boardEnemy[i][j]);
//                System.out.print("\t");
//                if (j == 9) {
//                    System.out.println("\n");
//                }
//            }
//        }

    }

    public PointShip getPositionPoint(PointShip point) {
        PointShip p = new PointShip();
        //
        int num = 0;
        for (int i = 0; i < 100; i++) {
            if (ships.board.boxBoard[i][0] == point.getX() && ships.board.boxBoard[i][2] == point.getY()) {
                num = i;
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (getBoardPost(i, j) == num) {
                    p.setX(i);
                    p.setY(j);
                    break;
                }
            }
        }
        return p;
    }

    // Lấy vị trí i của một ô trên bảng thông qua tọa độ(x,y)
    public int getBoardPost(int x, int y) {
        int contx = 0;
        int conty = 0;
        for (int i = 0; i < 100; i++) {
            if (contx == x && conty == y) {
                return i;
            } else if (conty < 9) {
                conty++;
            } else {
                contx++;
                conty = 0;
            }
        }
        return -1;
    }

    private void setShipsEnemys() {
        setShips();
        boolean valid = true;
        int numComp = 0;
        while (valid) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (board[i][j] == '+') {
                        numComp++;
                    }
                }
            }
            if (numComp == 17) {
                valid = false;
            } else {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        board[i][j] = '*';
                    }
                }
                numComp = 0;
                setShips();
            }
        }
    }

    // 
    private void randomPos() {
        int cont = 0;
        boolean comp = true;
        for (int i = 5; i > 1; i--) {
            int direc = (int) (Math.random() * 2);
            int num = (int) (Math.random() * 10);
            if (num >= (9 - i)) {
                num = num - (num - i);
            }
            positionShips[cont][0] = num;
            positionShips[cont][1] = (int) (Math.random() * 10);
            positionShips[cont][2] = direc;
            cont++;
            if (i == 3 && comp) {
                i++;
                comp = false;
            }
        }
    }

    private void setShips() {
        boolean comp = true;
        randomPos();
        int cont = 5;
        for (int i = 0; i < 5; i++) {
            if (positionShips[i][2] == 0) {
                for (int j = positionShips[i][0]; j < positionShips[i][0] + cont; j++) {
                    board[positionShips[i][1]][j] = '+'; // Ký tự + đại diện cho một phần vị trí của tàu
                }
            } else {
                for (int j = positionShips[i][0]; j < positionShips[i][0] + cont; j++) {
                    board[j][positionShips[i][1]] = '+';
                }
            }
            if (cont == 3 && comp) {
                cont++;
                comp = false;
            }
            cont--;
        }
    }

    private void setImages() {
        boolean comp = true;
        int cont = 5;
        for (int i = 0; i < 5; i++) {
            if (positionShips[i][2] == 0) {
                int pos = getBoardPost(positionShips[i][1], positionShips[i][0]);
                switch (cont) {
                    case 5:
                        battleship = new Battleship(Load.LoadImage("Battleship.png"), 5, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                        break;
                    case 4:
                        cruise = new Cruise(Load.LoadImage("Cruise.png"), 4, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                        break;
                    case 3:
                        if (comp) {
                            destroyer1 = new Destroyer(Load.LoadImage("Destroyer.png"), 3, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                        } else {
                            destroyer2 = new Destroyer(Load.LoadImage("Destroyerr.png"), 3, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                        }
                        break;
                    case 2:
                        submarine = new Submarine(Load.LoadImage("Submarine.png"), 2, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                        break;
                }
            } else {
                int pos = getBoardPost(positionShips[i][0], positionShips[i][1]);
                switch (cont) {
                    case 5:
                        battleship = new Battleship(Load.LoadImage("Battleship.png"), 5, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                        battleship.rotateTo90();
                        break;
                    case 4:
                        cruise = new Cruise(Load.LoadImage("Cruise.png"), 4, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                        cruise.rotateTo90();
                        break;
                    case 3:
                        if (comp) {
                            destroyer1 = new Destroyer(Load.LoadImage("Destroyer.png"), 3, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                            destroyer1.rotateTo90();
                        } else {
                            destroyer2 = new Destroyer(Load.LoadImage("Destroyerr.png"), 3, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                            destroyer2.rotateTo90();
                        }
                        break;
                    case 2:
                        submarine = new Submarine(Load.LoadImage("Submarine.png"), 2, ships.boardEnemy.boxBoard[pos][0], ships.boardEnemy.boxBoard[pos][2]);
                        submarine.rotateTo90();
                        break;
                }
            }
            if (cont == 3 && comp) {
                cont++;
                comp = false;
            }
            cont--;
        }
    }

    @Override
    public String toString() {
        String xd = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                xd += board[i][j];
            }
            xd += "\n";
        }
        return xd;
    }

    @Override
    public void draw(Graphics g) {
        if (battleship.getLife() == 0) {
            battleship.draw(g);
        }
        if (cruise.getLife() == 0) {
            cruise.draw(g);
        }
        if (destroyer1.getLife() == 0) {
            destroyer1.draw(g);
        }
        if (destroyer2.getLife() == 0) {
            destroyer2.draw(g);
        }
        if (submarine.getLife() == 0) {
            submarine.draw(g);
        }
    }
}
