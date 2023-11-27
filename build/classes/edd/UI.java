/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomasaraujo
 */
public class UI extends JPanel {
    
    ArrayList<Documento> array;
    HashMap<String, Integer> prioridades;
    
    public UI(ArrayList<Documento> array){
        this.array=array;
        this.setVisible(true);
       
    }
    public UI(HashMap<String, Integer> prioridades){
        this.prioridades =prioridades;
        this.setVisible(true);
       
    }



    public UI() {
    }

    
//    public int drawTree(Graphics g, Documento x, int x0, int x1, int y, ArrayList<Documento> array, int index){
    public int drawTree(Graphics g, Documento x, int x0, int x1, int y, HashMap<String, Integer> prioridad, int index){
        
        

        int m = (x0 + x1) / 2;
        g.setColor(Color.RED);
        g.fillOval(m, y, 50, 40);
        g.setColor(Color.lightGray);
        g.setFont(new Font("Arial",Font.BOLD,20));
        String t = String.valueOf(x.tipo);
        g.drawString(t, m+20, y+30);
        
        
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        
        
        if (leftChild < array.size()  ){
            int x2 = drawTree(g, array.get(leftChild),x0,m,y+50, prioridad, leftChild);
            g.drawLine(m+25, y+40, x2+25, y+50);
        }
        if (rightChild  < array.size() ) {
           int x2 = drawTree(g, array.get(rightChild),m,x1,y+50, prioridad, rightChild);

            g.drawLine(m+25, y+40, x2+25, y + 50);
        }
        return m;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawTree(g, array.get(0), 0, this.getWidth()-25, 100, prioridades, 0);
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
    }
}