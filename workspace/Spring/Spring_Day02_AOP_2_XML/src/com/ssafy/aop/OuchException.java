package com.ssafy.aop;

public class OuchException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public void handleException() {
		System.out.println("병원가자 ㅠ^ㅠ");
	}
}
