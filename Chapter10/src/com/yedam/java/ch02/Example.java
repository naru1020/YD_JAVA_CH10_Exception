package com.yedam.java.ch02;

public class Example {

	public static void main(String[] args) {
		// 일반예외처리
		try {
			Class clazz = Class.forName("java.langa.String2");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}

		// 실행예외처리
		String data1 = null;
		String data2 = null;
		try {
			data1 = args[0];
			data2 = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			// return;
			// "실행"은 나오지 않는데... 리턴은 종료한다는 뜻은 아니지만 트라이 캐치 내에서 쓰면 종료한다는 것과 같은 의미가 됨.
		}
		System.out.println("실행");

		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);

			int result = value1 + value2;
			System.out.println(result);
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
			//return;
			// 종료가 되더라도 finally는 반드시 실행된다.
		} finally {
			System.out.println("다시 실행하세요");
		}

		// 다중 캐치문
		try {
			data1 = args[0];
			data2 = args[1];

			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);

			int result = value1 + value2;
			System.out.println(result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
		} catch (Exception e) {
			System.out.println("실행에 문제가 있습니다.");
		} finally {
			System.out.println("다시 실행하세요");
		}

		// 예외처리 떠넘기기
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
}
