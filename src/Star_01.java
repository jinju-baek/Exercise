
public class Star_01 {
	public static void main(String[] args) {
		int line = 7;
		int mid = 4;
		int san=line%mid;
		int st = 1;

		for (int i = 1; i < mid; i++) {
			System.out.print(" ");
		}
		for (int j = mid; j < san; j++) {
			System.out.println("*");
		}
	}
}
