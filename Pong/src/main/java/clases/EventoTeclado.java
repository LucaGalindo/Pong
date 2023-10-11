/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.awt.event.*;

/**
 *
 * @author Luca
 */
public class EventoTeclado extends KeyAdapter{

static boolean der,iz;

    public void keyPressed(KeyEvent e){
    int id=e.getKeyCode();
    if(id==KeyEvent.VK_LEFT){
    iz=true;
    }
    
     if(id==KeyEvent.VK_RIGHT){
    der=true;
    }
 
    }
    
    public void keyReleased(KeyEvent e){
    int id=e.getKeyCode();
    
    if(id==KeyEvent.VK_LEFT){
     iz=false;
    }
    
    if(id==KeyEvent.VK_RIGHT){
     der=false;
    }
 
  }
    
}