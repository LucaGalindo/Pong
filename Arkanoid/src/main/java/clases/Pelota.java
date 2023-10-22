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
    public int x;
    public int y=300;
    private final int ancho=15,alto=15;
    public int dx=1,dy=1;
    public int vidas=3;
    public int puntos=0;
    public int record;
   public boolean confirm;
    private int cooldownx=0;
    private int cooldowny=0;
    
    Random rand = new Random();
    
    public Pelota(int y,int x){
    this.x=x;
    this.y=y;
    
    }
    
    public Rectangle2D getPelota(){
    return new Rectangle2D.Double(x,y,ancho,alto);
    
    }
    
    public void mover(Rectangle limites, boolean colisionR1){
    
    x+=dx;
    y+=dy;
   
    
    if(colisionR1){
    dy=-dy;
    y=685;
    
   
    if(dx>0 && x<limites.getMaxX()-10){
    x+=10;
    }else{
    if(x>10){
    x-=10;
    }    
    
    }
    
    if(puntos==700){
    velocidad=2;
    }
    
    if(puntos==14000){
    velocidad=1;
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
        
        y=300;
 
        vidas--;
    } 
    if(perder()==true){
        dx=0;
        dy=0;
    }
    
    }
  
   public void cuboimpact(int xcubo,int ycubo){
    
       
       if(x>xcubo+90 || x<xcubo){
        dx=-dx;
        
       }else{
         
     
       if(y>ycubo+10 || y<ycubo){
       dy=-dy;
       }
       
       }
       
      puntos+=100;
       
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
public void pelotap2(Rectangle limites){
 if(cooldownx>0){
   cooldownx--;
}
if(cooldowny>0){
   cooldowny--;
}
  
if(EventoTeclado.p2x==true && x<limites.getMaxX()-15 && x>0 && cooldownx==0){
dx=-dx;
cooldownx=20;

}

if(EventoTeclado.p2y==true && y<limites.getMaxY()-15 && y>0 && cooldowny==0){
dy=-dy;
cooldowny=20;
}

}
    public void reiniciar(){
    if(EventoTeclado.yes==true){
    puntos=0;
    vidas=3;
    velocidad=3;
    y=300;
    dx=1;
    dy=1;
  
    }
  
    } 

}
    

  
