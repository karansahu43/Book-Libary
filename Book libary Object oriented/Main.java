import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Book b = new Book(1234, "College");
		//System.out.println(b);
	
		int choice = 0;

		Library library = new Library();
		FileWriter w = new FileWriter("output.txt");
		w.write("");
		w.flush();
		
		System.out.println("Welcome to the libary data base");
		System.out.println("Please select one of the following options");

		while(choice != 7)
		{
			System.out.println("1: Add new book");
			System.out.println("2: remove book");
			System.out.println("3: Check book out");
			System.out.println("4: Check book in");
			System.out.println("5: Display books");
			System.out.println("6: view log of transactions");
			System.out.println("7: Exit");
			choice = s.nextInt();
			
			switch(choice)
			{
			
			case 1:

				System.out.println("Please enter book Name: ");
				String title = s.next();
				System.out.println("Please enter book isbn: ");
				int isbn = s.nextInt();
				library.addBooks(isbn, title);
				w.write(title + " was added to libary\n");
				w.flush();
				break; 
			case 2: 
				System.out.println("Which would You like to remove Please make a selection from the list");
				library.display();
				System.out.println("Enter isbn number for removal selection");
				choice = s.nextInt();
				w.write(library.searchBooks(choice) + " was removed from libary\n");
				w.flush();
				library.removeBooks(choice);


				break; 
			case 3:
				System.out.println("Which book would You like to check out Please make a selection from the list");
				library.display();
				System.out.println("Enter ISBN # of check out selection");
				choice = s.nextInt();
				w.write(library.searchBooks(choice) + " was checked out of libary\n");
				w.flush();
				library.checkOut(choice);
	


				break;
			case 4:
				System.out.println("Which book would you like to check in");
				library.display();
				System.out.println("Please enter isbn number of book you would like to return: ");
				choice = s.nextInt();
				library.checkIn(choice);
				w.write(library.searchcheckout(choice) + " was checked in to libary\n");
				w.flush();


				break;
			case 5:
				library.display();
				break;
			case 6:
				File f = new File("output.txt");
				Scanner s = new Scanner(f);
				// TODO Auto-generated method stub
				while (s.hasNextLine())
				{
					System.out.println(s.nextLine());
				}
				s.close();
				break;
			}//switch
		}//while loop
		w.close();
	}// main
	
}
