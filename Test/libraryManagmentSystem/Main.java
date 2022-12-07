package libraryManagmentSystem;

public class Main {

	public static void main(String[] args) {
		Library jack = new Library("jack",123);
		jack.AddBook("xxx","math101");
		jack.AddBook("xxx","math201");
		jack.BorrowBook("xxx","math101");
		jack.GiveBackBook("xxx","math101");
		jack.ShowBorrowedBooks();
		jack.ShowHistory();
		Library.ShowBooks();
		
	}

}
