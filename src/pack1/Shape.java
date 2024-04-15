/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author SALMA
 */
abstract class Shape {

    protected Color color;
    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected boolean filled;
    protected boolean dotted;

    public Shape(int color, int startX, int startY, int endX, int endY, boolean filled, boolean dotted) {

        switch (color) {
            case 1:
                this.color = Color.RED;
                break;
            case 2:
                this.color = Color.GREEN;
                break;
            case 3:
                this.color = Color.BLUE;
                break;
            case 4:
                this.color = Color.WHITE;
                break;
            case 5:
                this.color = Color.BLACK;
                break;
        }
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.filled = filled;
        this.dotted = dotted;

    }

    public void setendX(int x) {
        endX = x;
    }

    public void setendY(int y) {
        endY = y;
    }

    abstract void draw(Graphics var1);

}
