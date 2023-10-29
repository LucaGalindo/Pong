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

static boolean der,iz,up,down,go;
static boolean esc,r=false; 
        
    public void keyPressed(KeyEvent e){
    int id=e.getKeyCode();
    
    
    if(id==KeyEvent.VK_LEFT){
    iz=true;

    }
    
     if(id==KeyEvent.VK_RIGHT){
    der=true;

    }
 
    if(id==KeyEvent.VK_UP){
    up=true;

    }
     
   if(id==KeyEvent.VK_DOWN){
    down=true;
    

    }
   
    if(id==KeyEvent.VK_SPACE){
    go=true;
    
    } 
   
    if(id==KeyEvent.VK_ESCAPE){
   
        esc=!esc;
        
    }
    
     if(id==KeyEvent.VK_R){
   
        r=true;
        
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
    
    if(id==KeyEvent.VK_UP){
    up=false;
    }
     
   if(id==KeyEvent.VK_DOWN){
    down=false;
    }
   
  /* if(id==KeyEvent.VK_SPACE){
    go=false;
    } 
 */
   
  }
    
}