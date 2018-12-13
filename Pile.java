public class Pile {
	
	//Declare a variable to store the current size of each pile
	private int size;
	
	//Allows me to construct a pile with a default value of 10
	public Pile() {
		size = 10;
	}
	
	//Allows me to construct a pile using an integer of my choice
	//Then stores the chosen value into the int size
	public Pile(int initialSize) {
		size = initialSize;
	}
	
	//A method that returns the current size of the pile once called upon
	public int getSize() {
		return size;
	}
	
	//A method that allows me to pass through an integer
	//Then removes that value from the size of the pile chosen
	public void remove(int amountTaken) {
		size -= amountTaken;
	}
}
