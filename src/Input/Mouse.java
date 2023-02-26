package Input;

import Objects.Ships;
import Objects.States;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Dell
 */
public class Mouse implements MouseListener {

    private States ships = null;
    private boolean[][] hitsEnemyBoard = new boolean[10][10];
    //private MouseMoveShips mms = new MouseMoveShips();

    public Mouse(States ships) {
        this.ships = ships;
    }

    // kiểm tra tính hợp lệ của vị trí của một tàu chiến.
    private boolean isvalid(Ships ship) {
        if (ships.battleship.isBoard() && ships.battleship != ship) {
            for (int i = 0; i < ships.battleship.getLife(); i++) {
                for (int j = 0; j < ship.getLife(); j++) {
                    if ((ships.battleship.position[i][0] == ship.position[j][0]) && ships.battleship.position[i][2] == ship.position[j][2]) {
                        return true;
                    }
                }
            }
        } else if (ships.battleship == ship) {
            ship.setBoard(true);
        }
        if (ships.cruise.isBoard() && ships.cruise != ship) {
            for (int i = 0; i < ships.cruise.getLife(); i++) {
                for (int j = 0; j < ship.getLife(); j++) {
                    if ((ships.cruise.position[i][0] == ship.position[j][0]) && ships.cruise.position[i][2] == ship.position[j][2]) {
                        return true;
                    }
                }
            }
        } else if (ships.cruise == ship) {
            ship.setBoard(true);
        }
        if (ships.destroyer1.isBoard() && ships.destroyer1 != ship) {
            for (int i = 0; i < ships.destroyer1.getLife(); i++) {
                for (int j = 0; j < ship.getLife(); j++) {
                    if ((ships.destroyer1.position[i][0] == ship.position[j][0]) && ships.destroyer1.position[i][2] == ship.position[j][2]) {
                        return true;
                    }
                }
            }
        } else if (ships.destroyer1 == ship) {
            ship.setBoard(true);
        }
        if (ships.destroyer2.isBoard() && ships.destroyer2 != ship) {
            for (int i = 0; i < ships.destroyer2.getLife(); i++) {
                for (int j = 0; j < ship.getLife(); j++) {
                    if ((ships.destroyer2.position[i][0] == ship.position[j][0]) && ships.destroyer2.position[i][2] == ship.position[j][2]) {
                        return true;
                    }
                }
            }
        } else if (ships.destroyer2 == ship) {
            ship.setBoard(true);
        }
        if (ships.submarine.isBoard() && ships.submarine != ship) {
            for (int i = 0; i < ships.submarine.getLife(); i++) {
                for (int j = 0; j < ship.getLife(); j++) {
                    if ((ships.submarine.position[i][0] == ship.position[j][0]) && ships.submarine.position[i][2] == ship.position[j][2]) {
                        return true;
                    }
                }
            }
        } else if (ships.submarine == ship) {
            ship.setBoard(true);
        }
        return false;
    }

    // đặt tàu chiến lên bàn cờ
    private void setShip() {
        int cont = 0;
        MouseDragged.isMoved = true;
        Ships ship = MouseDragged.ship;
        try {
            int box = 11 - ship.getLife();
            int x = ship.getX1() + 20;
            int y = ship.getY1() + 20;
            for (int i = 0; i < 100; i++) {
                if (!ship.isRotate()) {
                    if (ships.board.boxBoard[i][0] <= x && ships.board.boxBoard[i][1] >= x && ships.board.boxBoard[i][2] <= y && ships.board.boxBoard[i][3] >= y && cont < box) {
                        ship.setX(ships.board.boxBoard[i][0]);
                        ship.setY(ships.board.boxBoard[i][2]);
                        ship.setPosition();
                        if (isvalid(ship)) {
                            ship.rotateTo0();
                            ship.setX(ship.XStart);
                            ship.setY(ship.YStart);
                        }
                        break;
                    }
                    if (cont > 8) {
                        cont = 0;
                    } else {
                        cont++;
                    }
                } else if (ships.board.boxBoard[i][0] <= x && ships.board.boxBoard[i][1] >= x && ships.board.boxBoard[i][2] <= y && ships.board.boxBoard[i][3] >= y && i < (100 - (10 * (ship.getLife() - 1)))) {
                    ship.setX(ships.board.boxBoard[i][0]);
                    ship.setY(ships.board.boxBoard[i][2]);
                    ship.setPosition();
                    if (isvalid(ship)) {
                        ship.rotateTo0();
                        ship.setX(ship.XStart);
                        ship.setY(ship.YStart);
                    }
                    break;
                }
                if (i == 99) {
                    ship.rotateTo0();
                    ship.setBoard(false);
                    ship.setX(ship.XStart);
                    ship.setY(ship.YStart);
                    ship.setPosition();
                }
            }
        } catch (Exception ex) {
        }
    }

