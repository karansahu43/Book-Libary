import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Library 
{
	//some kind of container of books
	//add and remove books
	//checkin checkout books
	// search by name and isbn
	//make a log for adding removing checkin and out
	//
	private HashSet <Book> database;
	private HashSet <Book> checkout;

	public Library() throws IOException
	{
		database = new HashSet<Book>();
		checkout = new HashSet<Book>();

	}
	
	public void removeBooks(int isbn) throws IOException
	{
		for(Book b: database)
		{
			if (b.getIsbn() == isbn)
			{
				database.remove(b);
				break;
			}
		}
		//log(isbn + "has been removed from the libary");
	}
	public void removeBooks(String title) throws IOException
	{
		for(Book b: database)
		{
			if (b.getTitle().equals(title))
			{
				database.remove(b);
			}
		}
		//log(title + "has been removed from the libary");
	}
	public void removeBooks(Book b) throws IOException
	{
		database.remove(b);
		//log(b.getTitle() + "has been removed from the libary");
	}
	public void addBooks(Book b) throws IOException
	{
		database.add(b);
		//log(b.getTitle() + "has been added to the libary");
	}
	public void addBooks(int isbn, String title) throws IOException
	{

		Book b;
		b = new Book(isbn, title);
		database.add(b);
		//log(b.getTitle() + "has been added to the libary");

	}
	public String searchcheckout( int isbn)
	{
		for(Book b: checkout)
		{
			if (b.getIsbn() == isbn)
			{
				return b.getTitle();
			}
		}
		return "no title";
	}
	public String searchBooks(int isbn)
	{
		for(Book b: database)
		{
			if (b.getIsbn() == isbn)
			{
				return b.getTitle();
				
			}
		}
		return "no title";
	}
	

	public void checkIn(int isbn) throws IOException 
	{
		for(Book b: checkout)
		{
			if (b.getIsbn() == isbn)
			{
				database.add(b);
				checkout.remove(b);
				//log(b.getTitle() + "has been checked into the libary");
				break;
			}
		}

	}
	public void checkOut(int isbn) throws IOException
	{
		
		for(Book b: database)
		{
			if (b.getIsbn() == isbn)
			{
				checkout.add(b);
				database.remove(b);
				//log(b.getTitle() + "has been checkedout from the libary");
				break;
			}
		}

	}

	public void display()
	{
		System.out.println("These are the books in the libary");
		for(Book b: database)
		{
			System.out.println(b);
		}
		System.out.println("These are the books checkedout");
		for(Book b: checkout)
		{
			System.out.println(b);
		}

	}
}

