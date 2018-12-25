
public class CalcMain {
	public static void main(String[] args) {
		int ans;
		Initial i = new Initial();
		int a = i.acceptFirstNumber();
		int b = i.acceptSeconNumber();
		int opOption = i.displaynAccept();

		switch (opOption) {
		case 1:
			ans = i.add(a, b);
			i.displayOutput(ans);
			break;

		case 2:
			ans = i.sub(a, b);
			i.displayOutput(ans);
			break;
		case 3:
			ans = i.mul(a, b);
			i.displayOutput(ans);
			break;
		case 4:
			ans = i.div(a, b);
			i.displayOutput(ans);
			break;
		default:
			break;
		}
	}
}
