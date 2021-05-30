package com.tian.num1;

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
		getSubInteger1(77);
		findContinuesSequence(77);
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

	public static int getSubInteger1(int n) {
		int min = 1;
		int max = 1;
		int sum = 0;
		int count = 0;
		while (min <= (n-1) / 2 ) {
			if (sum == n) {
				System.out.print(n + " = ");
				for (int k = min; k < max; k++) {
					if (k < max - 1)
						System.out.print(k + " + ");
					else
						System.out.print(k);
				}
				System.out.println();
				count++;
				min++;
				max = min;
				sum = 0;
			} else if (sum > n) {
				min++;
				max = min;
				sum = 0;
			} else {
				sum = sum + max;
				max++;
			}
		}
		return count;
	}

	public static void findContinuesSequence(int n){
		int start = 1; //区间开始位置
		int end = 2; //区间结束位置
		int sum = start + end; //区间的和
		//区间开始不可能大于n的一半，n为奇数时向上取整所以为(1 + n)/2
		while (start < (1 + n)/2){
			//区间和等于n直接输出结果
			if(sum == n){
				for(int i = start; i < end; i++){
					System.out.print(i+",");
				}
				System.out.println(end);
				//搜索下一个符合要求的区间
				end++;
				sum += end;
			}else if(sum < n){
				//区间和小于n，则结束位置向右移动
				end++;
				sum += end;
			}else {
				//区间和大于n，则开始位置向右移动
				sum -= start;
				start++;
			}
		}
	}
}
