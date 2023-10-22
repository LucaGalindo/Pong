/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alumno
 */
public class Cubo {
   
    private final int ancho=100,alto=20; 
   public int x,y;
    public Cubo (int x,int y){
   this.x=x;
   this.y=y;
   }
   
    public Rectangle2D getCubo(){
        
   return new Rectangle2D.Double(x, y, ancho, alto);
    }
    
    

    
    public void quitar(){          
        x=100;

    }
    
}
