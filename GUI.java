//Notes to self, we need to change jframe, jpanel, etc to private classes
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class GUI{

    //protected JButton n;
    protected Container contentPane;
    //  protected int actioncounter;

    //Actual Game buttons
    //protected JButton upgrades,quit;
    //protected JProgressBar infectionRate, lethality, visibility;
    // protected JTextArea notifications;
    //protected JTextArea plz, instructions;

    protected MyFrame frame;
    public class MyFrame extends JFrame{
	public MyFrame(){
	    setTitle("Title Name");
	    setSize(400,300); //default size is 0,0
	    setLocation(10,200); // default location is top left corner
	    
	    //Window Listeners (used to actually close a window)
	    addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
		});
	}
	
    }
    public class MyPanel extends JPanel{
	public void paintChildren(Graphics g){
	    
	}
    }
    public GUI(){
	Graphics z= new Graphics();
	
	z.setColor(Color.GREEN);

	frame = new MyFrame();
	contentPane=frame.getContentPane();
	contentPane.paint(z);
    }

    public static void main(String[]args){
	GUI x = new GUI();
	x.frame.show();
	


    }


}