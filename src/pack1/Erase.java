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
public class Erase extends Shape {

    private final ArrayList<Integer> varX = new ArrayList<>();
    private final ArrayList<Integer> varY = new ArrayList<>();

    public Erase(int startX, int startY, int endX, int endY) {
        super(4, startX, startY, endX, endY, false, false);

    }

    @Override
    public void draw(Graphics g) {

        varX.add(endX);
        varY.add(endY);
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        for (int i = 0; i < varX.size() - 1; i++) {
            g2d.drawLine(varX.get(i), varY.get(i), varX.get(i + 1), varY.get(i + 1));
        }
    }

}
