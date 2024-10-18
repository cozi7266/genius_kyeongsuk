package com.ssafy.myboard.board.model.dto;

public class BoardFile {
	private int fileNo;
	private String filePath;
	private String oriName;
	private String systemName;
	private int no;
	public BoardFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardFile(int fileNo, String filePath, String oriName, String systemName, int no) {
		super();
		this.fileNo = fileNo;
		this.filePath = filePath;
		this.oriName = oriName;
		this.systemName = systemName;
		this.no = no;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	@Override
	public String toString() {
		return "BoardFile [fileNo=" + fileNo + ", filePath=" + filePath + ", oriName=" + oriName + ", systemName="
				+ systemName + ", no=" + no + "]";
	}
	
}
