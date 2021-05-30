package com.tian.num7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/**
 * 题目七（2）：随机生成 n 个正整数，按照数据出现次数排序后，输出每个数据和相应的次数。(已改)
 * 
 * @author 王伟
 *
 */
public class ProblemOfTwo {

	public static void main(String[] args) {
		new ProblemOfTwo().RandomOfInt(40);
	}

	/**
	 * 
	 * @param n
	 */
	public void RandomOfInt(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = random.nextInt(11);
		}
		System.out.println("原始随机数组:");
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
//		ArrayList<Node> mapToArrayList = mapToArrayList(map);
//		bubbleSort(mapToArrayList);
//		print(mapToArrayList);

		System.out.println("数据     次数");
		ArrayList<Entry<Integer, Integer>> arrayList = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(arrayList, (o1, o2) -> {
			return Integer.compare(o1.getValue(), o2.getValue());
		});
		for (Entry<Integer, Integer> entry : arrayList) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

//	/**
//	 * 将map中的数据以node方式存储到ArrayList
//	 * 
//	 * @param map
//	 * @return
//	 */
//	public ArrayList<Node> mapToArrayList(HashMap<Integer, Integer> map) {
//		ArrayList<Node> list = new ArrayList<Node>();
//		int key;
//		int value;
//		for (Entry<Integer, Integer> entry : map.entrySet()) {
//			key = entry.getKey();
//			value = entry.getValue();
//			list.add(new Node(key, value));
//		}
//		return list;
//	}
//
//	/**
//	 * 对结点按次数冒泡排序
//	 * 
//	 * @param list
//	 */
//	public void bubbleSort(ArrayList<Node> list) {
//		int len = list.size();
//		boolean flag = false;
//		Node tempNode;
//		for (int i = 0; i < len - 1; i++) {
//			for (int j = 0; j < len - i - 1; j++) {
//				int valuej = list.get(j).getValue();
//				int valuejNext = list.get(j + 1).getValue();
//				if (valuej > valuejNext) {
//					tempNode = list.get(j);
//					list.set(j, list.get(j + 1));
//					list.set(j + 1, tempNode);
//					flag = true;
//				}
//			}
//			if (!flag) {
//				break;
//			}
//		}
//	}
//
//	/**
//	 * 打印
//	 * 
//	 * @param list
//	 */
//	public void print(ArrayList<Node> list) {
//		for (Node node : list) {
//			System.out.println(node);
//		}
//	}
//}
//
//class Node {
//	int key;
//	int value;
//
//	public Node(int key, int value) {
//		super();
//		this.key = key;
//		this.value = value;
//	}
//
//	public int getKey() {
//		return key;
//	}
//
//	public void setKey(int key) {
//		this.key = key;
//	}
//
//	public int getValue() {
//		return value;
//	}
//
//	public void setValue(int value) {
//		this.value = value;
//	}
//
//	@Override
//	public String toString() {
//		return "Node [数据=" + key + ", 次数=" + value + "]";
//	}

}
