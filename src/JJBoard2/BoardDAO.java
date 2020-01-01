package JJBoard2;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	// 게시글 등록
	public void insertBoard(String title, String content, String writer) {
		try {
			sqlSession = sqlSessionFactory.openSession(true);
			HashMap<String, String> map = new HashMap<>();
			map.put("title", title);
			map.put("content", content);
			map.put("writer", writer);
			
			int result = sqlSession.insert("insertBoard", map);
			
			if (result > 0) {
				System.out.println("●● 게시글 등록에 성공하였습니다.");
			} else {
				System.out.println("●● 게시글 등록에 실패하습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 게시글 수정
	public void updateBoard(int bno, String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("title", title);
			map.put("content", content);
			map.put("writer", writer);
			
			int result = sqlSession.update("updateBoard", map);
			
			if(result > 0) {
				System.out.println("●● 게시글 수정에 성공하였습니다.");
			} else {
				System.out.println("●● 게시글 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}

	// 게시글 삭제
	public void deleteBoard(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			int result = sqlSession.delete("deleteBoard", bno);
			
			if(result > 0) {
				System.out.println("●● 게시글 삭제에 성공하였습니다.");
			}else {
				System.out.println("●● 게시글 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 게시글 목록
	public void selectBoard() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("selectBoard");
			
			printBoard(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	// 제목으로 게시글 검색
	public void searchBoard(String keyword) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list.clear();
			list = sqlSession.selectList("searchBoard", keyword);
			
			System.out.println("\"" + keyword + "\"(으)로 검색한 결과 " + list.size() + "건이 나왔습니다.");
			printBoard(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}

	// 상세게시글 조회
	public void viewBoard(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			plusViewcnt(bno);
			list.clear();
			list = sqlSession.selectList("viewBoard", bno);
			
			for(BoardDTO line : list) {
				System.out.println("게시글 번호 : " + line.getBno());
				System.out.println("제목 : " + line.getTitle());
				System.out.println("내용 : " + line.getContent());
				System.out.println("작성자 : " + line.getWriter());
				System.out.println("조회수 : " + line.getViewcnt());
				System.out.println("작성일 : " + line.getRegdate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			sqlSession.close();
		}
			
	}

	// 조회수 증가
	private void plusViewcnt(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			sqlSession.update("plusViewcnt", bno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 조회수로 게시글 정렬
	public void sortBoard() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list.clear();
			list = sqlSession.selectList("sortBaord");
			
			System.out.println("조회순으로 정렬한 결과");
			printBoard(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	private void printBoard(List<BoardDTO> list) {
		System.out.println("번호\t제목\t내용\t작성자\t조회수\t작성일");
		for(BoardDTO line : list) {
			System.out.println(line.getBno() + "\t" + line.getTitle() + "\t" + line.getContent()
			 + "\t" + line.getWriter() + "\t" + line.getViewcnt() + "\t" + line.getRegdate());
		}		
	}
}
