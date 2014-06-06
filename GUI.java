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

    public class JPanelGradient extends JPanel{
	public void paintChildren(Graphics g){
	    if (!isOpaque()){
		super.paintComponent(g);
		return;
	    }
	}
    }
    protected JButton startb,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    protected JFrame frame;
    protected JMenuBar title;
    protected JPanelGradient panel;
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

	panel = new JPanelGradient();
	panel.setOpaque(true);
	panel.setBackground(new Color(0,2,123));
	panel.setPreferredSize(new Dimension(400,380));
	frame.add(panel);

	startb = new JButton("Click here to start");

	panel.add(startb);
	startb.setEnabled(true);
	Events e1 = new Events();
	startb.addActionListener(e1);

	//frame.setBackground(new Color(145,003,124));
	//background = frame.getContentPane();
	//background.setLayout(new FlowLayout());
	frame.setJMenuBar(title);
	frame.getContentPane().add(panel,BorderLayout.CENTER);

	frame.pack();
	frame.setVisible(true);
    }
    public class Events implements ActionListener{
	
	public void actionPerformed(ActionEvent e1){
	    if (e1.getSource() == startb){
		try{
		    startb.setVisible(false);
		    mainscreen();
		}
		catch(Exception e){
		    e.printStackTrace();
		}
	    }
	}
    }
    public void mainscreen(){
	// screen where game options are given
	
	title.setBackground(Color.red);
	panel.setBackground(new Color(0,2,123));
	
	/*
	ImageIcon buttonimg1 = createImageIcon("images/right.gif");
	ImageIcon buttonimg2 = createImageIcon("images/middle.gif");
	ImageIcon buttonimg3 = createImageIcon("images/left.gif");
	*/

	b1 = new JButton("Tic Tac Toe");
	b2 = new JButton("Game 2");
	b3 = new JButton("Game 3");

	panel.add(b1);
	panel.add(b2);
	panel.add(b3);
	
	b1.setVisible(true);
	b2.setVisible(true);
	b3.setVisible(true);
    }


    public void tictac(){
	
	
    }


    public static void main(String[]args){
	GUI x = new GUI();
	
	/*add algorithms above as GUI methods
	  menu options above.
	*/

    }
}
	    