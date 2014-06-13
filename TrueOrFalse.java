import java.io.*;
import java.util.*;

public class TrueOrFalse{
    String name;
    int score;
    String ans;
    ArrayList <String> questions = new ArrayList<String>();
    public TrueOrFalse(String n){
	score = 0;
	name = n;
    }
    public String question(){
	Scanner sc = new Scanner(new File("test.csv"));
	while(sc.hasNext()){
	    ArrayList.add(sc.next());
	}
	
	return    
	
    }
    public boolean checkAnswer(String ans){
	if(ans.equals(qans)){
	    //score  = score + 20;
	    return true;
	}
}