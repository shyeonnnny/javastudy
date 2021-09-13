package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;
	
	
	public Book(int i, String string, String string2) {
		this.bookNo = i;
		this.title = string;
		this.author = string2;
		this.stateCode = 1;	
	}
	
	public void rent() {
		this.stateCode = 0;
		System.out.println(title + "이(가) 대여 됐습니다.");
	}
	
	public String print() {
		String state = null;
		if (this.stateCode == 0) {
			state = "대여중";
		}else if (this.stateCode == 1) {
			state = "재고있음";
		}
		
		return state;
	}
	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getStateCode() {
		return stateCode;
	}


	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	
	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}



}
