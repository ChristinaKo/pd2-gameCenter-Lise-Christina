import java.io.*;
import java.util.*;

public class DriverTic{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("Hello! What is your name? \n");
	String n = sc.nextLine();
	System.out.println("Welcome to our Tic-Tac-Toe game " + n);
	System.out.println("Would you like to play X or O");
	char c = sc.nextLine();
	Tic newGame = new Tic(n, c);

	System.out.println(newGame);
    }
}
