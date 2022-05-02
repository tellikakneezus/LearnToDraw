import java.util.ArrayList;

import java.awt.BorderLayout;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Point;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


import javax.swing.JPanel;
public class TrivialSketcher extends JPanel {
    /**
     * Keeps track of the last point to draw the next line from.
     */
    private Point firstPoint;
    private Point secondPoint;
    private CurrentShape cs;

    private boolean preview;
    private boolean moveObject;

    private ArrayList<ShapeComponent> shapeComps;

    /**
     * Constructs a panel, registering listeners for the mouse.
     */
    public TrivialSketcher() {
        
        init();
    }

    private void init(){
        shapeComps = new ArrayList<ShapeComponent>();
        preview = true;
        moveObject = false;

        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    firstPoint = new Point(e.getX(), e.getY());

                }

                public void mouseReleased(MouseEvent e){
                    secondPoint = new Point(e.getX(), e.getY());
                    preview = false;

                    switch(cs.getCurrentShape()){
                        case RECTANGLE:
                        shapeComps.add(new ShapeComponent(new Rectangle2D.Double(Math.min(secondPoint.x,firstPoint.x), Math.min(secondPoint.y,firstPoint.y), Math.abs(secondPoint.x - firstPoint.x), Math.abs(secondPoint.y - firstPoint.y))));
                        //g.fillRect(Math.min(secondPoint.x,firstPoint.x), Math.min(secondPoint.y,firstPoint.y), Math.abs(secondPoint.x - firstPoint.x), Math.abs(secondPoint.y - firstPoint.y));
                        break;
                        case LINE:
                        //g.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
                        break;
                        case CIRCLE:
                        //drawCenteredCircle(g, firstPoint.x, firstPoint.y, distanceBtwPoints(firstPoint, secondPoint) * 2);
                        break;

                    }
                    repaint();
                }
            });

        addMouseMotionListener(new MouseAdapter(){
                public void mouseDragged(MouseEvent e){
                    secondPoint = new Point(e.getX(),e.getY());
                    repaint();
                } 
            });
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(secondPoint != null){
            if(preview){
                switch(cs.getCurrentShape()){
                    case RECTANGLE:
                    g.drawRect(Math.min(secondPoint.x,firstPoint.x), Math.min(secondPoint.y,firstPoint.y), Math.abs(secondPoint.x - firstPoint.x), Math.abs(secondPoint.y - firstPoint.y));
                    break;
                    case LINE:
                    g.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
                    break;
                    case CIRCLE:
                    drawCenteredCircle(g, firstPoint.x, firstPoint.y, distanceBtwPoints(firstPoint, secondPoint) * 2);
                    break;

                }
            }else{
                for(ShapeComponent shape: shapeComps){
                    shape.paintComponent(g);
                }
                preview = true;
            }
        }

    }

    public void drawCenteredCircle(Graphics g, int x, int y, int diameter) {

        x = x-(diameter/2);
        y = y-(diameter/2);
        if(preview){
            g.drawOval(x,y,diameter,diameter);
        }else{
            g.fillOval(x,y,diameter,diameter);
        }
    }

    public int distanceBtwPoints(Point firstPoint, Point secondPoint){
        int distance = (int)Math.sqrt(((secondPoint.x - firstPoint.x)*(secondPoint.x - firstPoint.x)) + ((secondPoint.y - firstPoint.y)*(secondPoint.y - firstPoint.y)));
        return distance;
    }

}

// 
//     private void drawShape(){
//         Graphics g = getGraphics();
// 
//         switch(cs.getCurrentShape()){
//             case RECTANGLE:
//             g.fillRect(Math.min(secondPoint.x,firstPoint.x), Math.min(secondPoint.y,firstPoint.y), Math.abs(secondPoint.x - firstPoint.x), Math.abs(secondPoint.y - firstPoint.y));
//             break;
//             case LINE:
//             g.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
//             break;
//             case CIRCLE:
//             drawCenteredCircle(g, firstPoint.x, firstPoint.y, distanceBtwPoints(firstPoint, secondPoint) * 2);
//             break;
// 
//         }
// 
//     }
// 
//     public void drawPreviewShape(){
//         Graphics g = getGraphics();
// 
//         switch(cs.getCurrentShape()){
//             case RECTANGLE:
//             g.drawRect(Math.min(secondPoint.x,firstPoint.x), Math.min(secondPoint.y,firstPoint.y), Math.abs(secondPoint.x - firstPoint.x), Math.abs(secondPoint.y - firstPoint.y));
//             break;
//             case LINE:
//             g.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
//             break;
//             case CIRCLE:
//             drawCenteredCircle(g, firstPoint.x, firstPoint.y, distanceBtwPoints(firstPoint, secondPoint) * 2);
//             break;
// 
//         }
//     }
