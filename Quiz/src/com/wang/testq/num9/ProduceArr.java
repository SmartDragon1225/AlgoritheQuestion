package com.wang.testq.num9;

import java.util.Arrays;

/**
 * 题目9:生成 n*n 的二维数组（矩阵） 1-数组中数据第一个位置为 1，逐行逐个递增，直到最后一个位置数据是 n*n
 * 2-从第一个元素开始按照顺时针螺旋逐个遍历输出每个元素。 例如 n=3，生成的矩阵是 array[3][3] 1 2 3 4 5 6 7 8 9
 * 遍历结果是：123698745(已改)
 * 
 * @author 王伟
 *
 */
public class ProduceArr {

	public static void main(String[] args) {

		int[][] produceArr = produceArr(6);
		System.out.println("生成的矩阵为:");
		for (int[] is : produceArr) {
			System.out.println(Arrays.toString(is));
		}
		rotatePrint(produceArr);
	}

	/**
	 * 生成二维数组
	 * 
	 * @param n
	 * @return 一个二维数组
	 */
	public static int[][] produceArr(int n) {
		int[][] arr = new int[n][n];
		int ini = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = ini;
				ini++;
			}
		}
		return arr;
	}

	/**
	 * 顺时针螺旋打印
	 * 
	 * @param arr 二维数组
	 */
	public static void rotatePrint(int[][] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int x0 = 0;
		int y0 = 0;
		int x1 = arr.length - 1;
		int y1 = arr.length - 1;
		while (x0 <= x1) {
			for (int i = y0; i <= y1; i++) {
				System.out.printf("%d ", arr[x0][i]);
			}
			for (int j = x0 + 1; j <= x1; j++) {
				System.out.printf("%d ", arr[j][y1]);
			}
			for (int i = y1 - 1; i >= y0; i--) {
				System.out.printf("%d ", arr[x1][i]);
			}
			for (int j = x1 - 1; j > x0; j--) {
				System.out.printf("%d ", arr[j][x0]);
			}
			x0 += 1;
			y0 += 1;
			x1 -= 1;
			y1 -= 1;
		}

	}
}
