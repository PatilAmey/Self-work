import java.util.Scanner;

public class Initial implements CalcInterface {
	private int n1;
	private int n2;
	private int option;

	public int acceptFirstNumber() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first number: ");
		n1 = input.nextInt();

		return n1;
	}

	public int acceptSeconNumber() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter second number: ");
		n2 = input.nextInt();

		return n2;
	}

	public int displaynAccept() {
		System.out.println("Enter one oprion from the following");
		System.out.println("1. Add");
		System.out.println("2. Sub");
		System.out.println("3. Mul");
		System.out.println("4. Div");
		Scanner operationOption = new Scanner(System.in);
		option = operationOption.nextInt();
		return option;
	}

	public void displayOutput(int ans) {
		System.out.println("The ans is " + ans);
	}

	@Override
	public int add(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1 + n2;
	}

	@Override
	public int sub(int n1, int n2) {
		// TODO Auto-generated method stub
		return n2 - n2;
	}

	@Override
	public int mul(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1 * n2;
	}

	@Override
	public int div(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1 / n2;
	}
}
