import java.util.*;
import java.io.*;

public class Tic{
    String name;
    char chara;
    char[][] board = new char[3][3];
    public Tic(String n, char c){
	chara = c;
	name = n;
    }
    public char getChar(){
	return chara;
    }
    public void move(int x, int y){
	if(board[x][y] ==  '\0' ){
	    board[x][y] = getChar();
	}
	else{
	    
	    System.out.println("NO");
	}	    
    }
    public boolean checkWinner(int x, int y){
	if (board[x][y] == getChar()){
	    return true;
	}
	else{
	    return false;
	}
    }
    public boolean winner(){
	int x = 0;
	int y =0;
	boolean ans = false;
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if (board[i][j]==getChar()){
		    x = i;
		    y=j;
		    if(checkWinner(x + 1, j) && checkWinner(x-1,j)){
			return true;
		    }
		    else if(checkWinner(x, j+1) && checkWinner(x, j-1)){
			return true;
		    }
		    else if(checkWinner(x+1, j+1) && checkWinner(x-1, j-1)){
			return true;
		    }
		    else if(checkWinner(x-1, j+1) && checkWinner(x+1, j-1)){
			return true;
		    }
		}

	    }

	}
	return false;
    }
		    
       
    public String toString(){
	String s = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if(board[i][j] == '\0'){
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