import java.util.*;
import java.io.*;

public class Tic{
    String name;
    char charP, charO;
    int score;
    char[][] board = new char[3][3];
    public Tic(String n, char c){
	charP = c;
	name = n;
	score = 0;
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
    public void OMoveEasy(){
	for(int i = 0; i <board.length; i ++){
	    for (int j = 0; j < board[i].length; j++){
		if(board[i][j] == '\0'){
		    board[i][j] = getCharO();
		}
	    }
	}
    }
    public void Omove(){
	boolean moved = false;
	for (int i = 0; i < board.length; i++){
	    for(int j = 0; j <board[i].length; j++){
		if(board[i][j] == getCharP()){
		    if(i + 1 < board.length){
			if(board[i +1][j] == getCharP()){
			    if( i - 1 >=0){
				if(board[i-1][j] == '\0'){
				    board[i-1][j] = getCharO();
				    moved = true;
				    break;
				}
			    }
			    else{
				board[i+2][j] = getCharO();
			    }
			}
			if( j + 1 <board[i].length){
			    if(board[i + 1][j+1] == getCharP()){
				if( i-1 >= 0 && j -1 >= 0){
				    if(board[i-1][j-1] == '\0'){
					board[i-1][j-1] = getCharO();
					moved = true;
					break;
				    }
				}
				else{
				    if(board[i+2][j+2] == '\0'){
					board[i+2][j+2] = getCharO();
					moved = true;
					break;
				    }
				}
			    }
			    else if(j-1 == 0){
				if(board[i][j-1] == '\0'){
				    board[i][j-1] = getCharO();
				    moved = true;
				    break;
				}
				else{
				    if(board[i][j+2] == '\0'){
					board[i][j+2] = getCharO();
					moved = true;
					break;
				    
				    }
				}
			    }
			}
		    }
		}
	    }
	}
	if(!moved){
	    for(int i = 0; i <board.length; i++){
		for(int j = 0; j <board[i].length; j ++){
		    if(board[i][j] =='\0'){
			board[i][j] = getCharO();
			break;
		    }
		}
	    }
	}
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
	    System.exit(0);
	}
	else{

	    Scanner sc = new Scanner(System.in);
	    System.out.println("Choose your X-coordinate"); // change
	    String locx = sc.nextLine();
	    System.out.println("Choose your Y-coordinate");
	    String locy = sc.nextLine();
	    Pmove(Integer.parseInt(locx), Integer.parseInt(locy));
	    System.out.println(this);
	    OMoveEasy();
	    System.out.println(this);
	}
    }
    public boolean winner(){
	boolean ans = false;
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if (board[i][j]==getCharP()){  
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
	//add score component
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