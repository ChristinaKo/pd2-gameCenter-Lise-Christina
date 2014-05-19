//Notes to self, we need to change jframe, jpanel, etc to private classes
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class GUI extends JFrame{

    //protected JButton n;
    protected Container background,contentPane;
    //  protected int actioncounter;

    //Actual Game buttons
    //protected JButton upgrades,quit;
    //protected JProgressBar infectionRate, lethality, visibility;
    // protected JTextArea notifications;
    //protected JTextArea plz, instructions;

    public class MyPanel extends JPanel{
	public void paintChildren(Graphics g){
	    
	}
    }

    protected JFrame frame;

    public GUI(){
	frame = new JFrame("Game Center");
	frame.setSize(600,600);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setForeground(new Color.red);
	background = frame.getContentPane();
	background.setLayout(new FlowLayout());

	
    }

    public static void main(String[]args){
	GUI x = new GUI();
	x.frame.setVisible(true);
	


    }


}