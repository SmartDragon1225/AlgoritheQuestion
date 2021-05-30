package com.wang.testq.num1;

import java.util.ArrayList;

/**
 * 题目一：已知一个正整数 n，输出所有和为 n 的连续正整数序列。
 * 
 * @author 王伟
 *
 */
public class IntSequenceOfNum {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = intSequenceOfNum(77);
		for (ArrayList<Integer> arrayList : list) {
			System.out.println(arrayList);
		}
	}

	/**
	 * 
	 * @param n 输入一个正整数
	 * @return 包含所有等于n的连续正整数的序列的集合
	 */
	public static ArrayList<ArrayList<Integer>> intSequenceOfNum(int n) {
		if (n <= 0) {
			return null;
		}
		int sum = 0;
		int first = 0;
		int last = 0;
		ArrayList<ArrayList<Integer>> listS = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= n / 2; i++) {
			first = i;
			last = i + 1;
			while (last <= n / 2 + 1) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				sum = (first + last) * (last - first + 1) / 2;
				if (sum == n) {
					for (int j = first; j <= last; j++) {
						list.add(j);
					}
					listS.add(list);

				}
				last++;
			}
		}
		return listS;
	}

}
