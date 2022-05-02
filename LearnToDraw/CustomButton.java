
//https://github.com/kdeloach/labs/blob/master/java/yahtzee/src/Dice.java

/**
 * Write a description of class CustomButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Cursor;


public class CustomButton extends JComponent implements MouseListener
{

    private int width;
    private int height;

    /**
     * Constructor for objects of class CustomButton
     */
    public CustomButton(int width, int height)
    {
        super();
        enableInputMethods(true);
        addMouseListener(this);

        this.width = width;
        this.height = height;
    }
    
    /**
     * 
     * overriding MouseListener methods
     * 
     */
    public void mouseClicked(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        mouseEntered = true;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public void mouseExited(MouseEvent e){
        mouseEntered = false;
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * 
     * overriding JComponent methods
     * 
     */
    public Dimension getPreferredSize(){
        return new Dimension(width, height);
    }

    public Dimension getMinimumSize(){
        return getPreferredSize();
    }

    public Dimension getMaximumSize(){
        return getPreferredSize();
    }


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
