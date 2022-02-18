
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
	public static void main(String[] args) {
	Random r=new Random();
	Scanner input= new Scanner(System.in);
	
	String path_s="C:\\Users\\Giulia\\Documents\\Wordle\\words";
	
	Path path=Paths.get(path_s);
	List<String>lines=new ArrayList<>();
	try {	
		lines=Files.readAllLines(path);
	}catch(IOException e) {
		e.printStackTrace();
  }
  
	String word=lines.get(r.nextInt(lines.size()));
	String guess;
	List<Character> found=new ArrayList<>();
	for(int n=6; n>0; n--) {
	System.out.println("Make a guess, you have " + n + " guesses left");
	guess=input.nextLine();
	if(guess.length()!=5) {
		System.out.println("Error, your word must be 5 letters long");
		n++;
		continue;
	}
	if(!lines.contains(guess)) {
		System.out.println("Your word does not exist, try again");
		n++;
		continue;
	}
	if(guess.equals(word)) {
		int p= 6-n+1;
		System.out.println("Yuppie, you got it! It took you "+ p + " tries");
		break;
	}
	char[] c=new char[guess.length()];
	
	for(int i=0; i<5; i++) {
		c[i]=guess.charAt(i);
		if(guess.charAt(i)==word.charAt(i)) {
			
			c[i]=Character.toUpperCase(c[i]); //capitalize letters in right position
		}
		for(int j=0; j<5; j++) {
			if(guess.charAt(i)==word.charAt(j) && j!=i) {
				if(!found.contains(guess.charAt(i))) {
					found.add(guess.charAt(i));
				}
			}
		}
		
	}
	System.out.println(String.valueOf(c));
	if(!found.isEmpty()) {
	System.out.println("You got some letters right:"+ found); //display right letters in wrong position
	}
	found.clear();
System.out.println("Try again");
	
}
	input.close();
	System.out.println("The right word was " + word);
	

}
	
	
}
