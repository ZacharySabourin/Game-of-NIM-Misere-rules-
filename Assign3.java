//Zachary Sabourin
//Lab Section 313
//Jason Mombourquette
//Assignment 3 - Game of NIM
//This program asks the user to compete in a game of NIM(misère rules) against the computer
//10 November, 2018

public class Assign3 {
	public static void main(String[] args) {

		System.out.println("Welcome to the NIM Game");
		System.out.println("We play by the misère rules");

		Nim game = new Nim(); // Declare an object of the Nim class

		boolean playerTurn;	//Declares a boolean to be used to check if th eplayer's turn was successful
		boolean gameOver;	//Declares a boolean to check whether or not the game has ended

		do {	
			do {
				playerTurn = game.playerMove();	//This will execute the playerMove method and store the returned result into a variable
			} while (!playerTurn);	//Until the method returns true(to indicate that the player's turn was successful) it will not continue
			
			gameOver = game.done();	//This checks to see if the game is over. 
				if(gameOver) {
					System.out.print("You lose!");	//If the game is over, it will display a loss message and break out of the loop so as not to execute the computer's turn
					break;
				}
				
			while (playerTurn){	//While the player's turn is successful, executes the computers move and initiates the playerTurn boolean to false(so as to leave the loop)
				game.computerMove();
				playerTurn = false;
			}
			
			gameOver = game.done();	//This checks to see if the game is over.
			if(gameOver) {
				System.out.print("You win!");	//If the game is over, it will display a victory message
			} 		
		} while (!gameOver);	//Until the game is over, this entire block of code will run continuously. 
	}
}