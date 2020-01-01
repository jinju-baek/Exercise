package Bank;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BankDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<BankDTO> list;
	// 계좌 개설
	public void insertBank(String bname, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("bname", bname);
			map.put("pw", pw);
			int result = sqlSession.insert("insertBank", map);
			if(result > 0) {
				System.out.println("♣♣ 계좌 개설에 성공하였습니다.");
			} else {
				System.out.println("♣♣ 계좌 개설에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 입금
	public void plusMoney(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Integer> map = new HashMap<>();
			map.put("bno", bno);
			map.put("money", money);
			int result = sqlSession.update("plusMoney", map);
			if (result > 0) {
				System.out.println("♣♣ 입금에 성공하였습니다. 현재 잔액은 " + viewMoney(bno) + "원 입니다.");
			} else {
				System.out.println("♣♣ 입금에 실패하셨습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 출금
	public void minusMoney(int bno, String pw, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("pw", pw);
			map.put("money", money);
			int result = sqlSession.update("minusMoney", map);
			if(result > 0) {
				System.out.println("♣♣ 출금에 성공하였습니다. 현재 잔액은 " + viewMoney(bno) + "원 입니다.");
			} else {
				System.out.println("♣♣ 계좌번호 또는 비밀번호가 틀립니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 잔액조회
	public int viewMoney(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		int money = 0;
		try {
			money = sqlSession.selectOne("viewMoney", bno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return money;
	}

	// 계좌목록
	public void viewBank() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("viewBank");
			printBank(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	// 이름으로 계좌검색
	public void searchBank(String keyword) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("searchBank", keyword);
			System.out.println(keyword + "(으)로 검색한 결과 " + list.size() + "건 나왔습니다.");
			printBank(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 출력부분
	public void printBank(List<BankDTO> list) {
		System.out.println("계좌번호\t계좌주\t비밀번호\t잔액\t개설일");
		for(BankDTO line : list) {
			System.out.println(line.getBno() + "\t" + line.getBname() + "\t" + line.getPw() + "\t" + line.getMoney() + "\t" + line.getRegdate());
		}		
	}

	public void deleteBank(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			int result = sqlSession.delete("deleteBank", bno);
			if(result > 0) {
				System.out.println("♣♣ 계좌 해지에 성공하였습니다.");
			} else {
				System.out.println("♣♣ 계좌 해지에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}

}
