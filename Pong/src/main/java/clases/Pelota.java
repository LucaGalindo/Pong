/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import static clases.Hilo.velocidad;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 *
 * @author Alumno
 */
public class Pelota {
    private int x;
    private int y;
    private final int ancho=15,alto=15;
    public int dx=1,dy=1;
    public int vidas=3;
    public int puntos=0;
    public int record;
   
    
    Random rand = new Random();
    
    public Pelota(int y,int x){
    this.x=x;
    this.y=y;
    
    }
    
    public Rectangle2D getPelota(){
    return new Rectangle2D.Double(x,y,ancho,alto);
    
    }
    
    public void mover(Rectangle limites,boolean colisionR1){
    x+=dx;
    y+=dy;
   
    
    if(colisionR1){
    dy=-dy;
    y=685;
    puntos++;
   
    if(dx>0 && x<limites.getMaxX()-10){
    x+=10;
    }else{
    if(x>10){
    x-=10;
    }    
    
    }
    
    if(puntos==10){
    velocidad=2;
    }
    
    if(puntos==20){
    velocidad=1;
    }
    if(puntos==30 || puntos==40 || puntos==50){
    if(dx==1){
    dx++;
    }else{
    dx--;
    }
    dy--;
    }
    
    
    }
  
   
    
    //llega al borde derecho  
    if(x<limites.getMaxX()){
        dx=-dx;
        
    }
    
    if(y<limites.getMaxY()){
        dy=-dy;
    }
    //Llega al borde izquierdo
    if(x>0){
        dx=-dx;
        
    }
     if(y>0){
        dy=-dy;
        
    }
    //pelota pasa 
    if(y>760){
        do{
        x=rand.nextInt((int)limites.getMaxX()-20);
        }while(x<15);
        
        y=50;
 
        vidas--;
    } 
    if(perder()==true){
        dx=0;
        dy=0;
    }
    
    }
 public boolean perder(){
    
    boolean perdio=false;
    
    if(vidas==0){
    perdio=true;
    if(record<puntos){
    record=puntos;
    }
  
    
    }
     
    return perdio;
 }

    public void reiniciar(){
    if(EventoTeclado.yes==true){
    puntos=0;
    vidas=3;
    velocidad=3;
    y=50;
    dx=1;
    dy=1;
    }
  
    } 

}
    

  
