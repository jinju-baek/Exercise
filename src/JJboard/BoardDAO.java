package JJboard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBManager;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>();
	int result = 0;
	
	public void boardInsert(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) "
					    + "VALUES(seq_board.nextVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("등록 성공!!");
			} else {
				System.out.println("등록 실패!! 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} 
		}
	}
	
	public void boardUdate(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board "
					   + "SET title = ?, "
					   + "    content = ?, "
					   + "    writer = ? "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setInt(4, bDto.getBno());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("수정 성공!!");
			} else {
				System.out.println("수정 실패!! 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void boardDelete(int bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_board "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공!!");
			} else { 
				System.out.println("삭제 실패!! 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void boardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
					   + "ORDER BY bno DESC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");
				
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
				list.add(bDto);
			}
			viewQuery(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void boardSearch(String keyword) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
					   + "WHERE title LIKE ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");

			rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");
				
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
				list.add(bDto);
			}
			System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
			System.out.println("◐◑ \"" + keyword + "\"(으)로 총 " + list.size() + "건의 결과가 나왔습니다.");
			viewQuery(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void boardView(int bno) {
		try {
			int result = viewCntUp(bno);
			if (!(result > 0)) {
				return;
			}
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");

				System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");		
				System.out.println("게시글번호 : " + bno);
				System.out.println("작성자 : " + writer);
				System.out.println("조회수 : " + viewcnt);
				System.out.println("작성날짜 : " + regdate);
				System.out.println("제목 : " + title);
				System.out.println("내용 : " + content);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void boardSort() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
					+ "ORDER BY viewcnt DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");
				
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
				list.add(bDto);
			}
			System.out.println("◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑◐◑");
			System.out.println("◐◑ 인기순 정렬 결과입니다.");
			viewQuery(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void viewQuery(ArrayList<BoardDTO> list) {
		System.out.println("게시글번호\t제목\t내용\t작성자\t조회수\t작성날짜");
		for(BoardDTO line : list) {
			System.out.println(line.getBno() + "\t" + line.getTitle() + "\t" + line.getContent()
			 + "\t" + line.getWriter() + "\t" + line.getViewcnt() + "\t" + line.getRegdate());
		}
	}
	
	public int viewCntUp(int bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board "
					   + "SET viewcnt = viewcnt + 1 "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
