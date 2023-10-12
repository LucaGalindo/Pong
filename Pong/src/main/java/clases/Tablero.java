/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import static clases.Hilo.velocidad;
import javax.swing.JPanel;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


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
     g2.setColor(Color.ORANGE);
    nuevorecord(g2);
    g2.setColor(Color.WHITE);
    texto(g2);
    g2.setColor(Color.WHITE);
    dibujarpelota(g2);
    
    if(pelota.vidas==3){
    g2.setColor(Color.GREEN);
    }
    if(pelota.vidas==2){
    g2.setColor(Color.YELLOW);
    }
    if(pelota.vidas==1){
     g2.setColor(Color.RED); 
    }
    vidas(g2);
    
    g2.setColor(Color.GRAY); 
    dibujarraqueta(g2);
    
    actualizar();
    pelota.reiniciar();

    if(EventoTeclado.no==true){
    
    }
    
    }
    
    public void dibujarpelota(Graphics2D g){
    g.fill(pelota.getPelota());
   
    }
    public void dibujarraqueta(Graphics2D g){
     g.fill(r1.getRaqueta());
    }
    public void gameover(Graphics2D g){
    if(pelota.perder()==true){
    
     Font vida= new Font("Arial",Font.BOLD,30);
     g.setFont(vida);
     g.drawString("GAME OVER",200,400);
     
    }
    
    }
    public void texto(Graphics2D g){
     Font vida= new Font("Arial",Font.BOLD,20);
     g.setFont(vida);
   
     g.drawString("Puntos="+Integer.toString(pelota.puntos),0,20);
     g.drawString("Record="+Integer.toString(pelota.record),0,40);
    
     if(pelota.perder()==true){
     g.drawString("Quiere reiniciar?",220,430);
     g.drawString("Pulse Y",260,450);
     
    }
    }
    public void vidas(Graphics2D g){
     Font vida= new Font("Arial",Font.BOLD,20);
     g.setFont(vida);  
     g.drawString("Vidas="+Integer.toString(pelota.vidas),250,20);
    }
    
    public void nuevorecord(Graphics2D g){
     Font vida= new Font("Arial",Font.BOLD,20);
     g.setFont(vida);
     if(pelota.puntos>pelota.record ){
     g.drawString("¡Nuevo record!",0,60);
     }
    
    
    
    }
    
    public void actualizar(){
    pelota.mover(getBounds(),colision(r1.getRaqueta()));
    r1.moverR1(getBounds());
    
    }
    

    

 private boolean colision(Rectangle2D r){
   
  return pelota.getPelota().intersects(r);
  }
 
}

