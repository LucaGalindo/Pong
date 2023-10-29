/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Alumno
 */
public class Pelota {
    public double x;
    public double y;

    private final int ancho=15,alto=15;
    public double dx=0,dy=0; 
    

    
    public Pelota(int y,int x){
  
    this.x=x;
    this.y=y;
    
    }
    
    public Rectangle2D getPelota(){
    return new Rectangle2D.Double(x,y,ancho,alto);
    
    }
    
    public void mover(Rectangle limites){
  //movimiento 
    x+=dx;
    y+=dy;
 
    
    //"friccion"
    
   if(dx>=0.01){
   dx=dx-0.01;
   }
   
   if(dx<=-0.01){
   dx+=0.01;
   }
   
 if(dy>=0.01){
   dy-=0.01;
   }
 
 if(dy<=-0.01){
   dy+=0.01;
   }
     
    //Colisiones con bordes
    if(x<limites.getMaxX()){
        dx=-dx;
    }  
    if(y<limites.getMaxY()){
        dy=-dy;
    }
    
    if(x>0){
        dx=-dx;
    }
     if(y>0){
        dy=-dy;
    }

   
 if(Math.round(dx)==0 && Math.round(dy)==0){
    dx=0;
    dy=0;
 }
   
    
    }
    
    public void tirar(){
    
            // Ingreso de potencia y direccion
    
    if(EventoTeclado.der==true && EventoTeclado.go==false && dx<4){
    dx+=1.0;  
    EventoTeclado.der=false;
      System.out.println("dx: "+dx+" dy: "+dy);
    }
    
    if(EventoTeclado.iz==true && EventoTeclado.go==false && dx>-4){
    dx-=1.0;       
    EventoTeclado.iz=false;
       System.out.println("dx: "+dx+" dy: "+dy);
    }
    
    if(EventoTeclado.up==true && EventoTeclado.go==false && dy>-4){
   dy-=1.0;
    EventoTeclado.up=false;
      System.out.println("dx: "+dx+" dy: "+dy);
    }
    
    if(EventoTeclado.down==true && EventoTeclado.go==false && dy<4){
    dy+=1.0;
    EventoTeclado.down=false;
       System.out.println("dx: "+dx+" dy: "+dy);
    }
    
    
    }
    
    public boolean mueve(){
    boolean mueve=true;
    
    if(Math.round(dx)==0 && Math.round(dy)==0){
        
    mueve=false;
    System.out.println("Movre: dx "+dx+"dy "+dy);
    dx=0;
    dy=0;
    
    }
    
  
    
    return mueve;
    }


    
 


}
    

  
