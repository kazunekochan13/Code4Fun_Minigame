/*
**By Safwah Bakri
**
*/
package code4fun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class Ball  {
    
    int x=50;
    int y=50;
    int vx=1;
    int vy=1;
    int minx=0;
    int miny=40;
    int maxx=578;
    int maxy=557;
    
    int Red = (int)Math.floor(Math.random() * 256);
    int Green = (int)Math.floor(Math.random()*256);
    int Blue = (int)Math.floor(Math.random()*256);
    Color rainbow = new Color(Red, Green, Blue);
    
    public Ball(int xPos, int yPos){ //constructor
        x=xPos;
        y=yPos;
    }
    
    public int getyPos(){
        return y;
    }
    
    public int getxPos(){
        return x;
    }
    
    public Color getColor(){
        return rainbow;
    }
     public void reverseX(){
         vx=-vx;
     }
    public void Collision(){
        if (x<minx) {
            vx=-vx;
        }
        if (x>maxx){
            vx=-vx;
        }
        if (y<miny) {
            vy=-vy;
        }
        if (y>maxy){
            vy=-vy;
        }
        x=x+vx;
        y=y+vy;
    }
    
}
