/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author SALMA
 */
public class DrawRect extends Shape {

    public DrawRect(int color, int startX, int startY, int endX, int endY, boolean filled, boolean dotted) {
        super(color, startX, startY, endX, endY, filled, dotted);
    }

    @Override
    public void draw(Graphics g) {

        int width = Math.abs(endX - startX);
        int height = Math.abs(endY - startY);
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);

        g.setColor(this.color);
        Graphics2D g2d = (Graphics2D) g;
        if (filled) {
            g.fillRect(x, y, width, height);

        } else {
            if (dotted == true) {
                float[] dotPattern = {3, 5};
                BasicStroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dotPattern, 0);

                g2d.setStroke(stroke);
            } else {
                g2d.setStroke(new BasicStroke());

            }
            g2d.drawRect(x, y, width, height);
        }
    }
}
