import java.io.*;
import java.util.*;

public class Connect4{
    boolean color;
    int score;
    String name;
    String[][] cboard= new String[6][7];
    public Connect4(String n,boolean c){
	color = c;
	name = n;
	score = 0;
    }
    public String getPColor(){
	if (color ){
	    return "red";
	}
	else{
	    return "black";
	}
	
    }
    public String getOColor(){
	if(getPColor().equals("red")){
	    return "black";
	}
	else{
	    return "red";
	}
    }
		  
    public boolean PMove(int x, int y){
	if(cboard[x][y] == null){
	    if(x == 0){
	    cboard[x][y] = getPColor();
	    return true;
	    }
	    
	    else if(x>0 && cboard[x-1][y]!=null){
		cboard[x][y] = getPColor();
		return true;
	    }
	    else{
		System.out.println("NOOO");
		return false;
	    }
	}
	
	else{
	    System.out.println("Please try again");
	    return false;
	}
	

    }
    public void OMove(){
	for(int i = 0; i < cboard.length; i++){
	    for(int j = 0; j < cboard[i].length; j++){
		if(cboard[i][j]== null){
		    cboard[i][j] = getOColor();
		    return;
		}
	    }
	}
    }
    public boolean cwinner(){
	for(int i = 0; i < cboard.length; i++){
	    for(int j = 0; j < cboard[i].length; j++){
		if (cboard[i][j]==getPColor()){
		    //add the check winner methods that would decide if you had won or not
		    if (checkWinner(i+2, j) && checkWinner(i+1,j) && checkWinner(i-1, j)){
			return true;
		    }
		    else if (checkWinner(i, j+2) && checkWinner(i, j+1) && checkWinner(i, j-1)){
			return true;
		    }
		    else if (checkWinner(i+2, j+2) && checkWinner(i+1, j+1) && checkWinner(i-1, j-1)){
			return true;
		    }
		    else if (checkWinner(i-2, j+2) && checkWinner(i-1, j+1) && checkWinner(i+1,j-1)){
			return true;
		    }
		}
	    }

	}
	return false;
    }
    public boolean closer(){
	for(int i = 0; i < cboard.length; i++){
	    for(int j = 0; j < cboard[i].length; j++){
		if (cboard[i][j]==getPColor()){
		    
		    if (checkCloser(i+2, j) && checkCloser(i+1,j) && checkCloser(i-1, j)){
			return true;
		    }
		    else if (checkCloser(i, j+2) && checkCloser(i, j+1) && checkCloser(i, j-1)){
			return true;
		    }
		    else if (checkCloser(i+2, j+2) && checkCloser(i+1, j+1) && checkCloser(i-1, j-1)){
			return true;
		    }
		    else if (checkCloser(i-2, j+2) && checkCloser(i-1, j+1) && checkCloser(i+1,j-1)){
			return true;
		    }
		}
	    }

	}
	return false;
    }

    public boolean checkWinner(int x, int y){
	try{
	    if (cboard[x][y] == getPColor()){
		return true;
	    }
	    else{
		return false;
	    }
	}
	catch(IndexOutOfBoundsException e){
	    return false;	    
	}
    }
  public boolean checkCloser(int x, int y){
	try{
	    if (cboard[x][y] == getOColor()){
		return true;
	    }
	    else{
		return false;
	    }
	}
	catch(IndexOutOfBoundsException e){
	    return false;	    
	}
    }

    public void play(){
	if(cwinner!()){
	    System.out.println("Congratulations");
	    System.exit(0);
	}
	else if(closer()){
	    System.out.println("sorry");
	    System.exit(0);
	}
	else{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Choosed your x-coordinate");
	    String locx = sc.nextLine();
	    System.out.println("Choose your Y-coordinate");
	    String locy = sc.nextLine();
	    if(PMove(Integer.parseInt(locx), Integer.parseInt(locy))){
		System.out.println(this);
		OMove();
		System.out.println(this);
	    }
	    else{
		play();
	    }
	}
    }
    public String toString(){
	String s = "";
	for(int i= cboard.length-1; i>=0; i--){
	    for(int j = cboard[i].length-1; j>=0; j--){
		if(cboard[i][j] == null){
		    s = s + "  *   ";
		}

		else{
		    s = s + cboard[i][j] + " ";
		}
	    }
	    s = s +"\n";
	}
	return s;

    }
    public static void main(String[] args){
	Connect4 c = new Connect4("C",true);
	System.out.println(c);
	while(1==1){
	    c.play();
	}
    }
}
