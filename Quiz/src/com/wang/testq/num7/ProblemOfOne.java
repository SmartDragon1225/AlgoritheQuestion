package com.wang.testq.num7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/**
 * 题目七：（1）随机生成 n 个正整数，输出出现次数最多的整数和相应的次数。(已改)
 * 
 * @author 王伟
 *
 */
public class ProblemOfOne {

	public static void main(String[] args) {
		RandomOfInt(30);
	}

	/**
	 * 
	 * @param n 随机生成正整数的个数
	 */
	public static void RandomOfInt(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = random.nextInt(11);
		}
		System.out.println("生成的原始随机数组:");
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < n; i++) {
			set.add(array[i]);
		}
		for (int i : set) {
			map.put(i, 0);
		}
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();

		for (Entry<Integer, Integer> entry : entrySet) {
			int key = entry.getKey();
			for (int i = 0; i < array.length; i++) {
				if (array[i] == key) {
					entry.setValue(entry.getValue() + 1);
				}
			}
		}

		System.out.println(map);
		ArrayList<Entry<Integer, Integer>> arrayList = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
//		HashSet<Integer> maxKeyOfValue = getMaxKeyOfValue(map);
		System.out.println("最多的整数和次数为:");
		Collections.sort(arrayList, (o1, o2) -> {
			return (o2.getValue() - o1.getValue());
		});
		System.out.println(arrayList.get(0).getKey() + "  " + arrayList.get(0).getValue());
//		for (int key : maxKeyOfValue) {
//			System.out.printf("%d\t%d\n", key, map.get(key));
//		}

	}
}

//	/**
//	 * 
//	 * @param map 存储正整数和对应次数的map
//	 * @return 返回正整数出现最多数的key
//	 */
//	public static HashSet<Integer> getMaxKeyOfValue(HashMap<Integer, Integer> map) {
//		HashSet<Integer> set = new HashSet<Integer>();
//		int key = 0;
//		int value = 0;
//		for (Entry<Integer, Integer> entry : map.entrySet()) {
//			int value1 = entry.getValue();
//			if (value1 > value) {
//				value = value1;
//				key = entry.getKey();
//			}
//		}
//		set.add(key);
//		for (Entry<Integer, Integer> entry : map.entrySet()) {
//			if (entry.getValue() == value) {
//				set.add(entry.getKey());
//			}
//		}
//		return set;
//	}
//}
