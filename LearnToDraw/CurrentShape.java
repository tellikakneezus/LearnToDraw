
/**
 * Write a description of class ShapeState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CurrentShape
{
    // instance variables - replace the example below with your own
    private ShapeState cs = ShapeState.RECTANGLE;

    public void setCurrentShape (ShapeState cs){
        this.cs = cs;
    }
    
    public ShapeState getCurrentShape(){
        return cs;
    }
}
