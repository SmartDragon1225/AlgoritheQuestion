package com.wang.testq.num4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 第四题：（1）输入一个字符串（整数算术符整数），输出结果
 * 
 * 
 * @author 王伟
 *
 */
public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入计算的表达式");
		String expression = scanner.nextLine();
		scanner.close();
		Calculator ca = new Calculator();
		// 中缀表达式
		ArrayList<String> list1 = ca.strToArrayList(expression);
		System.out.println(list1);
		// 中缀转后缀
		ArrayList<String> list2 = ca.inffixToSuffix(list1);
		System.out.println(list2);
		int res = ca.suffixCal(list2);
		System.out.printf("表达式的结果为:%d", res);

	}

	/**
	 * 
	 * @param list 后缀表达式list
	 * @return 计算结果
	 */
	public int suffixCal(ArrayList<String> list) {
		Stack<String> stack = new Stack<String>();
		int num1;
		int num2;
		int res = 0;
		for (String string : list) {
			if (string.matches("\\d+")) {
				stack.push(string);
			} else {
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				res = cal(string, num1, num2);
				stack.push(res + "");
			}
		}
		return Integer.parseInt(stack.pop());
	}

	/**
	 * 
	 * @param c 输入一个运算符
	 * @return 返回优先级，是一个整数(只包含加减乘除)
	 */
	public int getPriority(String c) {
		if (c.equals("*") || c.equals("/")) {
			return 2;
		} else if (c.equals("+") || c.equals("-")) {
			return 1;
		} else {
			return -1;
		}
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

	/**
	 * 
	 * @param list 中缀表达式所在的list
	 * @return 存储后缀表达式的list
	 */
	public ArrayList<String> inffixToSuffix(ArrayList<String> list) {
		// 符号栈
		Stack<String> stack = new Stack<String>();
		// 最后存放后缀表达式
		ArrayList<String> listCh = new ArrayList<String>();
		for (String str : list) {
			if (str.matches("\\d+")) {
				listCh.add(str);
			} else if (str.equals("(")) {
				stack.push(str);
			} else if (str.equals(")")) {
				while (!stack.peek().equals("(")) {
					listCh.add(stack.pop());
				}
				stack.pop();
			} else {
				// 若符号栈非空，并且栈顶运算符优先级>当前运算符优先级则把栈顶元素添加到list
				while (!stack.isEmpty() && getPriority(stack.peek()) > getPriority(str)) {
					listCh.add(stack.pop());
				}
				stack.push(str);
			}
		}
		while (!stack.isEmpty()) {
			listCh.add(stack.pop());
		}
		return listCh;
	}
}
