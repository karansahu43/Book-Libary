

public class Book {
	
	private int isbn;
	private String title;
	
	
	public Book(int isbn, String title)
	{
		this.isbn = isbn;
		this.title = title;
	}
	
	public int getIsbn()
	{
		return isbn;
	}
	public String getTitle()
	{
		return title;
	}
	public String toString()
	{
		return isbn+"::"+title;
	}

}
