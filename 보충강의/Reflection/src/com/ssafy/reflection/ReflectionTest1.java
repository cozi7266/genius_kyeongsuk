/*
 	[1. 클래스 정보 접근]
 	2. 메서드 정보 접근
 	3. 객체 생성과 메서드 실행
 */

package com.ssafy.reflection;

import java.util.ArrayList;
import java.util.Random;

public class ReflectionTest1 {
	public static void main(String[] args) throws Exception {
		// 클래스 정보를 접근하는 3가지 방법
		/*
		 * 1. Class 클래스이름.class
		 * 2. Class 객체.getClass()
		 * 3. Class Class.forName(패키지.클래스이름);
		 */
		Class<?> clz1 = Dog.class;
		Dog dog = new Dog();
		Class<?> clz2 = dog.getClass();
		Class<?> clz3 = Class.forName("com.ssafy.reflection.Dog");
		
		System.out.println(clz1 == clz2);
		System.out.println(clz3 == clz2);
		
		System.out.println(clz1.getSimpleName());
		System.out.println(clz1.getName());
		
		Object obj = getRandomObject();
		Class<?> clz = obj.getClass();
		System.out.println(clz.getName());
		switch (clz.getName()) {
		case "java.lang.String":
		case "java.util.ArrayList":
			
		}
	}
	
	private static Object getRandomObject() throws Exception {
		Object[] arr = {
				new String("a"),
				new Dog(),
				new ArrayList<>()
		};
		return arr[new Random().nextInt(arr.length)];
		
	}
}
