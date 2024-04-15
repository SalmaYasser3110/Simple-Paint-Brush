/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

import javax.swing.JFrame;

/**
 *
 * @author SALMA
 */
public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Paint Brush Project");
        f.setSize(800, 800);

        MyPanel p = new MyPanel();
        f.setContentPane(p);
        f.setVisible(true);

    }
}
