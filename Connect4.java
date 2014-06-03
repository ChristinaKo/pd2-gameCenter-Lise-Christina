import java.io.*;
import java.util.*;

public class Connect4{
    String color;
    String[][] board= new String[7][10];
    public Connect4(String c){
	color = c;
    }
    public String getColor(){
	return color;
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
	int x = 0;
	int y =0;
	boolean ans = false;
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if (board[i][j]==getColor()){
		    //add the check winner methods that would decide if you had won or not
		}
	    }

	}
	return false;
    }


    public boolean checkWinner(int x, int y){
	if (board[x][y] == getColor()){
	    return true;
	}
	else{
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