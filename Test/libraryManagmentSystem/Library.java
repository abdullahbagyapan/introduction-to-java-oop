package libraryManagmentSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
	private String userName;
	private int userPassword;
	private static int totalBook , totalMember;
	private static Map<String,ArrayList<String>> bookStore = new HashMap<String,ArrayList<String>>();
	private static ArrayList<String> book = new ArrayList<String>();
	private List<String> userHistory = new ArrayList<>();
	private List<String> borrowedBooks = new ArrayList<>();
	
	public Library(String name , int password) {
		this.userName = name;
		this.userPassword = password;
		totalMember++;
		this.userHistory.add("Created account");
	}
	
	public void AddBook(String bookWriter, String bookName) {
//		firstly get bookWriter's books and compare if bookName is in it
		if (isContain(bookWriter, bookName)) {
			System.out.println("The book has already in library");
		}
		else {
			bookStore.put(bookWriter,book);
			bookStore.get(bookWriter).add(bookName);
			System.out.println("The book has succesfully added");
			this.userHistory.add(bookName+" added library");
			totalBook++;
		}
	}
	
	public static void ShowBooks() {
		System.out.println(bookStore);
		System.out.println("Total book = "+totalBook);
	}
	
	
	public void BorrowBook(String bookWriter , String bookName) {
		if (isContain(bookWriter, bookName)) {
			bookStore.get(bookWriter).remove(bookName);
			totalBook--;
			this.borrowedBooks.add(bookName);
			this.userHistory.add(bookName+" borrowed");
			System.out.println("The book has succesfully got");
		}
		else {
			System.out.println("There is no book you looked in library");
		}
	}
	
	public void GiveBackBook(String bookWriter , String bookName) {
		if (isBorrowed(bookName)) {
			this.borrowedBooks.remove(bookName);
			bookStore.get(bookWriter).add(bookName);
			totalBook++;
			this.userHistory.add(bookName+" has gaved");
			System.out.println("The book has gaved");
		}
		else {
			System.out.println("You dont borrowed this book in library");
		}
	}
	
	public void ShowBorrowedBooks() {
		for (String book : this.borrowedBooks) {
			System.out.println(book);
		}
	}
	
	public void ShowHistory() {
		System.out.println(this.userHistory);
	}
	
	
	public void ResetPassword (String username , int oldPassword , int newPassword) {
		if (checkInformation(username, oldPassword)) {
			this.userPassword = newPassword;
			System.out.println("Password changed succesfully");
			this.userHistory.add("Changed password");
		}
		else {
			System.out.println("Wrong login information");
		}
	}
	
	public void ShowTotalMember(String username , int password) {
		if (checkInformation(username, password)) {
			System.out.println(totalMember);
		}
		else {
			System.out.println("You can't reach attirubite");
		}
	}
	
	
	
	private boolean checkInformation(String username , int password) {
		return (this.userName == username && this.userPassword == password);
	}
	
	
	private boolean isBorrowed(String bookName) {
//		we check contain bookName in borrowedBooks
		return this.borrowedBooks.contains(bookName);
	}
	
	
	private boolean isContain(String bookWriter , String bookName) {
//		we check contain bookName in data
		if (bookStore.containsKey(bookWriter)) {
			return bookStore.get(bookWriter).contains(bookName);
		}
		else {
			return false;
		}
	}
}


