import java.io.*;
import java.util.*;

public class TrueOrFalse{
    String name;
    String qans;
    String quest;
    ArrayList <String> questions = new ArrayList<String>();
    public TrueOrFalse(String n){
	name = n;
    }
    public TrueOrFalse(){
    }
    public void  setQuestions(){
	try{
	    Scanner sc = new Scanner(new File("test.txt"));
	    while(sc.hasNext()){
		questions.add(sc.nextLine());
	    }
	}
	catch(FileNotFoundException e){
	}
    }
    public String askQuestion(){
	Random r = new Random();
	setQuestions();
	int queNum = r.nextInt(questions.size());
	String[] parts = questions.get(queNum).split(",");
	quest = parts[0];
	qans = parts[1];
	return quest;
    }
    public boolean checkAnswer(String ans){
	if(ans.toUpperCase().equals(qans.toUpperCase())){
	    return true;
	}
	return false;
    }
    public void play(){
	if(/*score*/ 1 == 100){
	    System.out.println("COngratulations");
	    System.exit(0);
	}
	else{
	    System.out.println(askQuestion());
	    Scanner sc = new Scanner(System.in);
	    System.out.println("True or False");
	    String ans = sc.nextLine();
	    if(checkAnswer(ans)){
		
		System.out.println("Correct");
	    }
	    else{
		System.out.println("Incorrect");
	    }
	}
    } 
    public static void main(String[] args){
	TrueOrFalse n = new TrueOrFalse();
	while(1==1){
	    n.play();
	}
    }
}