package com.tian.num4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 第四题(2) 输入一个字符串（整数算术符整数算术符整数...），输出结果 如：输入 1+9-6*3/4，输出 3
 * 
 * @author 王伟
 *
 */
public class Calucutor2 {

	public static void main(String[] args) {

		Calucutor2 calucutor2 = new Calucutor2();
		System.out.println("请输入要计算的表达式: ");
		Scanner scanner = new Scanner(System.in);
		String exprssion = scanner.nextLine();
		System.out.printf("表达式%s的计算结果为  %d", exprssion, calucutor2.cal(exprssion));
		scanner.close();
	}

	public int cal(String exprssion) {
		if (exprssion == null || exprssion.length() == 0) {
			return 0;
		}
		ArrayList<String> list = strToArrayList(exprssion);
		// 存放数字
		LinkedList<String> listNumLinkedList = new LinkedList<String>();
		// 存放运算符
		LinkedList<String> listChLinkedList = new LinkedList<String>();
		for (String str : list) {
			if (str.matches("\\d+")) {
				listNumLinkedList.addLast(str);
			} else {
				listChLinkedList.addLast(str);
			}
		}
		while (!listChLinkedList.isEmpty()) {
			int num1 = Integer.parseInt(listNumLinkedList.removeFirst());
			int num2 = Integer.parseInt(listNumLinkedList.removeFirst());
			String ch = listChLinkedList.removeFirst();
			listNumLinkedList.addFirst(cal(ch, num2, num1) + "");
		}
		return Integer.parseInt(listNumLinkedList.getFirst());

	}

	/**
	 * 
	 * @param c1 运算符
	 * @param a1 运算数1
	 * @param a2 运算数2
	 * @return
	 */
	public int cal(String c1, int a1, int a2) {
		int res = 0;
		switch (c1) {
		case "+":
			res = a1 + a2;
			break;
		case "-":
			res = a2 - a1;
			break;
		case "*":
			res = a2 * a1;
			break;
		case "/":
			res = a2 / a1;
			break;
		default:
			break;
		}
		return res;
	}

	/**
	 * 
	 * @param str 表达式
	 * @return 返回ArrayList
	 */
	public ArrayList<String> strToArrayList(String str) {
		ArrayList<String> list = new ArrayList<String>();
		// 遍历str的索引
		int index = 0;
		char ch;
		String strNum;
		while (index < str.length()) {
			// ch为非数字
			if ((ch = str.charAt(index)) < 48 || (ch = str.charAt(index)) > 57) {
				list.add("" + ch);
				index++;
			} else {
				strNum = "";
				while (index < str.length() && (ch = str.charAt(index)) >= 48 && (ch = str.charAt(index)) <= 57) {
					strNum += ch;
					index++;
				}
				list.add(strNum);
			}
		}
		return list;
	}
}
