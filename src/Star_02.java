import java.util.Scanner;

public class Star_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int end = 5;
		int mid = (end / 2) + 1;

		for (int i = 1; i <= end; i++) {
			for (int j = end; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int k = 5; k > i; k--) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}
