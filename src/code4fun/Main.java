/*
**By Safwah Bakri
**
*/
package code4fun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
        
public class Main extends JPanel{

    int x;
    int y;
    int r=10;
    
    int vx=1;
    int vy=1;
    
    int minx=0;
    int miny=0;
    int maxx=174;
    int maxy=151;
    
    int Red = (int)Math.floor(Math.random() * 256);
    int Green = (int)Math.floor(Math.random()*256);
    int Blue = (int)Math.floor(Math.random()*256);
    
    static int mouseX;
    static int mouseY;
    
    ArrayList<Ball> ball = new ArrayList<Ball>();
    
    ArrayList List = new ArrayList();
    
    @Override
    public void paint(Graphics g){
        Graphics2D pretty = (Graphics2D) g;

        
        super.paint(g);
        pretty.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //makes the circle borders appear smoother
        for (int i=0; i<ball.size();i++){
            pretty.setColor(ball.get(i).getColor());
            pretty.drawOval(ball.get(i).getxPos(),ball.get(i).getyPos(),r,r);
            pretty.fillOval(ball.get(i).getxPos(),ball.get(i).getyPos(),r,r);
        }
        
        
    }
    
    public void update(){
        for (int i=0;i<ball.size();i++){
            for (int j=0; j<ball.size();j++){
                if (i==j){
                }
                else{
                    int radii;
                    int distanceA;
                    int distanceB;
                    distanceA = ((ball.get(i).getxPos()+5)-(ball.get(j).getxPos()+5))*((ball.get(i).getxPos()+5)-(ball.get(j).getxPos()+5));
                    distanceB = (((ball.get(i).getyPos()+5)-(ball.get(j).getyPos()+5)))*(((ball.get(i).getyPos()+5)-(ball.get(j).getyPos()+5)));
                    radii = (int) Math.sqrt(((distanceA)+(distanceB)));
                    if (radii<=r){
                        ball.get(i).reverseX();
                        ball.get(j).reverseX(); 
                    }
                }
            }
            ball.get(i).Collision();
        }
    }

    public static void main(String[] args)  throws InterruptedException{
        Main Game = new Main();
        
        JFrame frame = new JFrame("Code4Fun");

        frame.add(Game);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { 
                Game.ball.add(new Ball(e.getX()-5,e.getY()-5));
            }
        });
            Game.ball.add(new Ball(50,50));
            Game.ball.add(new Ball(100,100));
        while (true){
            Game.update();
            Game.repaint();
            Thread.sleep(10);
        }
    }
    
}
