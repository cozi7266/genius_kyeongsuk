package com.ssafy.servlet;

public class Board {
	private static int boardNo;
	private int no;
	private String title;
	private String writer;
	private String content;
	
	public Board(int no, String title, String writer, String content) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	public Board(String title, String writer, String content) {
		this(++boardNo, title, writer, content);
	}
	public Board() {
		boardNo++;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}
	
	
}
