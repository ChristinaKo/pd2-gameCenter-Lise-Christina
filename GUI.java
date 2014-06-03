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
    protected JMenuBar title;
    protected JLabel label;
    public GUI(){
	frame = new JFrame("Game Center");
	frame.setSize(400,400);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	title= new JMenuBar();
	title.setOpaque(true);
	title.setBackground(new Color(123,143,023));
	title.setPreferredSize(new Dimension(400,20));

	label = new JLabel();
	label.setOpaque(true);
	label.setBackground(new Color(248,232,123));
	label.setPreferredSize(new Dimension(400,380));


	//frame.setBackground(new Color(145,003,124));
	//background = frame.getContentPane();
	//background.setLayout(new FlowLayout());
	frame.setJMenuBar(title);
	frame.getContentPane().add(label,BorderLayout.CENTER);



	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[]args){
	GUI x = new GUI();

	


    }


}