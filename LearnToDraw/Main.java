
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class Main extends JFrame
{
        
    static CurrentShape cs = new CurrentShape();
    
    public static void main(String[] args) {
        
        cs.setCurrentShape(ShapeState.CIRCLE);
        
        JFrame frame = new JFrame("Simple Sketching Program");
        frame.add(new TrivialSketcher());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
