// 

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
    protected JButton t1;
    protected JButton t2, prof; // return to mainscreen button
    protected JButton submit; // submitting namex
    protected JFrame frame;

    protected JPanel menubar, scorebox;
    protected JMenuBar Title;
    protected JLabel title, scorelabel;

    protected JPanel panel;
    protected JPanel bp;
    protected JPanel gamep, pt,p; 

    protected JPanel Board,tic,connect4;

   
    //score variables
    protected PriorityQueue<Profile> ticscore,cfscore,qscore;
    private int tempscore;
    //maxheaps of the high scores of each game

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
	 Title.setBackground(new Color(238,130,238));
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
	 panel.setBackground(new Color(202,224,255));
	 panel.setPreferredSize(new Dimension(200,480));
	 
	 JTextArea startblurb = new JTextArea("Welcome to Game Center!!! Game Center is a place where you can play some of those games you used to play over and over again with your friends as a kids in middle. We have tic-tac-toe, connect four, and a thematic trivia game for you to enjoy. So find the start button on this screen to start playing those games right now!!!");
	 JTextArea note = new JTextArea("Note: You will be asked to create a new profile so that any high scores can be attached to your name/username.");


	 activate(startblurb);	
	 activate(note);

	 startb = new JButton("Click here to start");
	 
	 startb.setEnabled(true);
	 startb.setVisible(true);
	 Events e1 = new Events();
	 startb.addActionListener(e1);
	 
	 Box center = Box.createVerticalBox();
	 
	 center.add(startblurb);
	 center.add(new newline());
	 center.add(note);
	 center.add(new newline());	
	 center.add(startb);
	 panel.add(center);

	 //background = frame.getContentPane();
	 //background.setLayout(new FlowLayout());
	 frame.setJMenuBar(Title);
	 frame.getContentPane().add(panel,BorderLayout.CENTER);
	 //frame.pack();
	 frame.setVisible(true);
	 
	 //back end initializations
	 ticscore = new PriorityQueue<Profile>(1,new maxtomin());
	 cfscore = new PriorityQueue<Profile>(1,new maxtomin());
	 qscore = new PriorityQueue<Profile>(1,new maxtomin());
	 for (int i = 0; i < 9; i++){
	     ticscore.add(new Profile("Anonymous",0));
	     cfscore.add(new Profile("Anonymous",0));
	     qscore.add(new Profile("Anonymous",0));
	 }
	
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
		     tempscore = 0;
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     tictac();
		 }
		 else if (e1.getSource() == b2){
		     tempscore = 0;
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     connectfour();
		 }
		 else if (e1.getSource() == b3){
		     tempscore = 0;
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
		 else if (e1.getSource() == prof){
		     pt.removeAll();
		     pt.revalidate();
		     frame.remove(pt);
		     changeprofile();
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
	b3 = new JButton("Trivia Questions");
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
	scorelabel.setText("SCORE: "+ tempscore + "  ");
	pt = new JPanel();
	tic= new JPanel(new BorderLayout(3,3));
	tic.setBackground(Color.black);
	tic.setPreferredSize(new Dimension(300, 300));
	JButton[][] boardsq = new JButton[3][3];
	Board = new JPanel(new GridLayout(3,3));
	Board.setBackground(null);
	Board.setBorder(new LineBorder(Color.BLACK));
	for (int i = 0; i < 3; i++){
	    for (JButton x : boardsq[i]){
		x = new JButton("");
		x.setBorder(new LineBorder(Color.BLACK));
		x.setBackground(Color.blue);
		activate(x);
		Board.add(x);
	    }
	}
	
	tic.add(Board);	

	
	t1= new JButton("Restart");
	t2= new JButton("Quit");
	activate(t1);
	activate(t2);

	Box center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	center.add(tic);
	center.add(Box.createVerticalGlue());
	center.createVerticalStrut(100);
	center.add(new newline());
	center.add(Box.createVerticalGlue());
	Box h = Box.createHorizontalBox();
	h.add(Box.createHorizontalGlue());
	h.add(t1);
	h.add(t2);
	h.add(Box.createHorizontalGlue());
	center.add(h);
	center.add(Box.createVerticalGlue());
	pt.add(center);

	pt.setBackground(Color.magenta.darker());
	frame.getContentPane().add(pt);
    }

    public void connectfour(){
	title.setText("Connect Four");
	scorelabel.setText("SCORE: " + tempscore + " ");
	pt = new JPanel();
	pt.setBackground(Color.orange);
	
	connect4= new JPanel(new BorderLayout(3,3));
	connect4.setBackground(Color.black);
	connect4.setPreferredSize(new Dimension(400,300));
	JButton[][] boardsq = new JButton[8][6];

	Board = new JPanel(new GridLayout(8,6));
	Board.setBackground(null);
	Board.setBorder(new LineBorder(Color.BLACK));
	for (int i = 0; i < 8; i++){
	    for (JButton x : boardsq[i]){
		x = new JButton("");
		x.setBorder(new LineBorder(Color.BLACK));
		x.setBackground(Color.blue);
		activate(x);
		Board.add(x);
	    }
	}
	

	//buttons for connect4 screen
	t1= new JButton("Restart");
	t2= new JButton("Quit");
	activate(t1);
	activate(t2);
	connect4.add(Board);	
	pt.add(connect4);
	Box center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	center.add(connect4);
	center.add(Box.createVerticalGlue());
	center.createVerticalStrut(100);
	center.add(new newline());
	center.add(Box.createVerticalGlue());
	Box h = Box.createHorizontalBox();
	h.add(Box.createHorizontalGlue());
	h.add(t1);
	h.add(t2);
	h.add(Box.createHorizontalGlue());
	center.add(h);
	center.add(Box.createVerticalGlue());
	pt.add(center);

	frame.getContentPane().add(pt,BorderLayout.CENTER);
	
    }


    public void trivia(){
	title.setText("Trivia");
	scorelabel.setText("SCORE: " + tempscore + " ");
	pt= new JPanel();
	pt.setBackground(new Color(32,178,170));
	
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
	prof= new JButton("Change Profile");
	activate(t2);
	activate(prof);
	Box center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	center.add(board);
	center.add(Box.createVerticalGlue());
	center.createVerticalStrut(100);
	center.add(new JLabel(""));
	center.add(Box.createVerticalGlue());
	
	center.add(Box.createVerticalGlue());
	Box h = Box.createHorizontalBox();
	
	h.add(t2);
	h.add(prof);
 
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

    public void activate(JTextArea text){
	text.setFont(new Font("Serif", Font.BOLD, 14));
	text.setLineWrap(true);
	text.setWrapStyleWord(true);
	text.setEditable(false);
	text.setBackground(null);
    }
    public void changeprofile(){
	pt = new JPanel();

	Box center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	//username	
	center.add(Box.createVerticalGlue());
	submit = new JButton("Submit");
	center.add(submit);
	
	frame.add(pt, BorderLayout.CENTER);
    }
    private class newline extends JTextArea{
	public newline(){
	    this.setText("");
	    this.setBackground(null);
	    this.setEditable(false);
	    this.setFont(new Font("Serif", Font.BOLD, 20));
	}
    }
   
    public static void main(String[]args){
	GUI x = new GUI();
	
	/*add algorithms above as GUI methods
	  menu options above.
	*/

    }
}
	    