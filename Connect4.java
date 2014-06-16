import java.io.*;
import java.util.*;

public class Connect4{
    boolean color;
    int score;
    String name;
    String[][] board= new String[7][10];
    public Connect4(String n,String c){
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
	if(getPColor.equals("red")){
	    return "black";
	}
	else{
	    return "red";
	}
    }
		  
    public void Pmove(int x, int y){
	if(board[x][y] == null){
	    board[x][y] = getPColor();
	}
	else{
	    System.out.println("Please try again");
	}
    }
    public void Omove(){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if(board[i][j]== null){
		    board[i][j] = getOColor();
		    break;
		}
	    }
	}
    }
    public boolean winner(){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if (board[i][j]==getPColor()){
		    //add the check winner methods that would decide if you had won or not
		    if (checkWinner(x+2, j) && checkWinner(x+1,j) && checkWinner(x-1, j)){
			return true;
		    }
		    else if (checkWinner(x, j+2) && checkWinner(x, j+1) && checkWinner(x, j-1)){
			return true;
		    }
		    else if (checkWinner(x+2, j+2) && checkWinner(x+1, j+1) && checkWinner(x-1, j-1)){
			return true;
		    }
		    else if (checkWinner(x-2, j+2) && checkWinner(x-1, j+1) && checkWinner(x+1,j-1)){
			return true;
		    }
		}
	    }

	}
	// add score componentscore = score + ; 
	return false;
    }

    public boolean checkWinner(int x, int y){
	try{
	    if (board[x][y] == getPColor()){
		return true;
	    }
	    else{
		return false;
	    }
	}
	catch(ArrayIndexOutOfBounds e){
	    return false;	    
	}
    }
  public boolean checkLoser(int x, int y){
	try{
	    if (board[x][y] == getOColor()){
		return true;
	    }
	    else{
		return false;
	    }
	}
	catch(ArrayIndexOutOfBounds e){
	    return false;	    
	}
    }


    public String toString(){
	String s = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if(board[i][j] == null){
		    s = s + "* ";
		}

		else{
		    s = s + board[i][j] + " ";
		}
	    }
	    s = s +"\n";
	}
	return s;

    }
}
