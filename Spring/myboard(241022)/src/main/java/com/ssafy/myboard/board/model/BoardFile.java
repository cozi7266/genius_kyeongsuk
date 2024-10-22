package com.ssafy.myboard.board.model;

public class BoardFile {
	private int fileNo;
	private String filePath;
	private String oriName;
	private String systemName;
	private int no;
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
