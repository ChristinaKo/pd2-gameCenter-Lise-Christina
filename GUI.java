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
    protected JButton createprof; // submitting new profile/name
    protected JFrame frame;

    protected JPanel menubar, scorebox;
    protected JMenuBar Title;
    protected JLabel title, scorelabel;

    protected JPanel panel;
    protected JPanel bp;
    protected JPanel gamep, pt,p; 

    protected JPanel Board,tic,connect4;
    protected JTextField uname;
    protected String username;
    protected Box center;
   
    
    //score variables
    protected PriorityQueue<Profile> ticscore,cfscore,qscore;
    private int ticscore, c4score, triviascore;
    
    //maxheaps of the high scores of each game

    //back end variables//





     public GUI(){
	 //GUI
	 //initial state -> title page
	 frame = new JFrame("Game Center");
	 frame.setSize(700,600);

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
	 title.setFont(new Font("Serif",Font.BOLD, 18));
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
	 JTextArea note = new JTextArea("Note: You will be asked to create a new profile so that any high scores can be attached to your name/uname.");


	 activate(startblurb);	
	 activate(note);

	 startb = new JButton("Click here to start");
	 
	 startb.setEnabled(true);
	 startb.setVisible(true);
	 Events e1 = new Events();
	 startb.addActionListener(e1);
	 
	 center = Box.createVerticalBox();
	 
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
		     createprofile();
		 }
		 else if (e1.getSource() == uname){
		     username = uname.getText();
		   
		 }
		 else if (e1.getSource() == createprof){
		     username = uname.getText();
		     if (username.equals("")){
			 
			 JTextArea emptytxtfield = new JTextArea("Please Enter Valid Username.");
			 activate(emptytxtfield);
			 emptytxtfield.setBackground(Color.red);
			
			 center.add(emptytxtfield);
			 pt.revalidate();
		     }
		     else{
			 pt.removeAll();
			 pt.revalidate();
			 frame.remove(pt);
			 mainscreen();
		     }
		 }
		 else if (e1.getSource() == b1){
		     ticscore = 0;
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     tictac();
		 }
		 else if (e1.getSource() == b2){
		     c4score = 0;
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     connectfour();
		 }
		 else if (e1.getSource() == b3){
		     triviascore = 0;
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
		     //restart games


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
	scorelabel.setText("Player: " + username);
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
	scorelabel.setText("Player: " + username +"        SCORE: "+ ticscore + "  ");
	pt = new JPanel();
	tic= new JPanel(new BorderLayout(3,3));
	tic.setBackground(Color.black);
	tic.setPreferredSize(new Dimension(300, 300));
	TicButton[][] boardsq = new TicButton[3][3];
	Board = new JPanel(new GridLayout(3,3));
	Board.setBackground(null);
	Board.setBorder(new LineBorder(Color.BLACK));
	for (int i = 0; i < 3; i++){
	    for (JButton x : boardsq[i]){
		x = new TicButton();
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
	center = Box.createVerticalBox();
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
	
	//backend tic
	
    }

    public void connectfour(){
	title.setText("Connect Four");
	scorelabel.setText("Player: " + username +"        SCORE: "+ c4score + "  ");
	pt = new JPanel();
	pt.setBackground(Color.orange);
	
	connect4= new JPanel(new BorderLayout(3,3));
	connect4.setBackground(Color.black);
	connect4.setPreferredSize(new Dimension(500,300));
	JButton[][] boardsq = new JButton[6][7];

	Board = new JPanel(new GridLayout(6,7));
	Board.setBackground(null);
	Board.setBorder(new LineBorder(Color.BLACK));
	
	for (int i = 0; i < 6; i++){
	    for (JButton x : boardsq[i]){
		x = new JButton("");
		x.setBorder(new LineBorder(Color.BLACK));
		x.setBackground(Color.blue);
		Board.add(x);
		if (i ==0){
		    x.setBackground(Color.yellow);
		    activate(x);
		}
		else{
		    x.setEnabled(false);
		}
	
	
	    }
	}
	

	//buttons for connect4 screen
	t1= new JButton("Restart");
	t2= new JButton("Quit");
	activate(t1);
	activate(t2);
	connect4.add(Board);	
	pt.add(connect4);
	center = Box.createVerticalBox();
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

	scorelabel.setText("Player: " + username +"        SCORE: "+ triviascore + "  ");
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
	scorelabel.setText("Player: " + username);	
	pt= new JPanel();
	pt.setBackground(Color.pink.darker());

	JTable board = new JTable(10,3){
		public boolean isCellEditable(int row, int column){
		    return false;
		}
	    };
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
	center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	center.add(board);
	center.add(Box.createVerticalGlue());
	center.createVerticalStrut(100);
	center.add(new newline());
	center.add(Box.createVerticalGlue());
	
	center.add(Box.createVerticalGlue());
	Box h = Box.createHorizontalBox();
	
	h.add(t2);
	h.add(prof);
 
	pt.add(center);
	center.add(h);
	frame.getContentPane().add(pt,BorderLayout.CENTER);
    }
  
    public void changeprofile(){
	title.setText("Create New Profile");
	pt = new JPanel();
	pt.setBackground(new Color(100,149,237));
	center = Box.createVerticalBox();
	center.add(new newline());
	center.add(new newline());
	
	uname = new JTextField("Enter Username", 14);
	activate(uname);
	uname.setBorder(new LineBorder(Color.BLACK));
	JTextArea u = new JTextArea("UserName: ");
	activate(u);
	u.setLineWrap(false);
	center.add(u);
	center.add(uname);
	center.add(new newline());

	Box h = Box.createHorizontalBox();
	createprof = new JButton("Create Profile");
	h.add(createprof);
	activate(createprof);
	t2 = new JButton("Quit");
	activate(t2);
	h.add(t2);

	center.add(h);
	pt.add(center);
	frame.add(pt, BorderLayout.CENTER);
    }
    public void createprofile(){
	title.setText("Create New Profile");
	pt = new JPanel();
	pt.setBackground(new Color(144,238,144));
	center = Box.createVerticalBox();
	center.add(new newline());
	center.add(new newline());
	
	uname = new JTextField("", 14);
	activate(uname);
	uname.setBorder(new LineBorder(Color.BLACK));
	JTextArea u = new JTextArea("UserName: ");
	activate(u);
	u.setLineWrap(false);
	center.add(u);
	center.add(uname);
	center.add(new newline());
	createprof = new JButton("Create Profile");
	center.add(createprof);
	activate(createprof);
	
	pt.add(center);
	frame.add(pt, BorderLayout.CENTER);
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
    private void activate(JTextField txtfield){
	txtfield.setEnabled(true);
	txtfield.setVisible(true);
	Events e1 = new Events();
	txtfield.addActionListener(e1);
    }	

    private class newline extends JTextArea{
	public newline(){
	    this.setText("");
	    this.setBackground(null);
	    this.setEditable(false);
	    this.setFont(new Font("Serif", Font.BOLD, 20));
	}
    } 

    private class TicButton extends JButton{
	private	char symbol;
	private boolean pressed;
	private ImageIcon X = new ImageIcon("x.png");
	private ImageIcon O = new ImageIcon("o.jpg");
	public TicButton(){
	    pressed = false;
	}
	
	public TicButton(char x){
	    pressed = false;
	}
	public void setsign(char x){
	    if (x =='x' || x=='X'){
		symbol = 'X';
		this.setIcon(X);
	    }
	    else{
		symbol = 'O';
		this.setIcon(O);
	    }
	}
    }
		
   
    public static void main(String[]args){
	GUI x = new GUI();
	
	/*add algorithms above as GUI methods
	  menu options above.
	*/

    }
}
	    