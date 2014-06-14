import java.util.*;

public class Profile implements Comparable<Profile> {
    int score;
    String name;
    public Profile(){
	name = "Anonymous";
	score = 0;
    }
    public Profile(String name, int score){
	this.name=name;
	this.score = score;
    }
    public int compareTo(Profile o1){
	return this.score - o1.score;
    }
    public String toString(){
	return name;
    }
    public static class maxtomin implements Comparator<Profile>{ 
	public int compare(Profile o1,Profile o2){
	    return -1 * o1.compareTo(o2);
	}
	public boolean equals(Object o1){
	    return this==o1;//compare(this,o1) == 0;
	}
    }
    public static void main(String[]args){
	PriorityQueue<Profile> x = new PriorityQueue<Profile>(1, new maxtomin());
	x.add(new Profile());
	System.out.println(x.peek());
	x.add(new Profile("A ",4672320));
	x.add(new Profile("B ",2320));
	x.add(new Profile("C ",120));
	x.add(new Profile("D ",10));
	System.out.println(x.peek());
	x.poll();      
	System.out.println(x.peek());
	x.poll();      
	System.out.println(x.peek());

	

    }
    
}