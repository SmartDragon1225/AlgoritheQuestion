package com.tian.num2;

/**
 * 题目二:判断输出一个正整数是不是回文数？
 * 
 * @author 王伟
 *
 */
public class PalindromicNumber {

	public static void main(String[] args) {
		System.out.println(isPal("12321"));
		System.out.println(isPalindromicNumber(87432883));
		System.out.println(isPal(2002));
	}

	/**
	 * 
	 * @param n 正整数n
	 * @return 是回文数返回true,不是返回false
	 */
	public static boolean isPalindromicNumber(int n) {
		String str = n + "";
		char[] charArray = str.toCharArray();
		int len = charArray.length;
		for (int i = 0; i < len; i++) {
			if (charArray[i] != charArray[len - i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPal(int n){
		String str = n+"";
		char arr[] = str.toCharArray();
		int start = 0;
		int end = arr.length-1;
		while (start<end){
			if(str.charAt(start++) != str.charAt(end--)){
				return false;
			}
		}
		return true;
	}

	public static boolean isPal(String str){
		char arr[] = str.toCharArray();
		int start = 0;
		int end = arr.length-1;
		while (start<end){
			if(str.charAt(start++) != str.charAt(end--)){
				return false;
			}
		}
		return true;
	}
}
