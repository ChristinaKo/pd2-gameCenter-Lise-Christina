import java.util.*;
public class maxtomin implements Comparator<Profile>{ 
    public int compare(Profile o1,Profile o2){
	return -1 * o1.compareTo(o2);
    }
    public boolean equals(Object o1){
	return this==o1;//compare(this,o1) == 0;
    }
}