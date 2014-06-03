import java.util.*;
import java.io.*;

public class Tic{
    String name;
    String chara;
    String[][] board = new String[3][3];
    public Tic(String n, String c){
	chara = c;
	name = n;
    }

    public void move(){
	
    }
    public void play(){
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