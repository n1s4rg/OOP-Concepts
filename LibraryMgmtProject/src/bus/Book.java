package bus;

public class Book {
	//1- data member
	private long number;
	private String title;
	private String author;
	private int pages;
	
	//2- functions member
	//2.1- public overloaded constructors
	public Book() 
	{
		this.number= 100;
		this.title= "Hello B";
		this.author= "Mr. Beans";
		this.pages= 999;
	}
	
public Book(long number, String title, String author, int pages) {
		//this.number = number;
		setNumber(number);
		this.title = title;
		this.author = author;
		//this.pages = pages;
		setPages(pages);
	}

//2.2- public getter/setters

	public void setNumber(long value) 
	{
		this.number = value;
	}
	public long getNumber() {
		return number;
	}
	
	
	public void setTitle(String value) 
	{
		this.title = value;
	}
	public String getTitle() 
	{
		return this.title;
	}
	

	public void setAuthor(String value) 
	{
		this.author = value;
	}	
	public String getAuthor() 
	{
		return this.author;
	}
	

	public void setPages(int value) 
	{
		this.pages = value;
	}	
	public int getPages() 
	{
		return this.pages;
	}
	
	//2.3- GetStringFormat
	public 	String GetStringFormat() 
	{
		String state;
		state = this.number + " , " + this.title + " , " + this.author + " , " + this.pages;
		return state;
	}
	
}
