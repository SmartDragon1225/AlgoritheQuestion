package com.tian.num5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 第五题:已知： 3 6 2 8 一个数字正确，且位置正确 7 0 1 9 两个数字正确，其中一个位置正确，另个位置不正确 1 4 2
 * 9一个数字正确，且位置不正确 4 5 7 6 一个数字正确，且位置正确 程序实现输出这四个数。
 * 
 * @author 王伟
 *
 */
public class FourNum {

	public static void main(String[] args) {
		FourNum fourNum = new FourNum();
		System.out.println("这四个数有:");
		fourNum.printFourNum();

	}

	public void printFourNum() {
		int[] arr1 = { 3, 6, 2, 8 };
		int[] arr2 = { 7, 0, 1, 9 };
		int[] arr3 = { 1, 4, 2, 9 };
		int[] arr4 = { 4, 5, 7, 6 };

		ArrayList<int[]> produceNum = produceNum();
		ArrayList<int[]> arrayList = new ArrayList<int[]>();
		for (int[] is : produceNum) {
			if (condition1(arr1, is) && condition1(arr4, is) && condition2(arr2, is) && condition3(arr3, is)) {
				arrayList.add(is);
			}
		}
		print(arrayList);

	}

	public ArrayList<int[]> produceNum() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		int[] array = new int[4];
		for (int i = 100; i <= 999; i++) {
			array = new int[4];
			array[0] = 0;
			array[1] = i / 100;
			array[2] = i / 10 % 10;
			array[3] = i % 10;
			list.add(array);
		}
		for (int i = 1000; i < 9999; i++) {
			array = new int[4];
			array[0] = i / 1000;
			array[1] = i / 100 % 10;
			array[2] = i % 100 / 10;
			array[3] = i % 10;
			list.add(array);
		}

		return list;

	}

	public void print(ArrayList<int[]> list) {
		for (int[] a : list) {
			System.out.println(Arrays.toString(a));
		}
	}

	// 条件1,4
	public boolean condition1(int[] arr1, int[] list) {
		int count = 0;
		int count1 = 0;
		for (int i = 0; i < arr1.length; i++) {
			int key = i;
			int value = arr1[i];
			for (int j = 0; j < list.length; j++) {
				if (list[j] == value) {
					count++;
					if (key == j) {
						count1++;
					}
				}
			}
		}
		if (count == 1 && count1 == 1) {
			return true;
		} else {
			return false;
		}

	}

	// 条件2
	public boolean condition2(int[] arr2, int[] list) {
		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < arr2.length; i++) {
			int key = i;
			int value = arr2[i];
			for (int j = 0; j < list.length; j++) {
				if (list[j] == value) {
					count1++;
					if (key == j) {
						count2++;
					}
					break;
				}
			}
		}
		if (count1 == 2 && count2 == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 条件3
	public boolean condition3(int[] arr3, int[] list) {
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < arr3.length; i++) {
			int key = i;
			int value = arr3[i];
			for (int j = 0; j < list.length; j++) {
				if (value == list[j]) {
					count1++;
					if (key != j) {
						count2++;
					}
				}
			}
		}
		if (count1 == 1 && count2 == 1) {
			return true;
		} else {
			return false;
		}
	}
}
