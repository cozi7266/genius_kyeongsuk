/*
 	1. 클래스 정보 접근
 	[2. 메서드 정보 접근]
 	3. 객체 생성과 메서드 실행
 */

package com.ssafy.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class ReflectionTest2 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// Dog 클래스의 Class 정보를 얻기
		Class<?> clz = Dog.class;
		// Dog 클래스에 선언된 메서드 정보 얻기
		Method[] methods = clz.getDeclaredMethods();
		
		for(Method m : methods) {
			System.out.println(m.getName());
		}
		// String name, Class<?>
		Method method = clz.getDeclaredMethod("setName", String.class );
		System.out.println(method.getName());
	}
}
