// medium purple

//Notes to self, we need to change jframe, jpanel, etc to private classes
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JPanel.*;
import javax.swing.table.TableColumn;

public class GUI extends JFrame{

    //GUI variables- front end
    protected Container background,contentPane;
    
    private final JLabel spacelabel;
    protected JButton startb,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    protected JButton t1,t2;
    protected JFrame frame;

    protected JPanel menubar, scorebox;
    protected JMenuBar Title;
    protected JLabel title, scorelabel;

    protected JPanel panel;
    protected JPanel bp;
    protected JPanel gamep, pt,p; 

    protected JPanel tic, ticBoard;

    //score variables
    protected PriorityQueue ticscore,cfscore,qscore;

    //back end variables//





     public GUI(){
	 //GUI
	 //initial state -> title page
	 frame = new JFrame("Game Center");
	 frame.setSize(500,500);

	 frame.setLocationRelativeTo(null);
	 frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	 Title= new JMenuBar();
	 Title.setOpaque(true);
	 Title.setBackground(Color.red);
	 Title.setPreferredSize(new Dimension(100,40));

	 menubar= new JPanel();
	 menubar.setBackground(null);
	 title = new JLabel("Welcome to Game Center");
	 title.setBackground(null);
	 title.setHorizontalTextPosition(SwingConstants.CENTER);
	 title.setVerticalTextPosition(SwingConstants.CENTER);
	 menubar.add(title);
	  
	 spacelabel= new JLabel("                                            ");
	 spacelabel.setBackground(null);

	 scorebox = new JPanel();
	 scorebox.setBackground(null);
	 scorelabel = new JLabel("");
	 scorelabel.setOpaque(true);
	 scorelabel.setBackground(null);
	 scorebox.add(spacelabel);
	 scorebox.add(scorelabel);
	 
	 menubar.add(scorebox, BorderLayout.LINE_END);
		 
	 Title.add(menubar);
	 
	 panel = new JPanel();
	 panel.setOpaque(true);
	 panel.setBackground(new Color(0,2,123));
	 panel.setPreferredSize(new Dimension(200,480));
	
		
	
	 startb = new JButton("Click here to start");
	 
	 startb.setEnabled(true);
	 startb.setVisible(true);
	 Events e1 = new Events();
	 startb.addActionListener(e1);
	 
	 panel.add(startb);

	 //background = frame.getContentPane();
	 //background.setLayout(new FlowLayout());
	 frame.setJMenuBar(Title);
	 frame.getContentPane().add(panel,BorderLayout.CENTER);
	 //frame.pack();
	 frame.setVisible(true);
	 
	 //back end initializations
	 ticscore = new PriorityQueue();
	 cfscore = new PriorityQueue();
	 qscore = new PriorityQueue();
	
     }
     public class Events implements ActionListener{
	 public void actionPerformed(ActionEvent e1){
	     try{
		 if (e1.getSource() == startb){		     
		     panel.removeAll();
		     panel.revalidate();
		     frame.remove(panel);
		     mainscreen();
		 }
		 else if (e1.getSource() == b1){
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     tictac();
		 }
		 else if (e1.getSource() == b2){
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     connectfour();
		 }
		 else if (e1.getSource() == b3){
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     trivia();
		 }
		 else if (e1.getSource() == b4){
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     scores();
		     
		 }
		 else if (e1.getSource() == t1){



		 }
		 else if (e1.getSource() == t2){
		     pt.removeAll();
		     pt.revalidate();
		     frame.remove(pt);
		     mainscreen();		    
		 }

	     }
	     catch(Exception e){
		 e.printStackTrace();
	     }
	 }
     }
    public void mainscreen(){
	// screen where game options are given
	title.setText("GAME CENTER");
	
	gamep = new JPanel();
	gamep.setBackground(Color.yellow);
	GridLayout grid = new GridLayout(2,2);
	gamep.setLayout(grid);
	frame.getContentPane().add(gamep);
	title.setBackground(Color.red);
	//set text
	
	b1 = new JButton("Tic Tac Toe");
	b2 = new JButton("Connect 4");
	b3 = new JButton("Game 3");
	b4 = new JButton("HIGH SCORES");
	 
	gamep.add(b1);
	gamep.add(b2);
	gamep.add(b3);
	gamep.add(b4);
	 
	activate(b1);
	activate(b2);
	activate(b3);
	activate(b4);



    }


    public void tictac(){

	title.setText("Tic-Tac-Toe");
	scorelabel.setText(ticscore);
	pt = new JPanel();
	tic= new JPanel(new BorderLayout(3,3));
	tic.setBackground(Color.green);
	tic.setPreferredSize(new Dimension(300, 300));
	JButton[][] boardsq = new JButton[3][3];

	ticBoard = new JPanel(new GridLayout(3,3));
	ticBoard.setBackground(null);
	ticBoard.setBorder(new LineBorder(Color.BLACK));
	for (int i = 0; i < 3; i++){
	    for (JButton x : boardsq[i]){
		x = new JButton("");
		x.setBorder(new LineBorder(Color.BLACK));
		x.setBackground(Color.blue);
		activate(x);
		ticBoard.add(x);
	    }
	}
	

	tic.add(ticBoard);	
	pt.add(tic);
	
	pt.setBackground(Color.magenta.darker());
	frame.getContentPane().add(pt);

	t1= new JButton("Restart");
	t2= new JButton("Quit");
	pt.add(t1,BorderLayout.SOUTH);
	pt.add(t2,BorderLayout.SOUTH);

	activate(t1);
	activate(t2);


    }

    public void connectfour(){
	title.setText("Connect Four");
	pt = new JPanel();
	pt.setBackground(Color.orange);
	
	frame.getContentPane().add(pt,BorderLayout.CENTER);
	t1= new JButton("Restart");
	t2= new JButton("Quit");

	pt.add(t1);
	pt.add(t2);

	activate(t1);
	activate(t2);

    }


    public void trivia(){
	title.setText("Trivia");
	pt= new JPanel();
	pt.setBackground(Color.orange);
	
	frame.getContentPane().add(pt,BorderLayout.CENTER);
	t1= new JButton("Restart");
	t2= new JButton("Quit");
	
	pt.add(t1);
	pt.add(t2);

	activate(t1);
	activate(t2);
    }
    public void scores(){
	title.setText("HIGH SCORES");
	
	pt= new JPanel();
	pt.setBackground(Color.pink.darker());
	

	JTable board = new JTable(10,3);
	board.setGridColor(Color.black);
	board.setRowHeight(10);
	TableColumn column;
	for (int i =0; i <3; i++){
	    column=board.getColumnModel().getColumn(i);
	    column.setPreferredWidth(100);
	}

	t2= new JButton("Main Menu");
	t1= new JButton("Change Profile");
	activate(t2);
	//activate change profile button
	Box center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	center.add(board);
	center.add(Box.createVerticalGlue());
	center.createVerticalStrut(100);
	center.add(new JLabel(""));
	center.add(Box.createVerticalGlue());
	
	center.add(Box.createVerticalGlue());
	Box h = Box.createHorizontalBox();

	h.add(t1);
 
	pt.add(center);
	pt.add(h);
	frame.getContentPane().add(pt,BorderLayout.CENTER);


    }
    public void activate(JButton button){
	button.setEnabled(true);
	button.setVisible(true);
	Events e1 = new Events();
	button.addActionListener(e1);
    }

  
    public static void main(String[]args){
	GUI x = new GUI();
	
	/*add algorithms above as GUI methods
	  menu options above.
	*/

    }
}
	    