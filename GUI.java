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
    public class MyPanel extends JPanelGradient{
	public void paintChildren(Graphics g){
	    
	}
	
    }
    protected JButton startb,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    protected JButton t1,t2;
    protected JFrame frame;

    protected JPanel menubar;
    protected JMenuBar Title;
    protected JLabel title;

    protected JPanelGradient panel;
    protected JPanel bp;
    protected JPanel gamep, pt,p; 

     public GUI(){
	 //initial state -> title page
	 frame = new JFrame("Game Center");
	 frame.setSize(500,500);
	 frame.setLocationRelativeTo(null);
	 frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	 Title= new JMenuBar();
	 Title.setOpaque(true);
	 Title.setBackground(Color.red);
	 Title.setPreferredSize(new Dimension(10,20));

	 menubar= new JPanel();
	 menubar.setBackground(null);
	 title = new JLabel("Welcome to Game Center");
	 title.setBackground(null);
	 title.setHorizontalTextPosition(SwingConstants.CENTER);
	 title.setVerticalTextPosition(SwingConstants.CENTER);
	 menubar.add(title);
	 Title.add(menubar);
	
	 
	 panel = new JPanelGradient();
	 panel.setOpaque(true);
	 panel.setBackground(new Color(0,2,123));
	 panel.setPreferredSize(new Dimension(200,380));
	
		
	
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
		 
		 }
		 else if (e1.getSource() == t1){



		 }
		 else if (e1.getSource() == t2){
		     pt.removeAll();
		     pt.revalidate();
		     frame.remove(pt);
		     mainscreen();		    
		 }
		 //		else if (e1.getSource() == b3){
		 //		}

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
	 
	 gamep.add(b1);
	 gamep.add(b2);
	 gamep.add(b3);
	 
	 activate(b1);
	 activate(b2);
	 activate(b3);
	 /*
	   JPanel gui = new JPanel(new BorderLayout(3,3));
	   JButton[][] boardsq = new JButton[3][3];
	   JPanel ticBoard;
	
	   ticBoard = new JPanel(new GridLayout(0,9));
	   ticBoard.setBorder(new LineBorder(Color.BLACK));
	
	   frame.add(gui);
	   gui.add(ticBoard);
	 */
    }


    public void tictac(){
	/* turn off and turn on the buttons 
	deactivate(b1);
	deactivate(b2);
	deactivate(b3);
	*/
	title.setText("Tic-Tac-Toe");
	pt = new JPanel();
	
	
	JTable board = new JTable(3,3);
	
	pt.setBackground(Color.magenta.darker());
	frame.getContentPane().add(board);
	board.setGridColor(Color.black);
	board.setRowHeight(100);
	TableColumn column;
	for (int i =0; i <3; i++){
	    column=board.getColumnModel().getColumn(i);
	    column.setPreferredWidth(100);
	}
			      
	frame.getContentPane().add(pt);
	pt.add(board, BorderLayout.CENTER);
	pt.add(new Label("\n"));
	
	t1= new JButton("Restart");
	t2= new JButton("Quit");

	pt.add(t1, BorderLayout.SOUTH);
	pt.add(t2,BorderLayout.SOUTH);

	activate(t1);
	activate(t2);


    }

    public void connectfour(){
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


    public void gamethree(){
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
    public void activate(JButton button){
	button.setEnabled(true);
	button.setVisible(true);
	Events e1 = new Events();
	button.addActionListener(e1);
    }

    public void deactivate(JButton button){
	button.setVisible(false);
	button.setEnabled(false);	
    }

  
    public static void main(String[]args){
	GUI x = new GUI();
	
	/*add algorithms above as GUI methods
	  meanu options above.
	*/

    }
}
	    