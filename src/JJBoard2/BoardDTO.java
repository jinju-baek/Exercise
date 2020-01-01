package JJBoard2;

import java.sql.Date;

public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Date Regdate;


	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Date getRegdate() {
		return Regdate;
	}

	public void setRegdate(Date regdate) {
		Regdate = regdate;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", viewcnt=" + viewcnt + ", Regdate=" + Regdate + "]";
	}
	
	
}
