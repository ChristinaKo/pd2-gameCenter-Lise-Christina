import java.util.*;
import java.io.*;

public class Tic{
    String name;
    char charP, charO;
    char[][] board = new char[3][3];
    public Tic(String n, char c){
	chara = c;
	name = n;
    }
    public char getCharP(){
	return charP;
    }
    public void setCharO(){
	if(getCharP() == 'X'){
	    charO= 'O';
	}
	else{
	    charO = 'X';
	}
    }
    public char getCharO(){
	return charO;
    }
    public void Pmove(int x, int y){
	if(board[x][y] ==  '\0' ){
	    board[x][y] = getCharP();
	}
	else{
	    
	    System.out.println("NO");
	}	    
    }
    public void Omove(){
	for (int i = 0; i < board.length(); i++){
	    for(int j = 0; j <board[i].length(); j ++){
		if(board[i][j] == getCharP()){
		    if(i + 1 < board.length){
			if(board[i +1][j] == getChar()){
			    if( i - 1 >=0){
				if(board[i-1][j] == '\0'){
				    board[i-1][j] = getCharO();
				    break;
				}
			    }
			    else{
				board[i+2][j] = getCharO();
			    }
			}
			if( j + 1 <board[i].length){
			    if(board[i + 1][j+1] == getChar()){
				if( i-1 >= 0 && j -1 >= 0){
				    if(board[i-1][j-1] == '\0'){
					board[i-1][j-1] = getCharO();
					break;
				    }
				}
				else{
				    board[i+2][j+2] = getChar0();
				}
			    }
			}
		    }
		}
	    }
	}
	//continue
			    
		    
    }
    public boolean checkWinner(int x, int y){
	try{
	    if (board[x][y] == getCharP()){
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
	    if (board[x][y] == getCharO()){
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
    public void play(){
	if(winner()){
	    System.out.println("Congratulations!");
	}
	else{
	    // add move method (if index chosen is already occupied prints no but you can edit that)
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Choose your X-coordinate"); // change
	    String locx = sc.nextLine();
	    System.out.println("Choose your Y-coordinate");
	    String locy = sc.nextLine();
	    Pmove(Integer.parseInt(locx), Integer.parseInt(locy));
	    Omove();
	}
    }
    public boolean winner(){
	boolean ans = false;
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if (board[i][j]==getChar()){  
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