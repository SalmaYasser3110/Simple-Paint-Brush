/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author SALMA
 */
public class Pen extends Shape {

    private final ArrayList<Integer> varX = new ArrayList<>();
    private final ArrayList<Integer> varY = new ArrayList<>();

    public Pen(int color, int startX, int startY, int endX, int endY, boolean filled, boolean dotted) {
        super(color, startX, startY, endX, endY, filled, dotted);

    }

    @Override
    public void draw(Graphics g) {
        if (dotted) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
            varX.add(endX);
            varY.add(endY);
            g2d.setColor(color);
            for (int i = 0; i < varX.size() - 1; i++) {
                g2d.drawLine(varX.get(i), varY.get(i), varX.get(i + 1), varY.get(i + 1));
            }
        } else {
            varX.add(endX);
            varY.add(endY);
            g.setColor(color);
            for (int i = 0; i < varX.size() - 1; i++) {
                g.drawLine(varX.get(i), varY.get(i), varX.get(i + 1), varY.get(i + 1));
            }
        }
    }
}
