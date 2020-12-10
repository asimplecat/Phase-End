import java.util.Scanner;

public class Displayer 
{
	private LockedMe lock;
	private Scanner scan;
	
	public Displayer()
	{
		this.lock = new LockedMe();
		
		scan = new Scanner(System.in);
	}
	
	public void intro()
	{
		System.out.println("Hi and welcome to LockedMe.com");
		System.out.println("Author: Daniel Fabregat");
		System.out.println("This application will show options available at each point in the program, "
				+ "from there you can select your choice by typing in a number");
	}
	
	public void mainDisplay()
	{
		int choice = -1;
		
		while(choice != 3)
		{
			System.out.println("Options are as follows:");
			System.out.println("1) Retrieve all Files");
			System.out.println("2) Edit File List");
			System.out.println("3) close program");
			
			choice = scan.nextInt();
			
			switch(choice)
			{
				case 1:{
					lock.displayFiles();
					break;
				}
				case 2:{
					businessLogic();
					break;
				}
				case 3: {
					System.out.println("Thank you for using this program, Goodbye");
					System.exit(0);
				}
				default: System.out.println("Sorry invalid input, please try again");
			}
		}
	}
	
	public void businessLogic()
	{
		int choice = -1;
	
		while(choice != 4)
		{
			System.out.println("Hi and welcome to the business logic menu, your options are as follows:");
			System.out.println("1) add a file to the file list");
			System.out.println("2) remove a file from the file list");
			System.out.println("3) search for a file in the file list");
			System.out.println("4) return to main context");
		
			choice = scan.nextInt();
			
			switch(choice){
				case 1:{
					System.out.println("Which file would you like to add");
					String userInput = scan.next();
					lock.addFile(userInput);
					break;
				}
				case 2:{
					System.out.println("Which file would you like to delete");
					String userInput = scan.next();
					lock.deleteFile(userInput);
					break;
				}
				case 3: {
					System.out.println("Which file would you like to search for");
					String userInput = scan.next();
					lock.searchFile(userInput);
					break;
				}
				case 4: {
					System.out.println("Going back to main context");
					break;
				}
				default: System.out.println("Sorry invalid input, please try again");
			}
		}
	}
	
	public void run()
	{
		intro();
		mainDisplay();
	}
}