    // xử lý sự kiện nhấp chuột của người chơi trên bàn cờ đối thủ
    private void clickboardenemy(int x, int y) {
        if (ships.turn && ships.start) {
            int coory = 0;
            int coorx = 0;
            for (int i = 0; i < 100; i++) {
                if (ships.boardEnemy.boxBoard[i][0] < x && ships.boardEnemy.boxBoard[i][1] > x && ships.boardEnemy.boxBoard[i][2] < y && ships.boardEnemy.boxBoard[i][3] > y) {
//                    System.out.println("Vi Tri" + "(" + coory + ";" + coorx + ")" + ships.enemy.board[coory][coorx]);
                    if (!hitsEnemyBoard[coory][coorx]) {
                        if (ships.enemy.board[coory][coorx] == '+') {
                            //System.out.println("Vi Tri"+"("+coory+";"+coorx+")"+ships.enemy.board[coory][coorx]);
                            ships.createHit(false, 0, ships.boardEnemy.boxBoard[i][0], ships.boardEnemy.boxBoard[i][2]);
                            if (ships.enemy.battleship.getX1() < x && ships.enemy.battleship.getX2() > x && ships.enemy.battleship.getY1() < y && ships.enemy.battleship.getY2() > y) {
                                ships.enemy.battleship.reduceLife();
//                                System.out.println("Đã bắn trúng tàu địch 5" + (ships.scorePlayer += 50));
                                ships.scorePlayer += CalcSumScore(SumShot(), 5);
                            }
                            if (ships.enemy.cruise.getX1() < x && ships.enemy.cruise.getX2() > x && ships.enemy.cruise.getY1() < y && ships.enemy.cruise.getY2() > y) {
                                ships.enemy.cruise.reduceLife();
//                                System.out.println("Đã bắn trúng tàu địch 4" + (ships.scorePlayer += 40));
                                ships.scorePlayer += CalcSumScore(SumShot(), 4);
                            }
                            if (ships.enemy.destroyer1.getX1() < x && ships.enemy.destroyer1.getX2() > x && ships.enemy.destroyer1.getY1() < y && ships.enemy.destroyer1.getY2() > y) {
                                ships.enemy.destroyer1.reduceLife();
//                                System.out.println("Đã bắn trúng tàu địch 3" + (ships.scorePlayer += 30));
                                ships.scorePlayer += CalcSumScore(SumShot(), 3);
                            }
                            if (ships.enemy.destroyer2.getX1() < x && ships.enemy.destroyer2.getX2() > x && ships.enemy.destroyer2.getY1() < y && ships.enemy.destroyer2.getY2() > y) {
                                ships.enemy.destroyer2.reduceLife();
//                                System.out.println("Đã bắn trúng tàu địch 3" + (ships.scorePlayer += 30));
                                ships.scorePlayer += CalcSumScore(SumShot(), 3);
                            }
                            if (ships.enemy.submarine.getX1() < x && ships.enemy.submarine.getX2() > x && ships.enemy.submarine.getY1() < y && ships.enemy.submarine.getY2() > y) {
                                ships.enemy.submarine.reduceLife();
//                                System.out.println("Đã bắn trúng tàu địch 2" + (ships.scorePlayer += 20));
                                ships.scorePlayer += CalcSumScore(SumShot(), 2);
                            }
                        } else {
                            ships.createHit(false, 1, ships.boardEnemy.boxBoard[i][0], ships.boardEnemy.boxBoard[i][2]);
                        }
                        hitsEnemyBoard[coory][coorx] = true;
                        ships.turn = false;
                    }
                    break;
                }
                if (coorx < 9) {
                    coorx++;
                } else {
                    coory++;
                    coorx = 0;
                }
            }
        }
    }
    // Đếm số lần đã bắn
    private int SumShot() {
        int count = 0;
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                if (hitsEnemyBoard[j][k] == true) {
                    count++;
                }
            }
        }
        return count;
    }
    // Tính tổng điểm người chơi
    private long CalcSumScore(int sumshot, int typeShip) {
        long sum = 0;
        int x;
        if (sumshot < 11) {
            x = 5;
        } else if (sumshot < 21) {
            x = 4;
        } else if (sumshot < 31) {
            x = 3;
        } else if (sumshot < 41) {
            x = 2;
        } else {
            x = 1;
        }
        switch (typeShip) {
            case 2:
                sum += (50 * x);
                break;
            case 3:
                sum += (40 * x);
                break;
            case 4:
                sum += (30 * x);
                break;
            case 5:
                sum += (20 * x);
                break;
        }
        System.out.println("Điểm lần bắn hiện tại:"+sum);
        return sum;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        clickboardenemy(me.getX(), me.getY());

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        setShip();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
