import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("Hello! What is your name? \n");
	String n = sc.nextLine();
	System.out.println("Welcome to our Tic-Tac-Toe game " + n);
	System.out.println("Would you like to play X or O");
	String ch = sc.nextLine();
	char c = ch.charAt(0);
	Tic newGame = new Tic(n, c);
	

	//	Connect4 newGame = new Connect4("blue");
	//System.out.println(newGame);
    }
}
