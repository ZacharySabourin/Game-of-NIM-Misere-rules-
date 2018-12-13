import java.util.Scanner;
import java.util.Random;

public class Nim {
	
	//Declaring pile objects to be used in the Nim class
	private Pile pileA;	
	private Pile pileB;
	private Pile pileC;
	
	//Declaring and initializing objects of type Random and Scanner
	private Random rnd = new Random();
	private Scanner input = new Scanner(System.in);
	
	//Allows me to construct a game of Nim using the three piles declared
	//I determine the size of the piles using the random object
	//Max value of 20 and min value of 10
	public Nim() {
		pileA = new Pile(rnd.nextInt(11) + 10);
		pileB = new Pile(rnd.nextInt(11) + 10);		
		pileC = new Pile(rnd.nextInt(11) + 10);
	}
	
	//This method handles all of the logic during the player's turn
	public boolean playerMove() {
		int numChoice;	//Declare an integer to store the value of the player's choice
		int sizeA = pileA.getSize();	//Returns the value of pile A and stores it into an integer
		int sizeB = pileB.getSize();	//Returns the value of pile B and stores it into an integer
		int sizeC = pileC.getSize();	//Returns the value of pile C and stores it into an integer
	
		printPiles();	//Display the status of the piles at the beginning of the turn
		
		System.out.print("\n\nSelect a pile: ");	//Ask the user to choose a pile
		char letterChoice = input.next().charAt(0);	//Reads the player's input and stores it into a variable of type char
					
		if(letterChoice == 'a' || letterChoice == 'A') {
			if(sizeA == 0) {
				System.out.print("This pile is empty");
				return false;
			}
			
			System.out.print("Select a number: ");
			numChoice = input.nextInt();
			
			if(numChoice < 1 || numChoice > sizeA) {
				System.out.print("Invalid choice");
				return false;
			}
			else {
				pileA.remove(numChoice);
				return true;
			}
		}
		
		else if(letterChoice == 'b' || letterChoice == 'B') {
			if(sizeB == 0 && (letterChoice == 'b' || letterChoice == 'B')){
			System.out.print("This pile is empty");
			return false;
			}
			
			System.out.print("Select a number: ");
			numChoice = input.nextInt();
			
			if(numChoice < 1 || numChoice > sizeB) {
				System.out.print("Invalid choice");
				return false;
			}
			else {
				pileB.remove(numChoice);
				return true;
			}
		}
		
		else if(letterChoice == 'c' || letterChoice == 'C'){
			if(sizeC == 0 && (letterChoice == 'c' || letterChoice == 'C')){
			System.out.print("This pile is empty");
			return false;
			}
			
			System.out.print("Select a number: ");
			numChoice = input.nextInt();
			
			if(numChoice < 1 || numChoice > sizeC) {
				System.out.print("Invalid choice");
				return false;
			}
			else {
				pileC.remove(numChoice);
				return true;
			}
		}
		
		else {
			System.out.print("Invalid pile");
			return false;
		}
	}
	
