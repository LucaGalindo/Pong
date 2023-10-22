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


public class Tablero extends JPanel{
    Pelota pelota= new Pelota(300,400);
    Raqueta r1= new Raqueta(300,700);
    Cubo[][] filas=new Cubo[3][6];
    int nivel=1;
  public  boolean inicio=false; 
  public  boolean con1=false,con2=false;
  public  boolean ganar=false;
    
    int prim=0;
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
    if(ganar==true){
    g2.setColor(Color.YELLOW);
    gano(g2);
    }
    
    if(inicio==false){
    llenarbloques(false);
    }
    inicio=true;
   g2.setColor(Color.WHITE);  
    dibujarcubos(g2);
    
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
     cambionivel();
    
     pelota.reiniciar();
     
if(EventoTeclado.yes==true){
    inicio=false;
    nivel=1;
    ganar=false;
    con1=false;
    con2=false;
    }

    if(EventoTeclado.no==true){
    
    }
    
    }
    
    public void dibujarpelota(Graphics2D g){
    g.fill(pelota.getPelota());
   
    }
    public void dibujarraqueta(Graphics2D g){
     g.fill(r1.getRaqueta());
  
    }
    
    public void dibujarcubos(Graphics2D g){

        for(int n=0;n<nivel;n++){
            
            for(int i=0;i<5;i++){
       
        g.fill(filas[n][i].getCubo());
          
        }
        
    }
      
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
    
     if(pelota.perder()==true || ganar==true){
     g.drawString("Quiere reiniciar?",220,430);
     g.drawString("Pulse Y",260,450);
     
    }
    }
    
    public void gano(Graphics2D g){
     Font vida= new Font("Arial",Font.BOLD,30);
     g.setFont(vida);
     
     g.drawString("Ganaste",240,400);
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
    pelota.pelotap2(getBounds());
    
     for(int n=0;n<nivel;n++){
         
        for(int i=0;i<5;i++){
         
            if(colision(filas[n][i].getCubo())==true){

            pelota.cuboimpact(filas[n][i].x,filas[n][i].y);
            
            filas[n][i].x=900;
            

            } 
        }
     }
  

    
    }
    
private void llenarbloques(boolean roto){
    int acum=0;
    int acumy=70;
    
    
    for(int n=0;n<nivel;n++){
        for(int i=0;i<5;i++){
       if(roto==true){
      
         }  
    filas[n][i]= new Cubo(acum,acumy);
       
        
         acum+=125;

         }
        
        acumy+=30;
        acum=0;
    }
    
}

private void cambionivel(){
    boolean nive2=false;
    boolean nive3=false;
    
    
 switch(pelota.puntos){

                    case 500:
                    nivel=2;
                    nive2=true;
                    
                    inicio=false;
                    break;

                    case 1500:
                    nivel=3;
                    nive3=true;
                    inicio=false;
                    break;
                    case 3000:
                        ganar=true;
                    break;    
                }
 
 if(nive2==true && con1==false){
    pelota.dy=1;
    pelota.y=300;
    pelota.x=400;
    con1=true;
    
 }
  if(nive3==true && con2==false){
    pelota.dy=1;
    pelota.y=300;
    pelota.x=400;
    con2=true;
 }
 if(ganar==true){
    pelota.dy=1;
    pelota.y=300;
    pelota.x=400;
 }              
                 
}

private boolean colision(Rectangle2D r){
   
  return pelota.getPelota().intersects(r);
  }
 
}

