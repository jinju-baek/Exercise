package JJboard;

import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		BoardDAO bDao = new BoardDAO();
		
		
		while (true) {
			System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
			System.out.println("◐◑ JJ 게시판 ");
			bDao.boardSelect();
			System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
			System.out.println("◐◑ 1. 게시글 등록");
			System.out.println("◐◑ 2. 게시글 수정");
			System.out.println("◐◑ 3. 게시글 삭제");
			System.out.println("◐◑ 4. 게시글 조회");
			System.out.println("◐◑ 5. 게시글 검색");
			System.out.println("◐◑ 6. 상세 게시글");
			System.out.println("◐◑ 7. 게시글 인기순 정렬");
			System.out.println("◐◑ 8. 만든이");
			System.out.println("◐◑ 9. 종료.");
			System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
			
			while(true) {
				System.out.print("◐◑ 입력 >> ");
				num = sc.nextInt();
				if (num >= 1 && num <= 8) {
					break;
				} else {
					
					System.out.println("◐◑ 잘못된 값입니다. 1 ~ 8중 다시 입력해주세요.");
					continue;
				}
			}
			
			if (num == 1) {
				System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
				System.out.println("◐◑ 등록하실 게시글 정보를 입력해주세요.");
				System.out.print("◐◑ 제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("◐◑ 내용 >> ");
				String content = sc.nextLine();
				System.out.print("◐◑ 작성자 >> ");
				String writer = sc.nextLine();
				
				BoardDTO bDto = new BoardDTO(title, content, writer);
				bDao.boardInsert(bDto);
				
			} else if (num == 2) {
				System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
				System.out.println("◐◑ 수정하실 게시글 번호를 입력해주세요.");
				System.out.print("◐◑ 번호 >> ");
				int bno = sc.nextInt();
				System.out.println("◐◑ 수정하실 정보를 입력해주세요.");
				System.out.print("◐◑ 제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("◐◑ 내용 >> ");
				String content = sc.nextLine();
				System.out.print("◐◑ 작성자 >> ");
				String writer = sc.nextLine();
				
				BoardDTO bDto = new BoardDTO(bno, title, content, writer);
				bDao.boardUdate(bDto);
				
			} else if (num == 3) {
				System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
				System.out.println("◐◑ 삭제하실 게시글 번호를 입력해주세요.");
				System.out.print("◐◑ 번호 >> ");
				int bno = sc.nextInt();
				
				bDao.boardDelete(bno);
				
			} else if (num == 4) {
				bDao.boardSelect();

			} else if (num == 5) {
				System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
				System.out.println("◐◑ 검색하실 키워드를 입력해주세요.");
				System.out.print("◐◑ 키워드(제목, 내용 중에서 검색) >> ");
				sc.nextLine();
				String keyword = sc.nextLine();
				
				bDao.boardSearch(keyword);
				
			} else if (num == 6) {
				System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
				System.out.println("◐◑ 보고싶은 게시글 번호를 입력해주세요.");
				System.out.print("◐◑ 번호 >> ");
				int bno = sc.nextInt();
				
				bDao.boardView(bno);
				
			} else if(num==7) {
				bDao.boardSort();
				
			} else if (num == 8) {
				System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
				System.out.println("◐◑ 게시판 시스템 Version 1.7");
				System.out.println("◐◑ 이메일 : whitepearl0926@naver.com");
				System.out.println("◐◑ Made by daram2");
			} else if (num == 9) {
				System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
				System.out.println("◐◑ 시스템을 종료합니다.");
				System.exit(0);
			}

		}
	}
}
