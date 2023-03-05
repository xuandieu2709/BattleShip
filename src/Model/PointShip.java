/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class PointShip {
    private int X;
    private int Y;
    private int typeShip;
    private boolean isHit;
    private boolean isShip;
    public PointShip() {
    }

    public PointShip(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
    
    public PointShip(int X, int Y,boolean isHit) {
        this.X = X;
        this.Y = Y;
        this.isHit = isHit;
    }
    
    public PointShip(int X, int Y,boolean isHit,boolean isShip) {
        this.X = X;
        this.Y = Y;
        this.isHit = isHit;
        this.isShip = isShip;
    }

    public PointShip(int X, int Y, int typeShip) {
        this.X = X;
        this.Y = Y;
        this.typeShip = typeShip;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getTypeShip() {
        return typeShip;
    }

    public void setTypeShip(int typeShip) {
        this.typeShip = typeShip;
    }

    public boolean isIsHit() {
        return isHit;
    }

    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }

    public boolean isIsShip() {
        return isShip;
    }

    public void setIsShip(boolean isShip) {
        this.isShip = isShip;
    }
    
    

    @Override
    public String toString() {
        return "PointShip{" + "X=" + X + ", Y=" + Y + ", typeShip=" + typeShip + '}';
    }
    
}
