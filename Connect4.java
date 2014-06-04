import java.io.*;
import java.util.*;

public class Connect4{
    boolean color;
    String[][] board= new String[7][10];
    public Connect4(String c){
	color = c;
    }
    public String getColor(){
	if (color){
	    return "red";
	}
	else{
	    return "black";
	}
	
    }
    public void move(int x, int y){
	if(board[x][y] == null){
	    board[x][y] = getColor();
	}
	else{
	    System.out.println("Please try again");
	}
    }
  
    public boolean winner(){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if (board[i][j]==getColor()){
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
	return false;
    }

    public boolean checkWinner(int x, int y){
	try{
	    if (board[x][y] == getColor()){
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