	//This method handles all of the computers logic
	public void computerMove() {
		int sizeA = pileA.getSize();	//Returns the value of pile A and stores it into an integer
		int sizeB = pileB.getSize();	//Returns the value of pile B and stores it into an integer
		int sizeC = pileC.getSize();	//Returns the value of pile C and stores it into an integer
		int nimOfPiles = sizeA ^ sizeB ^ sizeC;	//Calculates the nim-sum of all 3 piles
		int amtTaken;	//Declares an integer to store the value of the computer's choice
		
		printPiles();	//Print the piles to start the turn
		
		//Based on the logic behind a winning strategy, if the nim-sum of all 3 piles is 0, there is no move that can be made to keep the nim-sum at 0
		//In this case, the computer moves randomly
		if(nimOfPiles == 0) {
			
			//This makes sure it doesn't pick pile A if it is empty
			if(sizeA == 0) {
				int letterChoice = rnd.nextInt(2) + 1;	//Determines the computer's choice randomly between 1 and 2 inclusively
				
				switch(letterChoice) {
				
					//If the number is 1, it then picks a random but valid value and removes it from pile B
					case 1: 
						int numChoiceB = rnd.nextInt(sizeB) + 1;
						pileB.remove(numChoiceB);	
						System.out.print("\nThe computer removed " + numChoiceB + " from pile B");
				
					//If the number is 2, it then picks a random but valid value and removes it from pile C
					case 2: 
						int numChoiceC = rnd.nextInt(sizeC) + 1;
						pileC.remove(numChoiceC);
						System.out.print("\nThe computer removed " + numChoiceC + " from pile C");
				}	
			}
			
			//This makes sure it doesn't pick pile B if it is empty
			else if(sizeB == 0) {
				int letterChoice = rnd.nextInt(2) + 1;	//Determines the computer's choice randomly between 1 and 2 inclusively
				
				switch(letterChoice) {
				
					//If the number is 1, it then picks a random but valid value and removes it from pile A
					case 1: 
						int numChoiceA = rnd.nextInt(sizeA) + 1;
						pileA.remove(numChoiceA);	
						System.out.print("\nThe computer removed " + numChoiceA + " from pile A");
				
					//If the number is 2, it then picks a random but valid value and removes it from pile C
					case 2: 
						int numChoiceC = rnd.nextInt(sizeC) + 1;
						pileC.remove(numChoiceC);
						System.out.print("\nThe computer removed " + numChoiceC + " from pile C");
				}
			}
			
			//This makes sure it doesn't pick pile C if it is empty
			else if(sizeC == 0) {
				int letterChoice = rnd.nextInt(2) + 1;	//Determines the computer's choice randomly between 1 and 2 inclusively
				
				switch(letterChoice) {

					//If the number is 1, it then picks a random but valid value and removes it from pile A
					case 1: 
						int numChoiceA = rnd.nextInt(sizeA) + 1;
						pileA.remove(numChoiceA);	
						System.out.print("\nThe computer removed " + numChoiceA + " from pile A");
			
					//If the number is 2, it then picks a random but valid value and removes it from pile B
					case 2: 
						int numChoiceB = rnd.nextInt(sizeB) + 1;
						pileB.remove(numChoiceB);
						System.out.print("\nThe computer removed " + numChoiceB + " from pile B");
				}
					
			}
			
			//If none are empty, do whatever
			else {
				int letterChoice = rnd.nextInt(3) + 1;	//Determines the computer's choice randomly between 1 and 3 inclusively
				
				switch(letterChoice) {
				
					//If the number is 1, it then picks a random but valid value and removes it from pile A
					case 1: 
						int numChoiceA = rnd.nextInt(sizeA) + 1;
						pileA.remove(numChoiceA);	
						System.out.print("\nThe computer removed " + numChoiceA + " from pile A");
				
					//If the number is 2, it then picks a random but valid value and removes it from pile B
					case 2: 
						int numChoiceB = rnd.nextInt(sizeB) + 1;
						pileB.remove(numChoiceB);
						System.out.print("\nThe computer removed " + numChoiceB + " from pile B");
						
					case 3: 
						int numChoiceC = rnd.nextInt(sizeC) + 1;
						pileC.remove(numChoiceC);
						System.out.print("\nThe computer removed " + numChoiceC + " from pile C");
				}
			}			
		}
		
		//If there are 2 piles with only 1 left and another with more than 1, the winning strategy is to bring the third pile down to 1
		//This forces the user to pick the last pile and lose
		//This section handles all 3 possible cases
		else if(sizeA > 1 && sizeB == 1 && sizeC == 1) {
			amtTaken = sizeA - 1;
			pileA.remove(amtTaken);
			System.out.print("\nThe computer removed " + amtTaken + " from pile A");
		}
		
		else if(sizeB > 1 && sizeA == 1 && sizeC == 1) {
			amtTaken = sizeB - 1;
			pileB.remove(amtTaken);
			System.out.print("\nThe computer removed " + amtTaken + " from pile B");
		}
		
		else if(sizeC > 1 && sizeA == 1 && sizeB == 1) {
			amtTaken = sizeC - 1;
			pileC.remove(amtTaken);
			System.out.print("\nThe computer removed " + amtTaken + " from pile C");
		}
		
		//If there is an empty pile a pile greater than or equal to 1 and another pile with 1 remaining, the winning strategy is to remove the entirety of the pile that is greater than or equal to 1
		//This leaves the user with only one option. The player then loses
		//This section covers all of those cases
		else if(sizeA >= 1 && sizeB == 0 && sizeC ==1) {
			amtTaken = sizeA;
			pileA.remove(sizeA);
			System.out.print("\nThe computer removed " + amtTaken + " from pile A");
		}
		
		else if(sizeA >= 1 && sizeC == 0 && sizeB ==1) {
			amtTaken = sizeA;
			pileA.remove(sizeA);
			System.out.print("\nThe computer removed " + amtTaken + " from pile A");
		}
		
		else if(sizeB >= 1 && sizeA == 0 && sizeC ==1) {
			amtTaken = sizeB;
			pileB.remove(sizeB);
			System.out.print("\nThe computer removed " + amtTaken + " from pile B");
		}
		
		else if(sizeB >= 1 && sizeC == 0 &&  sizeA ==1) {
			amtTaken = sizeB;
			pileB.remove(sizeB);
			System.out.print("\nThe computer removed " + amtTaken + " from pile B");
		}
		
		else if(sizeC >= 1 && sizeA == 0 &&  sizeB ==1) {
			amtTaken = sizeC;
			pileC.remove(sizeC);
			System.out.print("\nThe computer removed " + amtTaken + " from pile C");
		}
		
		else if(sizeC >= 1 && sizeB == 0 &&  sizeA ==1) {
			amtTaken = sizeC;
			pileC.remove(sizeC);
			System.out.print("\nThe computer removed " + amtTaken + " from pile C");
		}
		
		//If 2 of the piles are empty, the winning strategy is to take everything except 1 from the remaining pile
		//This leaves the player with only one option. The player then loses
		//If there is only 1 left. the computer has no choice but to take it
		//This section covers all those cases
		else if(sizeB == 0 && sizeC == 0) {
			if(sizeA == 1) {
				amtTaken = 1;
			}
			else{
				amtTaken = sizeA - 1;
			}
			pileA.remove(amtTaken);
			System.out.print("\nThe computer removed " + amtTaken + " from pile A");
		}
		
		else if(sizeA == 0 && sizeC == 0) {
			if(sizeB == 1) {
				amtTaken = 1;
			}
			else{
				amtTaken = sizeB - 1;
			}
			pileB.remove(amtTaken);
			System.out.print("\nThe computer removed " + amtTaken + " from pile B");
		}
		
		else if(sizeA == 0 && sizeB == 0) {
			if(sizeC == 1) {
				amtTaken = 1;
			}
			else{
				amtTaken = sizeC - 1;
			}
			pileC.remove(amtTaken);
			System.out.print("\nThe computer removed " + amtTaken + " from pile C");
		}
		
		//If none of the above conditions have been met, The strategy is to make sure the nim-sum of the piles is 0
		//To do this it calculates the nim-sum of the variable nimOfPiles(calculated above) and the size of each pile 
		//If this result is less than the pile size, it reduces the chosen pile to the calculated nim-sum
		else {
			int nimA = nimOfPiles ^ sizeA;
			int nimB = nimOfPiles ^ sizeB;
			int nimC = nimOfPiles ^ sizeC;
			
			//If the nim-sum of nimOfPiles and pile A is less than the size of pile A, it then reduces pile A to the nim-sum calculated above
			if(nimA < sizeA) {
				amtTaken = sizeA - nimA;
				pileA.remove(amtTaken);
				System.out.print("\nThe computer removed " + amtTaken + " from pile A");
			}
			
			//If the nim-sum of nimOfPiles and pile B is less than the size of pile A, it then reduces pile A to the nim-sum calculated above
			else if(nimB < sizeB) {
				amtTaken = sizeB - nimB;
				pileB.remove(amtTaken);
				System.out.print("\nThe computer removed " + amtTaken + " from pile B");
			}
			
			//If the nim-sum of nimOfPiles and pile C is less than the size of pile A, it then reduces pile A to the nim-sum calculated above
			else {
				amtTaken = sizeC - nimC;
				pileC.remove(amtTaken);
				System.out.print("\nThe computer removed " + amtTaken + " from pile C");	
			}
		}	
	}
	
	//This method evaluates whether or not the game is over
	//if all piles are empty, the game is over
	public boolean done() {				
		if(pileA.getSize() == 0 && pileB.getSize() == 0 && pileC.getSize() == 0) {
			return true;
		}
		return false;	
	}
	
	//This method prints the current status of the piles
	//I used the printf method because it allows me to make neat columns
	public void printPiles() {
		char p1 = 'A';
		char p2 = 'B';
		char p3 = 'C';
		
		System.out.printf("\n%4s %5s %5s", p1, p2, p3);
		System.out.printf("\n%4s %5s %5s", pileA.getSize(), pileB.getSize(), pileC.getSize());
	}
	
}