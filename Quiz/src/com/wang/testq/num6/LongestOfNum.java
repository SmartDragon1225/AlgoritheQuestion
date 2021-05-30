package com.wang.testq.num6;

/**
 * 题目6:已知：一个字符串 str，输出字符串 str 中的连续最长的数字串。 例如：abcd12345ed125ss123456789
 * 输出：123456789(已改)
 * 
 * @author 王伟
 *
 */
public class LongestOfNum {

	public static void main(String[] args) {
		String string = "12537abc38298329382saasjhx923828";
		longestOfNum(string);
	}

	public static void longestOfNum(String str) {
		String result = "";
		int count = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if ('0' <= arr[i] && arr[i] <= '9') {
				count = 1;
				int index = i;
				for (int j = i + 1; j < arr.length; j++) {
					if ('0' < arr[j] && arr[j] <= '9') {
						count++;
						index = j;
					} else {
						break;
					}
				}
				if (count > result.length()) {
					result = str.substring(i, index + 1);// 返回i到index位置的字符串；
				}
			} else {
				continue;
			}
		}
		System.out.println(result);
	}

}
