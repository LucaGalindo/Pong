/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.JPanel;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tablero extends JPanel{
    Pelota pelota= new Pelota(0,400);
    Raqueta r1= new Raqueta(300,700);
    public Tablero(){ 
        setBackground(BLACK);
        
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2= (Graphics2D) g;
 
    g2.setColor(Color.RED);  
    gameover(g2);
    g2.setColor(Color.WHITE);
    vidas(g2);
    dibujar(g2);
    actualizar();
    }
    
    public void dibujar(Graphics2D g){
   
    g.fill(pelota.getPelota());
    g.fill(r1.getRaqueta());  
    }
    
    public void gameover(Graphics2D g){
    if(pelota.perder()==true){
    
     Font vida= new Font("Arial",Font.BOLD,30);
     g.setFont(vida);
     g.drawString("GAME OVER",250,400);
    }
    
    }
    public void vidas(Graphics2D g){
     Font vida= new Font("Arial",Font.BOLD,20);
     g.setFont(vida);
     g.drawString("Vidas="+Integer.toString(pelota.vidas),300,20);
     
    }
    
    
    public void actualizar(){
    pelota.mover(getBounds(),colision(r1.getRaqueta()));
    r1.moverR1(getBounds());
    
    }
    

 private boolean colision(Rectangle2D r){
  return pelota.getPelota().intersects(r);
  }    
}

