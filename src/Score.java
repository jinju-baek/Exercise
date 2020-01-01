import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;

		while (true) {
			System.out.print("점수를 입력해주세요 >> ");
			num = sc.nextInt();
			if (num > 100 || num < 0) {
				System.out.println("0 ~ 100 사이의 점수를 입력해주세요.");
			} else {
				break;
			}
		}

		if (num <= 100 && num >= 90) {
			if (num <= 100 && num > 95) {
				System.out.println("학점은 A+ 입니다.");
			} else {
				System.out.println("학점은 A 입니다.");
			}
		} else if (num < 90 && num >= 80) {
			if (num < 90 && num > 85) {
				System.out.println("학점은 B+ 입니다.");
			} else {
				System.out.println("학점은 B 입니다.");
			}
		} else if (num < 80 && num >= 70) {
			if (num < 80 && num > 75) {
				System.out.println("학점은 C+ 입니다.");
			} else {
				System.out.println("학점은 C 입니다.");
			}
		} else if (num < 70 && num >= 60) {
			if (num < 70 && num > 65) {
				System.out.println("학점은 D+ 입니다");
			} else {
				System.out.println("학점은 D 입니다.");
			}
		} else {
			System.out.println("학점은 F 입니다.");
		}
	}
}
