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
    protected JButton t1, c1, cq2, p2;
    protected JButton ct1,ct2,ct3,ct4,ct5,ct6,ct7;
    protected JButton t2, prof; // return to mainscreen button
    protected JButton createprof, submit; // submitting new profile/name and trivia answer
    protected JButton tac1,tac2,tac3,tac4,tac5,tac6,tac7,tac8, tac9;
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
    protected JRadioButton tr, fa;
    protected JRadioButton tic1, tic2, tic3;
    protected JRadioButton c41,c42; //choosing colors for tic and c4 games
    protected JButton tsubmit, easystuff, csubmit;
    protected ButtonGroup XO;
    protected ButtonGroup trfa;
    protected JButton[][] boardsq;
   
    //score variables
    protected PriorityQueue<Profile> tichs,c4hs,qhs;
    private int ticscore, c4score, triviascore;
    private final ImageIcon X = createImageIcon("X.png");
    private final ImageIcon O = createImageIcon("o.gif");
    private ImageIcon pla,oppo;
 
      
    //maxheaps of the high scores of each game

    //back end variables//
    private char sym, opp;
    protected char[][] board;
    protected String[][] cboard;
    protected boolean easy;

    protected TrueOrFalse tf;



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
	 
	 JTextArea startblurb = new JTextArea("Welcome to Lise and Christina’s Game Center. Our Game Center allows you to play some games you played as a child. Currently our Game Center holds three games: Tic-Tac-Toe, Connect Four, and a True-or-False trivia game. To get started, find the start button on the screen and click!");
	 
	 JTextArea note = new JTextArea("Note: You will be asked to create a new profile so that any high scores can be attached to your name/username.");


	 activate(startblurb);	
	 activate(note);

	 startb = new JButton("Click here to start");
	 
	 startb.setEnabled(true);
	 startb.setVisible(true);
	 Events e1 = new Events();
	 startb.addActionListener(e1);
	 
	 center = Box.createVerticalBox();
	 center.add(new newline());
	 center.add(new newline());
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
	 tichs = new PriorityQueue<Profile>(1,new maxtomin());
	 c4hs = new PriorityQueue<Profile>(1,new maxtomin());
	 qhs = new PriorityQueue<Profile>(1,new maxtomin());
	 for (int i = 0; i < 9; i++){
	     tichs.add(new Profile("Anonymous",0));
	     c4hs.add(new Profile("Anonymous",0));
	     qhs.add(new Profile("Anonymous",0));
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
		     choosetic();
		 }

	
		 else if (e1.getSource() == b2){
		     c4score = 0;
		     gamep.removeAll();
		     gamep.revalidate();
		     frame.remove(gamep);
		     c4screen();
		 }
		 else if (e1.getSource() == b9){
		     pt.removeAll();
		     pt.revalidate();
		     frame.remove(pt);
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
		     pt.removeAll();
		     pt.revalidate();
		     frame.remove(pt);
		     tictac();

		 }
		  else if (e1.getSource() == c1){
		     //restart connect4
		     pt.removeAll();
		     pt.revalidate();
		     frame.remove(pt);
		     connectfour();

		 }
		 else if (e1.getSource() == t2){
		     pt.removeAll();
		     pt.revalidate();
		     frame.remove(pt);
		     mainscreen();	
		     tichs.add(new Profile (username,ticscore));
		     ticscore=0;
		 }
		 else if (e1.getSource() == prof){
		     pt.removeAll();
		     pt.revalidate();
		     frame.remove(pt);
		     changeprofile();
		 }
	
     
		else if(e1.getSource() == tsubmit){
		    easy =false;
		    if(tic1.isSelected()){
			sym= 'X';
			opp = 'O';
			pla = X;
			oppo=O;
		    }
		    else {
			sym = 'O';
			opp = 'X';
			pla = O;
			oppo= X;
		    }
		    pt.removeAll();
		    pt.revalidate();
		    frame.remove(pt);
		    tictac();
		 }
		 
		else if(e1.getSource() == easystuff){
		    easy =true;
		    if(tic1.isSelected()){
			sym= 'X';
			opp = 'O';
			pla = X;
			oppo=O;
		    }
		    else {
			sym = 'O';
			opp = 'X';
			pla =O;
			oppo=X;
		    }
		    pt.removeAll();
		    pt.revalidate();
		    frame.remove(pt);
		    tictac();
		}
		else if (e1.getSource() == tac1 || e1.getSource() == tac2 || e1.getSource() == tac3 || e1.getSource() == tac4 || e1.getSource() == tac5 || e1.getSource() == tac6 || e1.getSource() == tac7 || e1.getSource() == tac8 || e1.getSource() == tac9){
		    if (winner()){
			winAction();
		    }
		    else if (loser()){
			loseAction();			
		    }
		    if (e1.getSource()==tac1){
			tac1.setIcon(pla);
			tac1.setDisabledIcon(pla);
			tac1.setPressedIcon(pla);
			tac1.setSelectedIcon(pla);
			tac1.setEnabled(false);			
			board[0][0]=sym; 
			ticmove();
		    }
		    else if (e1.getSource() ==tac2){
			tac2.setIcon(pla);
			tac2.setDisabledIcon(pla);
			tac2.setPressedIcon(pla);
			tac2.setSelectedIcon(pla);
			tac2.setEnabled(false);
			board[0][1]=sym;
			ticmove();
		    }
		    else if (e1.getSource() ==tac3){
			tac3.setIcon(pla);
			tac3.setDisabledIcon(pla);
			tac3.setPressedIcon(pla);
			tac3.setSelectedIcon(pla);
			tac3.setEnabled(false);
			board[0][2]=sym;
			ticmove();
		    }
		    else if (e1.getSource() ==tac4){
			tac4.setIcon(pla);
			tac4.setDisabledIcon(pla);
			tac4.setPressedIcon(pla);
			tac4.setSelectedIcon(pla);
			tac4.setEnabled(false);
			board[1][0]=sym;
			ticmove();		    
		    }
		    else if (e1.getSource() ==tac5){
			tac5.setIcon(pla);
			tac5.setDisabledIcon(pla);
			tac5.setPressedIcon(pla);
			tac5.setSelectedIcon(pla);
			tac5.setEnabled(false);
			board[1][1]=sym;
			ticmove();		    
		    }
		    else if (e1.getSource() ==tac6){
			tac6.setIcon(pla);
			tac6.setDisabledIcon(pla);
			tac6.setPressedIcon(pla);
			tac6.setSelectedIcon(pla);
			tac6.setEnabled(false);
			board[1][2]=sym;
			ticmove();		    
		    
		    }
		    else if (e1.getSource() ==tac7){
			tac7.setIcon(pla);
			tac7.setDisabledIcon(pla);
			tac7.setPressedIcon(pla);
			tac7.setSelectedIcon(pla);
			tac7.setEnabled(false);
			board[2][0]=sym;
			ticmove();		    
		    }
		    else if (e1.getSource() ==tac8){
			tac8.setIcon(pla);
			tac8.setDisabledIcon(pla);
			tac8.setPressedIcon(pla);
			tac8.setSelectedIcon(pla);
			tac8.setEnabled(false);
			board[2][1]=sym;
			ticmove();		    
		    }
		    else if (e1.getSource() ==tac9){
			tac9.setIcon(pla);
			tac9.setDisabledIcon(pla);
			tac9.setPressedIcon(pla);
			tac9.setSelectedIcon(pla);tac9.setEnabled(false);
			board[2][2]=sym;
			ticmove();		    
		    }

		}

		else if (e1.getSource() == submit){
		    if (tr.isSelected()){
			if (tf.checkAnswer(tr.getText())){
			    triviascore += 5;
			    scorelabel.setText("Player: " + username +"        SCORE: "+ triviascore + "  ");
			}
			else {
			    qhs.add(new Profile(username,triviascore));
			    triviascore = 0;
			    scorelabel.setText("Player: " + username +"        SCORE: "+ triviascore + "  ");
			}
		    }
		    else if (fa.isSelected()){
			if (tf.checkAnswer(fa.getText())){
			    triviascore += 5;
			    scorelabel.setText("Player: " + username +"        SCORE: "+ triviascore + "  ");
			}
			else {
			    qhs.add(new Profile(username,triviascore));
			    triviascore = 0;
			    scorelabel.setText("Player: " + username +"        SCORE: "+ triviascore + "  ");
			}
		    }
		    pt.removeAll();
		    pt.revalidate();
		    frame.remove(pt);
		    trivia();
		}
		else if (e1.getSource() == p2){
		    pt.removeAll();
		    pt.revalidate();
		    frame.remove(pt);
		    mainscreen();		    
		}
		else if (e1.getSource() == cq2){
		    pt.removeAll();
		    pt.revalidate();
		    frame.remove(pt);
		    mainscreen();	
		    c4hs.add(new Profile(username,c4score));
		    c4score =0;
		}
		else if (e1.getSource() == ct1 || e1.getSource()== ct2  || e1.getSource()== ct3  || e1.getSource()== ct4  || e1.getSource()==ct5  || e1.getSource()== ct6  || e1.getSource()== ct7 ){
		  
			int d = (int)(Math.random() *6);
			int j = (int)(Math.random() *7);
			boardsq[d][j] = new JButton();
			boardsq[d][j].setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			pt.revalidate();
		  
		}
		      
		 
		 /* else if(cwinner()){
			cwinAction();
		    }
		    else if (closer()){
			closeAction();
		    }
		 */
		   
		    
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

    public void choosetic(){
	pt = new JPanel();
	pt.setBackground(new Color(32,178,170));
	tic1 = new JRadioButton("X");
	tic2 = new JRadioButton("O");
	tic3 = new JRadioButton("I don't care.");
	XO = new ButtonGroup();
	XO.add(tic1);
	XO.add(tic2);
	XO.add(tic3);
	center = Box.createVerticalBox();

	JTextArea blurb = new JTextArea("Choose your symbol: X or O.");
	JTextArea blurb2 = new JTextArea("Whichever button you do not click will be the symbol of your opponent.");
	activate(blurb);
	blurb.setLineWrap(false);
	activate(blurb2);
	blurb2.setLineWrap(false);
	center.add(new newline());    
	center.add(blurb);
	center.add(new newline()); 
	center.add(blurb2);
	center.add(new newline()); 
	blurb.setFont(new Font("Serif", Font.BOLD, 15));
	blurb2.setFont(new Font("Serif", Font.BOLD, 15));

	center.add(Box.createVerticalGlue());
	Box h = Box.createHorizontalBox();
	h.add(Box.createHorizontalGlue());
	activate(tic1);
	activate(tic2);
	activate(tic3);
	tic3.setSelected(true);
	h.add(tic1);
	h.add(tic2);
	h.add(tic3);
	h.add(Box.createHorizontalGlue());
	center.add(h);
	h.setBackground(null);
	center.add(new newline()); 
	center.add(new newline()); 
	easystuff = new JButton("Easy");
	tsubmit = new JButton("Hard");
	activate(easystuff);
	center.add(easystuff);
	activate(tsubmit);
	center.add(tsubmit);
	pt.add(center);
	frame.add(pt, BorderLayout.CENTER);

    }
    public void tictac(){
	title.setText("Tic-Tac-Toe");
	scorelabel.setText("Player: " + username +"        SCORE: "+ ticscore + "  ");
	pt = new JPanel();
	tic= new JPanel(new BorderLayout(3,3));
	tic.setBackground(Color.blue);
	tic.setPreferredSize(new Dimension(300, 300));
	boardsq = new JButton[3][3];
	board = new char[3][3];
	Board = new JPanel(new GridLayout(3,3));

	tac1 = new JButton();
	tac2 = new JButton();
	tac3 = new JButton();
	tac4 = new JButton();
	tac5 = new JButton();
	tac6 = new JButton();
	tac7 = new JButton();
	tac8 = new JButton();
	tac9 = new JButton();
	updatetic(boardsq);

	Board.setBackground(null);
	Board.setBorder(new LineBorder(Color.BLACK));
	    
	tic.add(Board);	
	t1= new JButton("Restart");
	t2= new JButton("Quit");
	activate(t1);
	activate(t2);
	center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	JTextArea y = new JTextArea("You are " + sym + ".");
	activate(y);
	center.add(y);
	center.add(new newline());
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
    public void updatetic(JButton[][] boardsq){
	// to be only used in tictac
	boardsq[0][0] = tac1;
	boardsq[0][1] = tac2;
	boardsq[0][2] = tac3;
	boardsq[1][0] = tac4;
	boardsq[1][1] = tac5;
	boardsq[1][2] = tac6;
	boardsq[2][0] = tac7;
	boardsq[2][1] = tac8;
	boardsq[2][2] = tac9;
	
	for (int i = 0; i<3; i++){
	    for (int j=0; j<3; j++){
		boardsq[i][j].setBorder(new LineBorder(Color.BLACK));
		boardsq[i][j].setBackground(Color.blue);
		activate(boardsq[i][j]);
		Board.add(boardsq[i][j]);
	    }
	}
    }
    public void ticmove(){
	 if (!winner() && !loser() && filled()){
	     center.add(new newline());
	     center.add(new JTextArea("TIE!!!!!  Press Restart for new game."));   
	     pt.revalidate();
	 }else if (!winner() && !loser()){
	     int[] x;  // 2 item array is for row index and column for tictac
	     if (easy){				

		 System.out.println("easy");
		 x= OMoveEasy();
	     }
	     else{
		 x = OMove();
	     }
	     if (x != null){
		 boardsq[x[0]][x[1]].setIcon(oppo);
		 boardsq[x[0]][x[1]].setEnabled(false);
		 board[x[0]][x[1]]=opp;
		 if (loser()){
		     loseAction();
		 }
	     }

	 }else if (winner()){
	     winAction();
	 }
	 else if (loser()){
	     loseAction();
	 }	
     }
     public void winAction(){
	 for (int i =0; i<3; i++){
	     for (JButton x: boardsq[i]){
		 x.setEnabled(false);
	     }
	 }
	 center.add(new newline());
	 JTextArea z = new JTextArea("YOU WIN!!! Press 'Restart' to play again");
	 activate(z);
	 center.add(z);
	 if (easy){
	     ticscore += 5;
	 }
	 else{
	     ticscore += 10;
	 } 
	 scorelabel.setText("Player: " + username +"        SCORE: "+ ticscore + "  ");
     }
     public void loseAction(){
	 for (int i =0; i<3; i++){
	     for (JButton x: boardsq[i]){
		 x.setEnabled(false);
	     }
	 }
	 center.add(new newline());
	 JTextArea z = new JTextArea("YOU LOSE!!");
	 JTextArea a = new JTextArea("YOUR SCORE IS "+ c4score);
	 JTextArea q = new JTextArea("Press 'Restart' to play again");
	 activate(z);
	 activate(a);
	 activate(q);

	 center.add(z);
	 center.add(a);
	 center.add(q);
	 tichs.add(new Profile(username,ticscore));
	 ticscore=0;	
	 scorelabel.setText("Player: " + username +"        SCORE: "+ ticscore + "  ");
     }

     public boolean filled(){
	 boolean ans = true;
	 for(int i = 0; i <board.length; i ++){
	     for (int j = 0; j < board[i].length; j++){
		 if(board[i][j] == '\0'){
		     ans = false;
		 }
	     }
	 }
	 return ans;

     }
     public int[] OMoveEasy(){
	 ArrayList<Integer> x = new ArrayList<Integer>();
	 ArrayList<Integer> y = new ArrayList<Integer>();
	 int[] ans = new int[2];
	 for(int i = 0; i <board.length; i ++){
	     for (int j = 0; j < board[i].length; j++){
		 if(board[i][j] == '\0'){
		     x.add(i);
		     y.add(j);
		 }
	     }
	 }
	 int rand = (int)(Math.random() * x.size());
	 try{
	     int i= x.get(rand);
	     int j = y.get(rand);

	     ans[0] =i;
	     ans[1]=j;
	     return ans;
	 }
	 catch(Exception e){
	     return null;
	 }
     }
     public int[] OMove(){
	 int[] ans = new int[2];
	 for (int i = 0; i < board.length; i++){
	     for(int j = 0; j <board[i].length; j++){
		 if(board[i][j] == sym){
		     if(i + 1 < board.length && board[i +1][j] == sym){ 
			     if(i + 1 ==0){
				 if(board[i+1][j] == '\0'){
				     board[i+1][j] = opp;
				     ans[0] = i-1;
				     ans[1] = j;
				     return ans;
				 }
			     }
			     else{
				 if (i+2<board.length && board[i+2][j] =='\0'){
				     board[i+2][j] = opp;
				     ans[0] = i+2;
				     ans[1] = j;
				     return ans;
				 }
			     }
		     }
		     else if (i-2>=0){			
			 if(board[i-2][j]== sym){
			     if (board[i-1][j] =='\0'){
				 ans[0]=i-1;
				 ans[1]=j;
				 return ans;
			     }
			 }
			 else if (board[i-1][j]== sym){
			     if (board[i-2][j] =='\0'){
				 ans[0] = i-2;
				 ans[1] = j;
				 return ans;
			     }
			 }
		     }
		     //diagonal topleft corner to bottomright corner
		     if(j + 1 <board[i].length && i+1 < board.length){
			 if(board[i + 1][j+1] == sym){
			     if(i-1 >= 0 && j-1 >= 0){
				 if(board[i-1][j-1] == '\0'){
				     board[i-1][j-1] = opp;
				     ans[0] = i-1;
				     ans[1] = j-1;
				     return ans;
				 }
			     }
			     else{ 
				 if(i+2< board.length && j+2 < 3){
				     if(board[i+2][j+2] == '\0'){
					 board[i+2][j+2] = opp;
					 ans[0] = i+2;
					 ans[1] = j+2;
					 return ans;
				     }
				 }
			     }

			 }
		     }//same diagonal - two corners are filed
		     if(i+2< board.length && j+2 < 3){
			 if (board[i+2][j+2]==sym){
			     if(board[i+1][j+1] == '\0'){
				 board[i+1][j+1] = opp; //middle box
				 ans[0] = i+1;
				 ans[1] = j+1;
				 return ans;
			     }
			 }
		     } 
		     //opposite diagonal
		     if(j + 1 <board[i].length && i-1 >=0){
			 if(board[i - 1][j+1] == sym){
			     if(i+1 >= 0 && j-1 >= 0){
				 if(board[i+1][j-1] == '\0'){
				     board[i+1][j-1] = opp;
				     ans[0] = i+1;
				     ans[1] = j-1;
				     return ans;
				 }
			     }
			     else{ 
				 if(i+2< board.length && j+2 < 3){
				     if(board[i+2][j+2] == '\0'){
					 board[i+2][j+2] = opp;
					 ans[0] = i+2;
					 ans[1] = j+2;
					 return ans;
				     }
				 }
			     }

			 }
		     }//same diagonal - two corners are filed
		     if(i+2< board.length && j+2 < 3){
			 if (board[i+2][j+2]==sym){
			     if(board[i+1][j+1] == '\0'){
				 board[i+1][j+1] = opp; //middle box
				 ans[0] = i+1;
				 ans[1] = j+1;
				 return ans;
			     }
			 }
		     }  
		     


		     //opposite diagonal
		     if(i==2 && j+2<3 &&board[i-2][j+2]==sym){
			 if(board[i-1][j+1] == '\0'){
			     board[i-1][j+1] = opp;
			     ans[0] = i-1;
			     ans[1] = j+1;
			     return ans;
			 }
		     }
		     if (i-2>=0&& j==0){
			 if (board[i][j]==sym){
			     if (board[i][j+2]==sym){
				 if(board[i][j+2] == '\0'){
				     board[i][j+2] = opp;
				     ans[0] = i;
				     ans[1] = j+2;
				     return ans;
				 }
			     }
			 }   
		     }
		     if (i-1 >0 && j-1 >0 && board[i-1][j-1] ==sym){
			 if(i+1 <3 && j+1<3){
			     if(board[i+1][j+1] == '\0'){
				 board[i+1][j+1] = opp;
				 ans[0] = i+1;
				 ans[1] = j+1;
				 return ans;
			     }
			 }
			 else{
			     if(i-2>0 && j-2>0){
				 if(board[i-2][j-2] == '\0'){
				     board[i-2][j-2] = opp;
				     ans[0] = i-2;
				     ans[1] = j-2;
				     return ans;
				 }
			     }
			 }
		     }
		     if(j + 1 < board.length){
			 if(board[i][j+1] == sym){ 
			     if(j - 1 ==0){
				 if(board[i][j-1] == '\0'){
				     board[i][j-1] = opp;
				     ans[0] = i;
				     ans[1] = j-1;
				     return ans;
				 }
			     }
			 }
			 else if (j-1 >=0 &&board[i][j-1]==sym){
			     if (board[i][j-1]==sym){
				 if (j-1 ==0){
				     if (board[i][j+1]=='\0'){
					 board[i][j+1] = opp;
					 ans[0] = i;
					 ans[1] = j+1;
					 return ans;
				     }
				 }
			     }
			 }
		     }
		     else if(j==2 && board[i][j]==sym && board[i][j-2]==sym){
			 if (board[i][j-1]=='\0'){	
			     board[i][j-1] = opp;
			     ans[0] = i;
			     ans[1] = j-1;
			     return ans;
			 }
		     }
				     else{
			 if (i+2<board.length && board[i+2][j] =='\0'){
			     board[i+2][j] = opp;
			     ans[0] = i+2;
			     ans[1] = j;
			     return ans;
			 }
		     }
		 }
 
	     }
	 }
     
	 for (int i = 0; i < board.length; i++){
	     for(int j = 0; j <board[i].length; j++){
		 if(board[i][j] == opp){
		     if(i + 1 < board.length){
			 if(board[i +1][j] == opp){
			     if(i - 1 ==0){
				 if(board[i-1][j] == '\0'){
				     board[i-1][j] = opp;
				     ans[0] = i-1;
				     ans[1] = j;
				     return ans;
				 }
			     }
			     else{
				 if (i+2<board.length){
				     if (board[i+2][j] =='\0'){
					 board[i+2][j] = opp;
					 ans[0] = i+2;
					 ans[1] = j;
					 return ans;
				     }
				 }
			     }
			 }
		     }
		     else if( j + 1 <board[i].length && i+1<3){
			 if(board[i + 1][j+1] == opp){
			     if( i-1 >= 0 && j -1 >= 0){
				 if(board[i-1][j-1] == '\0'){
				     board[i-1][j-1] = opp;
				     ans[0] = i-1;
				     ans[1] = j-1;
				     return ans;
				 }
			     }
			     else{
				 if(i+2< board.length && j+2<board.length){
				     if(board[i+2][j+2] == '\0'){
					 board[i+2][j+2] =opp;
					 ans[0] = i+2;
					 ans[1] = j+2;
					 return ans;
				     }
				 }
			     }
			 }
		     }
		     else if(j-1 == 0){
			 if(board[i][j-1] == '\0'){
			     board[i][j-1] = opp;
			     ans[0] = i;
			     ans[1] = j-1;
			     return ans;
			 }
		     }
		     else{
			 if (j+2<board.length){
			     if(board[i][j+2] == '\0'){
				 board[i][j+2] = opp;
				 ans[0] = i;
				 ans[1] = j+2;
				 return ans;
			     }
			 }
		     }
		 }
	     }
	 }
	 return OMoveEasy();
     }
    
    public boolean checkWinner(int x, int y){
	try{
	    if (board[x][y] == sym){
		return true;
	    }
	    else{
		return false;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){
	    return false;
	}
    }
    public boolean checkLoser(int x, int y){
	try{
	    if (board[x][y] == opp){
		return true;
	    }
	    else{
		return false;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){
	    return false;
	}
    }
    public boolean winner(){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if (board[i][j]==sym){  
		    if(checkWinner(i + 1, j) && checkWinner(i-1,j)){
			return true;
		    }
		    else if(checkWinner(i, j+1) && checkWinner(i, j-1)){
			return true;
		    }
		    else if(checkWinner(i+1, j+1) && checkWinner(i-1, j-1)){
			return true;
		    }
		    else if(checkWinner(i-1, j+1) && checkWinner(i+1, j-1)){
			return true;
		    }
		    else if(checkWinner(i-2, j+2) && checkWinner(i-1, j+1)){
			return true;
		    }
		    else if(checkWinner(i-1, j-1) && checkWinner(i-2, j-2)){
			return true;
		    }
		    else if(checkWinner(i+2, j+2) && checkWinner(i+1, j+1)){
			return true;
		    }
		    else if(checkWinner(i-1, j+1) && checkWinner(i+2, j-2)){
			return true;
		    }
		   
		}
	    }
	}
	return false;
    }
		
    public boolean loser(){
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		if(board[i][j]==opp){
		    if(checkLoser(i+1, j) && checkLoser(i-1,j)){
			return true;
		    }
		    else if(checkLoser(i, j+1) && checkLoser(i, j-1)){
			return true;
		    }
		    else if(checkLoser(i+1,j+1) && checkLoser(i-1, j-1)){
			return true;
		    }
		    else if(checkLoser(i-1, j+1) && checkLoser(i+1,j-1)){
			return true;
		    }
		    else if(checkLoser(i-2, j+2) && checkLoser(i-1, j+1)){
			return true;
		    }
		    else if(checkLoser(i-1, j-1) && checkLoser(i-2, j-2)){
			return true;
		    }
		    else if(checkLoser(i+2, j+2) && checkLoser(i+1, j+1)){
			return true;
		    }
		    else if(checkLoser(i-1, j+1) && checkLoser(i+2, j-2)){
			return true;
		    }
		}
	    }
	}
	return false;
    }
    public void c4screen(){
	pt=new JPanel();
	
    }
	 
    public void connectfour(){
	title.setText("ConnectFour");
	scorelabel.setText("Player: " + username +"        SCORE: "+ c4score + "  ");
	pt = new JPanel();
	pt.setBackground(Color.orange);
	
	connect4= new JPanel(new BorderLayout(3,3));
	connect4.setBackground(Color.yellow);
	connect4.setPreferredSize(new Dimension(500,300));
	JButton[][] boardsq = new JButton[6][7];

	Board = new JPanel(new GridLayout(6,7));
	Board.setBackground(null);
	Board.setBorder(new LineBorder(Color.BLACK));
	cboard = new String[6][7];

	
	ct1= new JButton();
	ct2= new JButton();
	ct3= new JButton();
	ct4= new JButton();
	ct5= new JButton();
	ct6= new JButton();
	ct7= new JButton();
	activate(ct1);
	activate(ct2);
	activate(ct3);
	activate(ct4);
	activate(ct5);
	activate(ct6);
	activate(ct7);
	boardsq[0][0] =ct1;
	boardsq[0][1] = ct2;
	boardsq[0][2] = ct3;
	boardsq[0][3] = ct4;
	boardsq[0][4] = ct5;
	boardsq[0][5] = ct6;
	boardsq[0][6] = ct7;
	for (int j =0; j<7; j++){
	    boardsq[0][j].setBorder(new LineBorder(Color.BLACK));
	    boardsq[0][j].setBackground(Color.yellow.darker());
	    Board.add(boardsq[0][j]);
    	    boardsq[0][j].setEnabled(true);
	}	
    
	for (int i = 1; i < 6; i++){
	    for (int j =0; j<7; j++){
	        cboard[i][j] = "";
		JButton x = new JButton("");
		x.setBorder(new LineBorder(Color.BLACK));
		x.setBackground(Color.yellow);
		Board.add(x);
	
		x.setEnabled(false);
		boardsq[i][j] = x;
	
	    }
	}
	
    

	//buttons for connect4 screen
	c1= new JButton("Restart");
	cq2= new JButton("Quit");
	activate(c1);
	activate(cq2);
	connect4.add(Board);	
	pt.add(connect4);
	center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	center.add(connect4);
	center.add(Box.createVerticalGlue());

	center.add(new newline());
	center.add(Box.createVerticalGlue());
	Box h = Box.createHorizontalBox();
	h.add(Box.createHorizontalGlue());
	h.add(c1);
	h.add(cq2);
	h.add(Box.createHorizontalGlue());
	center.add(h);
	center.add(Box.createVerticalGlue());
	pt.add(center);

	frame.getContentPane().add(pt,BorderLayout.CENTER);
      
    }

    public void trivia(){
	title.setText("Trivia");
	trfa = new ButtonGroup();
	tr= new JRadioButton("True");
	tr.setBackground(null);
	fa = new JRadioButton("False");
	fa.setBackground(null);
	trfa.add(tr);
	trfa.add(fa);
	scorelabel.setText("Player: " + username +"        SCORE: "+ triviascore + "  ");
	pt= new JPanel();
	pt.setBackground(new Color(32,178,170));
	
	tf = new TrueOrFalse();
	tf.setQuestions();
	JTextArea q = new JTextArea(tf.askQuestion());
	activate(q);
	q.setFont(new Font("Arial", Font.BOLD, 17));

	center = Box.createVerticalBox();
	center.add(new newline());    
	center.add(new newline());    
	center.add(new newline());
	center.add(new newline());
	center.add(q);
	center.add(new newline());
	center.add(tr);
	center.add(fa);
	center.add(new newline()); 
	submit= new JButton("Submit");
	p2= new JButton("Quit");
	activate(submit);
	activate(t2);
	Box h = Box.createHorizontalBox();
	h.add(Box.createHorizontalGlue());
	h.add(submit);
	h.add(Box.createHorizontalGlue());
	h.add(t2);
	h.add(Box.createHorizontalGlue());
	center.add(h);
	pt.add(center, BorderLayout.CENTER);
	center.add(new newline());
	frame.add(pt,BorderLayout.CENTER);
	
	frame.getContentPane().add(pt,BorderLayout.CENTER);
	
	
	
    }
    public void scores(){
	title.setText("HIGH SCORES");
	scorelabel.setText("Player: " + username);	
	pt= new JPanel();
	pt.setBackground(Color.pink.darker());

	JPanel hsboard = new JPanel(new GridLayout(10,3));
	
	Profile[] ttt = new Profile[7];
	Profile[] cf = new Profile[7];
	Profile[] tq = new Profile[7];
	PriorityQueue<Profile> e =  tichs;
	PriorityQueue<Profile> w =  c4hs;
	PriorityQueue<Profile> q =  qhs;
	
	for (int i = 0; i < 9; i++){
	    tichs.add(new Profile("Anonymous",0));
	    c4hs.add(new Profile("Anonymous",0));
	    qhs.add(new Profile("Anonymous",0));
	 }
	for (int i =0; i < 7; i++){
	    ttt[i] = tichs.poll();
	    cf[i]= c4hs.poll();
	    tq[i] = qhs.poll();
	}
	for (int i =0; i < 7; i++){
	    tichs.add(ttt[i]);
	    c4hs.add(cf[i]);
	    qhs.add(tq[i]);
	}
	
	JLabel l =new JLabel("Tic-Tac-Toe");
	JLabel k = new JLabel("Simplified Connect4");
	JLabel j = new JLabel("Trivia Questions");
	hsboard.add(l);
	hsboard.add(k);
	hsboard.add(j);
	l.setFont(new Font("Arial", Font.BOLD, 17));
	k.setFont(new Font("Arial", Font.BOLD, 17));
	j.setFont(new Font("Arial", Font.BOLD, 17));
	for (int i = 0; i < 6; i++){
	    hsboard.add(new JLabel(ttt[i].toString()));
	    hsboard.add(new JLabel(cf[i].toString()));
	    hsboard.add(new JLabel(tq[i].toString()));
	}
	t2= new JButton("Main Menu");
	prof= new JButton("Change Profile");
	activate(t2);
	activate(prof);
	center = Box.createVerticalBox();
	center.add(Box.createVerticalGlue());
	center.add(new newline());
	center.add(hsboard);
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
	JTextArea startblurb= new JTextArea("Please create a profile by entering a valid username. A profile is needed in order for you to use our Game Center. This profile will allow you to claim high scores as your own.");
	activate(startblurb);	
	uname = new JTextField("Enter Username", 14);
	activate(uname);
	uname.setBorder(new LineBorder(Color.BLACK));
	JTextArea u = new JTextArea("UserName: ");
	activate(u);
	u.setLineWrap(false);
	center.add(startblurb);
	center.add(new newline());
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
	JTextArea startblurb= new JTextArea("Please create a profile by entering a valid username. A profile is needed in order for you to use our Game Center. This profile will allow you to claim high scores as your own.");
	activate(startblurb);	
	uname = new JTextField("", 14);
	activate(uname);
	uname.setBorder(new LineBorder(Color.BLACK));
	JTextArea u = new JTextArea("UserName: ");
	activate(u);
	u.setLineWrap(false);
	center.add(startblurb);
	center.add(new newline());
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
    private void activate(JRadioButton x){
	x.setEnabled(true);
	Events e1 = new Events();
	x.addActionListener(e1);
    }
    public class newline extends JTextArea{
	public newline(){
	    this.setText("");
	    this.setBackground(null);
	    this.setEditable(false);
	    this.setFont(new Font("Serif", Font.BOLD, 20));
	}
    } 
    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

		
   
    public static void main(String[]args){
	GUI x = new GUI();
	
	/*add algorithms above as GUI methods
	  menu options above.
	*/

    }
}
	    