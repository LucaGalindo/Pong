/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Luca
 */
public class Raqueta {
   private int x,y;
   private final int ancho=100,alto=10; 
   
   public Raqueta(int x,int y){
   this.x=x;
   this.y=y;
   }
   
   
   public Rectangle2D getRaqueta(){
   return new Rectangle2D.Double(x, y, ancho, alto);
   }
   
   public void moverR1(Rectangle limites){
   if(EventoTeclado.der==true && x<600){
   x++;
   }
   
   if(EventoTeclado.iz==true && x>0){
   x--;
   }
   
  }
   
}
