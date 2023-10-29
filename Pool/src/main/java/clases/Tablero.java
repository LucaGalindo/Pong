/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.JPanel;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public class Tablero extends JPanel{
    Pelota pelota= new Pelota(350,400);
    Color Verde = new Color(14, 136, 0); 
    Pelota npelota =new Pelota(430,400);
    int choque=0;

    Font fuente= new Font("Arial",Font.BOLD,30);
    
    public Tablero(){ 
        setBackground(Verde);
        
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){
        
    super.paintComponent(g);
    Graphics2D g2= (Graphics2D) g;
    g2.setColor(WHITE);
    reiniciar();
    if(EventoTeclado.esc==false){
    instrucciones(g2);
    }
    
    if(EventoTeclado.esc==true){
        
    dibujar(g2);
    actualizar();
    escribir(g2);
    }
    }
    
    public void dibujar(Graphics2D g){
   
    g.fill(pelota.getPelota());
    g.setColor(BLACK);  
    g.fill(npelota.getPelota());
    g.setColor(WHITE);
    
    }
    
    public void escribir(Graphics2D g){
    g.setFont(fuente);
    g.drawString("Potencia X:"+Math.round(pelota.dx),50,40);
    g.drawString("Potencia Y:"+Math.round(pelota.dy),50,80);
    g.drawString("Choques:"+choque,600,40);
        
    }
    
    public void instrucciones(Graphics2D g){
     g.setFont(fuente);
     g.drawString("Instrucciones",300,40);
     g.drawString("Movimiento:",20,100);
     g.drawString("-Usa las flechas del teclado para calibrar la potencia",20,140);
     g.drawString("-Usa ← o → para modificar la potencia en el eje X",20,180);
     g.drawString("-Usa ↑ o ↓ para modificar la potencia en el eje Y",20,220);
     g.drawString("-Si la potencia es positiva se movera:",20,270);  
     g.drawString("Para abajo si es en el eje Y, o la derecha en el eje X",20,310);
     g.drawString("-En caso de ser negativa se movera:",20,360);
     g.drawString("Para arriba si es en el eje Y, o la izquierda en el eje X",20,400);
     g.drawString("-Una vez calibrado presiona espacio para tirar",20,450);
     g.drawString("-Presiona R para reiniciar",20,490);
     g.drawString("-Puedes volver a esta pestaña presionando esc",20,540);
     g.drawString("*Preciona esc para comenzar*",200,700);
    }
    
    public void actualizar(){
        
    pelota.tirar();
    
    if(EventoTeclado.go==true){
   
    pelota.mover(getBounds());
    
   
        
    rebote(colision(npelota.getPelota()));
    
    
 
    npelota.mover(getBounds());
    
    if(colision(npelota.getPelota())==true){
    npelota.dx=0;
    npelota.dy=0;
    }
 
     if(pelota.mueve()==false && npelota.mueve()==false){      
    EventoTeclado.go=false;
    }
       
    }
    
    

    }
    
    


 private boolean colision(Rectangle2D r){
   
  return pelota.getPelota().intersects(r);
  
 }    
 
 public void rebote(boolean colision){
    
    if(colision==true){
        choque++;
 

    
       
       pelota.dx=pelota.dx*0.5;
       pelota.dy=pelota.dy*0.5;
       
       npelota.dx=pelota.dx*1.5;
       npelota.dy=pelota.dy*1.5;
       
       pelota.dx=-pelota.dx;
       pelota.dy=-pelota.dy;
       
       
       if(pelota.dx<0){
       npelota.x+=2;
       }
       if(pelota.dx>0){
        npelota.x-=2;
       }
       
      if(pelota.dy<0){
       npelota.y+=2;
       }
       if(pelota.dy>0){
        npelota.y-=2;
       }
   
   }
   
     }
    
 public void reiniciar(){
     if( EventoTeclado.r==true){
 pelota.dx=0;
 pelota.dy=0;
 npelota.dx=0;
 npelota.dy=0;
 
 pelota.x=400;
 pelota.y=350;
 
 npelota.x=400;
 npelota.y=430;
 
 choque=0;
 EventoTeclado.r=false;
     }
 }

}


