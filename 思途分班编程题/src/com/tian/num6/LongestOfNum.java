package com.tian.num6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目6:已知：一个字符串 str，输出字符串 str 中的连续最长的数字串。 例如：abcd12345ed125ss123456789
 * 输出：123456789(已改)
 * 
 * @author 王伟
 *
 */
public class LongestOfNum {

	public static void main(String[] args) {
		String string = "1253121abc3829saasjhx923828";
		s(string);
	}



	public static void s(String str){
			int count = 0;
			int max = 0;
			int end = 0;
			for(int i = 0;i < str.length();i ++) {
				if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					count++;
					//修改最大长度count
					if(max <count) {
						max = count;
						end = i;
					}
					//如果不是数字，count=0，重新开始计数
				}else {
					count  = 0;
				}
			}
			//
			System.out.println(str.substring(end - max + 1 ,end +1));

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
