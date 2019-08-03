import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;


public class Registration 
{
	/**
	 * You're starting a new job at the PCL and are in charge of 
	 * the online library database. You need to manage a system where
	 * users can check out/check in books
	 * 
	 * */
    static Scanner s = new Scanner(System.in);
	static ArrayList <String> CheckoutList = new ArrayList<String>();
	static ArrayList <String> CheckinList = new ArrayList <String> (); 
	static ArrayList <String> ClientList = new ArrayList <String> (); 

	
	public static void printLibary()
	{
		if(CheckinList.isEmpty() == false)
		{
			for(int i = 0; i<CheckinList.size(); i++)
			{
				System.out.println(i +":Book Name: "+ CheckinList.get(i));
			}
		}
		else
		{
			System.out.println("There is nothing in the libary right now please add books to libary");
		}
	}
	
	public static void printCheckout()
	{
		if(CheckoutList.isEmpty() == false)
		{
			for(int i = 0; i<CheckoutList.size(); i++)
			{
				System.out.println(i +":Client Name "+ ClientList.get(i) + ":Book Name: " +  CheckoutList.get(i));
			}
		}
		else
		{
			System.out.println("There is nothing checked out right now please check out books from the libary");
		}
	}

	public static void main(String[] args)
	{
		int choice = 0;
		String Name = "";
		String Client = "";

		
		
		
		
		System.out.println("Welcome to the libary data base");
		System.out.println("Please select one of the following options");

		while(choice != 6)
		{
			System.out.println("1: Add new book");
			System.out.println("2: remove book");
			System.out.println("3: Check book out");
			System.out.println("4: Check book in");
			System.out.println("5: Display books");
			System.out.println("6: Exit");
			choice = s.nextInt();
			
			
			
			
			switch(choice)
			{
			
			case 1:
				System.out.println("Please enter book Name: ");
				Name = s.next();
				CheckinList.add(Name);
				System.out.println("What is currently in the libary"); 
				System.out.println(CheckinList); 
				break; 
			case 2: 
				System.out.println("Which would You like to remove Please make a selection from the list");
				printLibary();
				System.out.println("Enter removal selection #");
				choice = s.nextInt();
				CheckinList.remove(choice);
				break; 
			case 3:
				System.out.println("Please enter your name: ");
				Client = s.next();
				System.out.println("Which book would You like to check out Please make a selection from the list");
				printLibary();
				System.out.println("Enter check out selection #");
				choice = s.nextInt();
				CheckoutList.add(CheckinList.get(choice));
				ClientList.add(Client);
				System.out.println(Client + " has borrowed " + CheckinList.get(choice));
				CheckinList.remove(choice);
				break;
			case 4:
				System.out.println("Please find your name and book # to check in your book");
				printCheckout();
				System.out.println("Please select the number which corresponds to your name and book to check in: ");
				choice = s.nextInt();
				CheckinList.add(CheckoutList.get(choice));
				System.out.println("Thank you the book has been returned");
				CheckoutList.remove(choice);
				ClientList.remove(choice);
				break;
			case 5:
				System.out.println("These are books in libary: ");
				printLibary();
				System.out.println("These are books checked out: ");
				printCheckout();
				

	
				
			}
		}
		
		
		
		
	}
}
