package com.tian.num3;

/**
 * 题目三：一个四位整数是个平方数，前两个一样，后两个一样，前后两个不一样，这个数是？
 * 
 * @author 王伟
 *
 */
public class NumberIs {

	public static void main(String[] args) {
		Print();// 7744
		System.out.println();
		getNum();
	}

	public static void Print() {
		int bNum;// 前两位
		int aNum;// 后两位
		int n;
		for (bNum = 1; bNum <= 9; bNum++) {
			for (aNum = 0; aNum <= 9; aNum++) {
				n = bNum + 10 * bNum + 100 * aNum + 1000 * aNum;
				if (aNum != bNum && isSqrt(n)) {
					System.out.printf("该数为: %d", n);
				}
			}
		}
	}

	public static boolean isSqrt(int n) {
		int m = (int) Math.sqrt(n);
		return m * m == n ? true : false;
	}

	public static void getNum(){
		for (int i = 1;; i++) {
			if(i*i<1000)
				continue;
			if(i*i>9999)
				break;
			int m = i*i;
			//m/1000 == m%1000/100：前两位相同
			//m/100/10 == m%10：后两位相同
			if(m/1000 == m%1000/100 && m%100/10 == m%10){
				System.out.println("一个四位整数是个平方数，前两个一样，后两个一样，前后两个不一样，这个数是"+m);
			}
		}
	}
}
