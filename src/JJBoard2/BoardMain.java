package JJBoard2;

import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		
		while(true) {
			System.out.println("●●●●●●●●●●●●●●●●●●●● JJ게시판 ●●●●●●●●●●●●●●●●●●●●");
			bDao.selectBoard();
			System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
			System.out.println("●● 1. 게시글 등록");
			System.out.println("●● 2. 게시글 수정");
			System.out.println("●● 3. 게시글 삭제");
			System.out.println("●● 4. 게시글 목록");
			System.out.println("●● 5. 게시글 검색");
			System.out.println("●● 6. 상세 게시글");
			System.out.println("●● 7. 게시글 정렬");
			System.out.println("●● 8. 만든이");
			System.out.println("●● 9. 프로그램 종료");
			System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
			
			System.out.print("●● 입력 >> ");
			int num = sc.nextInt();
			
			if(num == 1) {
				System.out.println("●● 등록하실 게시글 정보를 입력해주세요.");
				System.out.print("●● 제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("●● 내용 >> ");
				String content = sc.nextLine();
				System.out.print("●● 작성자 >> ");
				String writer = sc.nextLine();
				
				bDao.insertBoard(title, content, writer);
				
			} else if(num == 2) {
				System.out.println("●● 수정하실 게시판 번호를 입력해주세요.");
				System.out.print("●● 번호 >> ");
				int bno = sc.nextInt();
				System.out.println("●● 수정하실 게시판 정보를 입력해주세요");
				System.out.print("●● 제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("●● 내용 >> ");
				String content = sc.nextLine();
				System.out.print("●● 작성자 >> ");
				String writer = sc.nextLine();
				
				bDao.updateBoard(bno, title, content, writer);
			} else if(num == 3) {
				System.out.println("●● 삭제하실 게시판 번호를 입력해주세요.");
				System.out.print("●● 번호 >> ");
				int bno = sc.nextInt();
				
				bDao.deleteBoard(bno);
			} else if(num == 4) {
				
				bDao.selectBoard();
			} else if(num == 5) {
				System.out.println("●● 검색하실 게시판 제목을 입력해주세요.");
				System.out.print("●● 키워드 >> ");
				sc.nextLine();
				String keyword = sc.nextLine();
				
				bDao.searchBoard(keyword);
			} else if( num ==6 ) {
				System.out.println("●● 조회하실 게시판 번호를 입력해주세요.");
				System.out.print("●● 번호 >> ");
				int bno = sc.nextInt();
				
				bDao.viewBoard(bno);
			} else if(num == 7) {
				bDao.sortBoard();
				
			} else if(num == 8) {
				System.out.println("●● Made By : daram");
				System.out.println("●● 만든 날짜 : 2020/01/01");
				System.out.println("●● 이메일 : whitepear0926@naver.com");
			} else if(num == 9) {
				System.exit(0);
			} else {
				System.out.println("●● 없는 메뉴 입니다. 1 ~ 9중 다시 입력해주세요.");
			}
			
		}
	}
}
