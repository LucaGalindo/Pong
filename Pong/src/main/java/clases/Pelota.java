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
    private int x;
    private int y;
    private final int ancho=15,alto=15;
    private int dx=1,dy=1;
    public int vidas=3;
    
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
     
    if(y==760){
        y=50;
        x=350;
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
    }
     
    return perdio;
 } 

}
    

  
