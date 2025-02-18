package com.bookshopproject.Entity;
//creating bean class for BookData
public class BookData {
	private int bid;
	private String bname;
	private String bedition;
	private String bauthor;
	private String bgenre;
	private int bprice;
	
	
	
	
	public BookData(int bid) {
		super();
		this.bid = bid;
	}
	public BookData() {
		super();
	}
	public BookData(String bname, String bedition, String bauthor, String bgenre, int bprice) {
		super();
		this.bname = bname;
		this.bedition = bedition;
		this.bauthor = bauthor;
		this.bgenre = bgenre;
		this.bprice = bprice;
	}
	public BookData(int bid, String bname, String bedition, String bauthor, String bgenre, int bprice) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bedition = bedition;
		this.bauthor = bauthor;
		this.bgenre = bgenre;
		this.bprice = bprice;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBedition() {
		return bedition;
	}
	public void setBedition(String bedition) {
		this.bedition = bedition;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBgenre() {
		return bgenre;
	}
	public void setBgenre(String bgenre) {
		this.bgenre = bgenre;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
	
	


}
