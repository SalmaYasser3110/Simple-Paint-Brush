/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author SALMA
 */
public class MyPanel extends JPanel {

    boolean drawLine = false;
    boolean drawRect = false;
    boolean drawOval = false;
    boolean drawFree = false;
    boolean filled = false;
    boolean dotted = false;
    boolean eraser = false;

    int x1, y1, x2, y2, color;
    private Shape shape;
    ArrayList<Shape> shapes;

    public MyPanel() {

        this.setBackground(Color.white);
        this.setFocusable(true);
        shapes = new ArrayList<>();
        shape = null;

        JButton line = new JButton("Line");
        JButton rectangle = new JButton("Rectangle");
        JButton oval = new JButton("Oval");
        JButton pen = new JButton("Pen");
        JButton red = new JButton();
        JButton green = new JButton();
        JButton blue = new JButton();
        JButton black = new JButton();
        JButton clearAll = new JButton("Clear");
        JButton erase = new JButton("Eraser");
        JButton undo = new JButton("Undo");
        JCheckBox checkDott = new JCheckBox("Dotted", dotted);
        JCheckBox checkFill = new JCheckBox("Filled", filled);
        
        
        
        Dimension buttonSize = new Dimension(50, 25);
        black.setPreferredSize(buttonSize);
        blue.setPreferredSize(buttonSize);
        green.setPreferredSize(buttonSize);
        red.setPreferredSize(buttonSize);
        
        red.setBackground(Color.RED);
        green.setBackground(Color.GREEN);
        blue.setBackground(Color.BLUE);
        black.setBackground(Color.BLACK);

        
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawLine = true;
                drawRect = false;
                drawOval = false;
                drawFree = false;
                 eraser = false;
            }
        });
        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawRect = true;
                drawLine = false;
                drawOval = false;
                drawFree = false;
                 eraser = false;
            }
        });
        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawOval = true;
                drawRect = false;
                drawLine = false;
                drawFree = false;
                 eraser = false;
            }
        });
        pen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawFree = true;
                drawOval = false;
                drawRect = false;
                drawLine = false;
                eraser = false;
            }
        });
        
          erase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraser = true;
                drawLine = false;
                drawRect = false;
                drawOval = false;
                drawFree = false;
            }
        });

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = 1;
            }
        });
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = 2;
            }
        });
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = 3;
            }
        });
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = 5;
            }
        });
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapes.clear(); 
                updateUI();
            }
        });
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!shapes.isEmpty())
                {
                    shapes.remove(shapes.size() - 1);
                }
                updateUI();
            }
        });
        checkFill.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                filled = checkFill.isSelected();
            }
        });
        checkDott.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                dotted = checkDott.isSelected();
            }
        });
      
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                if (drawLine) {
                    shape = new DrawLine(color, x1, y1, x1, y1, filled, dotted);
                }
                if (drawRect) {
                    shape = new DrawRect(color, x1, y1, x1, y1, filled, dotted);
                }
                if (drawOval) {
                    shape = new DrawOval(color, x1, y1, x1, y1, filled, dotted);
                }
                if (drawFree) {
                    shape = new Pen(color, x1, y1, x1, y1, filled, dotted);
                }
                if (eraser) {
                    shape = new Erase(x1, y1, x1, y1);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                shape.setendX(x2);
                shape.setendY(y2);
                shapes.add(shape);
                shape = null;
                updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                shape.setendX(x2);
                shape.setendY(y2);
                updateUI();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });
        
        this.add(line);
        this.add(rectangle);
        this.add(oval);
        this.add(pen);
        this.add(red);
        this.add(green);
        this.add(blue);
        this.add(black);
        this.add(clearAll);
        this.add(erase);
        this.add(undo);
        this.add(checkDott);
        this.add(checkFill);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape index : shapes) {
            index.draw(g);
        }
        if (shape != null) {
            shape.draw(g);
        }
    }

}
