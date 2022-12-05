package bankApp;


public class Main {

	public static void main(String[] args) {
		Bank customer1 = new Bank("Abdullah",123);
		customer1.depositeMoney(100);
		customer1.depositeMoney(200);
		customer1.depositeMoney(300);

		customer1.resetPassword(123, 120);
		
		customer1.viewAccountDetails(120);
	}

}