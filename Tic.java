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
    public Char getChar(){
	return chara;
    }
    public void move(int x, int y){
	if(board[x][y].equals('\0')){
	    board[x][y] = getChar();
	}
	else{
	    
	    System.out.println("NO");
	}	    
    }
    public boolean isChar(int i, int j){
	if (board[i][j] == getChar){
	    return true;
	}
	else{
	    return false;
	}
    }
    public boolean winner(){
    }
		    
	
    public void play(){
	while(!winner()){
	    move();
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