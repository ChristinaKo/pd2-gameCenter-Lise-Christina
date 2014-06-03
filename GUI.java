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

    public class MyPanelGradient extends JPanel{
	public void paintChildren(Graphics g){
	    if (!isOpaque()){
		super.paintComponent(g);
		return;
	    }
	}
    }

    protected JFrame frame;
    protected JMenuBar title;
    protected JLabel label;
    public GUI(){
	//initial state -> title page
	frame = new JFrame("Game Center");
	frame.setSize(400,400);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	title= new JMenuBar();
	title.setOpaque(true);
	title.setBackground(Color.cyan);
	title.setPreferredSize(new Dimension(400,20));

	label = new JLabel();
	label.setOpaque(true);
	label.setBackground(new Color(0,2,123));
	label.setPreferredSize(new Dimension(400,380));


	//frame.setBackground(new Color(145,003,124));
	//background = frame.getContentPane();
	//background.setLayout(new FlowLayout());
	frame.setJMenuBar(title);
	frame.getContentPane().add(label,BorderLayout.CENTER);

	frame.pack();
	frame.setVisible(true);
    }
    
    public void mainscreen(){

	ImageIcon buttonimg1 = createImageIcon("images/right.gif");
	ImageIcon buttonimg2 = createImageIcon("images/middle.gif");
	ImageIcon buttonimg3 = createImageIcon("images/left.gif");

	b1 = new JButton("Game 1", buttonimg1);
	b2 = new JButton("Game 2", buttonimg2);
	b3 = new JButton("Game 3", buttonimg3);

    }
)


    public static void main(String[]args){
	GUI x = new GUI();
	
	/*add algorithms above as GUI methods
	  menu options above.
	


    }


}