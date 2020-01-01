package Bank;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		while(true) {
			System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣은행♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
			System.out.println("♣♣ 1. 계좌 개설");
			System.out.println("♣♣ 2. 입금");
			System.out.println("♣♣ 3. 출금");
			System.out.println("♣♣ 4. 잔액 조회");
			System.out.println("♣♣ 5. 고객 조회");
			System.out.println("♣♣ 6. 사용자 검색");
			System.out.println("♣♣ 7. 계좌 해지");
			System.out.println("♣♣ 8. 프로그램 종료");
			System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
			System.out.print("♣♣ 입력 >> ");
			int num = sc.nextInt();
			
			if(num == 1) {
				System.out.println("♣♣ 만드실 계좌의 정보를 입력해주세요.");
				System.out.print("♣♣ 계좌주 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("♣♣ 비밀번호 >> ");
				String pw = sc.nextLine();
				bDao.insertBank(bname, pw);
			} else if(num == 2) {
				System.out.println("♣♣ 입금하실 계좌 번호를 입력해주세요.");
				System.out.print("♣♣ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.println("♣♣ 입금하실 금액을 입력해주세요.");
				System.out.print("♣♣ 입금액 >> ");
				int money = sc.nextInt();
				bDao.plusMoney(bno, money);
			} else if(num == 3) {
				System.out.println("♣♣ 출금하실 계좌의 정보를 입력해주세요.");
				System.out.print("♣♣ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("♣♣ 비밀번호 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				System.out.println("♣♣ 출금하실 금액을 입력해주세요.");
				System.out.print("♣♣ 출금액 >> ");
				int money = sc.nextInt();
				bDao.minusMoney(bno, pw, money);
			} else if(num == 4) {
				System.out.println("♣♣ 잔액 조회 하실 계좌 번호를 입력해주세요.");
				System.out.print("♣♣ 계좌번호 >> ");
				int bno = sc.nextInt();
				int money = bDao.viewMoney(bno);
				System.out.println("♣♣ 현재 잔액은 " + money + "원 입니다.");
			} else if(num == 5) {
				bDao.viewBank();
			} else if(num == 6) {
				System.out.println("♣♣ 검색하실 키워드를 입력해주세요.");
//				System.out.print("♣♣ 키워드 >> ");
				sc.nextLine();
				String keyword = sc.nextLine();
				bDao.searchBank(keyword);
			} else if(num == 7) {
				System.out.println("♣♣ 해지하실 계좌 번호를 입력해주세요.");
				System.out.print("♣♣ 계좌번호 >>");
				int bno = sc.nextInt();
				bDao.deleteBank(bno);
			} else if(num == 8) {
				System.exit(0);
			} else {
				System.out.println("♣♣ 없는 메뉴 입니다. 1 ~ 8 중 다시 입력해주세요.");
				continue;
			}
		}
	
	}
}
