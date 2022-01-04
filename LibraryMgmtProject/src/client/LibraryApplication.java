package client;

import java.util.Scanner;
import java.util.ArrayList;
import bus.Book;

public class LibraryApplication {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		ArrayList <Book> bookList = new ArrayList<Book>();
		
		Book book1 = new Book();
		bookList.add(book1);
		
		book1.setNumber(200);
		book1.setTitle("Learn Java In 5 Minutes");
		book1.setAuthor("Mr. Shortcut");
		book1.setPages(199);
		
		Book book2 = new Book(300, "Java For Beginners", "Deitel", 699);
		bookList.add(book2);
		
//		System.out.println(book1.GetStringFormat());
//		System.out.println(book2.GetStringFormat());
		
		System.out.println("\n Original List: ");
		for(Book item : bookList) 
		{
			System.out.println(item.GetStringFormat());
		}
		
		bookList.remove(book2);
		
		System.out.println("\n New List: ");
		for(Book item : bookList) 
		{
			System.out.println(item.GetStringFormat());
		}
	}

}
