/* BasicFrame.java

  This is a really simple graphics program.
  It opens a frame on the screen with a single
  line drawn across it.

  It's not very polished, but it demonstrates
  a graphical program as simply as possible.mag-27Apr2008
*/

// Import the basic graphics classes.
import java.awt.*;
import javax.swing.*;

public class BasicFrame extends JFrame{

  // Create a constructor method
  public BasicFrame(){
    // All we do is call JFrame's constructor.
    // We don't need anything special for this
    // program.
    super();
  }

  // The following methods are instance methods.
  /* Create a paint() method to override the one in JFrame.
     This is where the drawing happens. 
     We don't have to call it in our program, it gets called
     automatically whenever the frame needs to be redrawn,
     like when it it made visible or moved or whatever.*/
  public void paint(Graphics g){
    g.drawLine(10,10,150,150); // Draw a line from (10,10) to (150,150)
  }

  public static void main(String arg[]){
    // create an identifier named 'window' and
    // apply it to a new BasicFrame object
    // created using our constructor, above.
    BasicFrame frame = new BasicFrame();

    // Use the setSize method that our BasicFrame
    // object inherited to make the frame
    // 200 pixels wide and high.
    frame.setSize(200,200);

    // Make the window show on the screen.
    frame.setVisible(true);
  }
}

This example draws a line on the JFrame. The window decorations take up some of our drawing space, so the title bar may cover some of our line. With some JVMs the background area of the JFrame won't be cleared before you draw. Also, when you close the window using the close button, the application doesn't shut down. For many applications on Mac OS X this is normal behavior, but on other OSes, and even many applications under OS X it's normal to expect an application to close down completely if you click the close button on the last open window (for applications that have multiple windows) or the close button on the main window for other applications.

So here's our next example, where we take care of that last problem:
/* CloseFrame.java
  This is a really simple graphics program.
  It opens a frame on the screen with a single
  line drawn across it.

  We're starting to add a little bit of polish
  here--we make the program close nicely when
  the close box is clicked, rather than just
  sort of hanging around half-dead.
  mag-28Apr2008
*/

// Import the basic graphics classes.
import java.awt.*;
import javax.swing.*;

public class CloseFrame extends JFrame{

  // Create a constructor method
  public CloseFrame(){
    // All we do is call JFrame's constructor.
    // We don't need anything special for this.
    super();
  }

  // The following methods are instance methods.

  /* Create a paint() method to override the one in JFrame.
     This is where the drawing happens.
     We don't have to call it in our program, 
     it gets called automatically whenever the 
     frame needs to be redrawn, like when it is 
     made visible or moved or whatever.
  */
  public void paint(Graphics g){
    g.drawLine(10,10,150,150); // Draw a line from (10,10) to (150,150)
  }

  public static void main(String arg[]){
    BasicFrame frame = new BasicFrame();
    // This uses a constant EXIT_ON_CLOSE that's a member of JFrame.
    // The constant is passed to the setDefaultCloseOperation method
    // of our frame object, which is a CloseFrame object,
    // which inherits the method from its parent JFrame.
    // It makes the program exit (close completely) when we click
    // the close button.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);frame.setVisible(true);
  }
}
