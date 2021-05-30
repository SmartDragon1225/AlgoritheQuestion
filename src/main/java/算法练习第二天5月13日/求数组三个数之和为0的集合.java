package 算法练习第二天5月13日;

/**
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 */

import java.util.ArrayList;
import java.util.Arrays;

public class 求数组三个数之和为0的集合 {
    public static void main(String[] args) {
        int arr[] = {9,8,3,-3,0,-8,1};
        System.out.println(new 求数组三个数之和为0的集合().threeSum(arr));
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //先排序避免重复
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();//解集
        for (int i = 0; i < num.length - 2; ++i) {
            if (i != 0 && num[i - 1] == num[i])
                continue;
            int k = num.length - 1;
            for (int j = i + 1; j < num.length - 1; ++j) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;
                while (j < k && num[i] + num[j] + num[k] > 0)
                    --k;
                if (j == k)
                    break;
                if (num[i] + num[j] + num[k] == 0) {
                    ArrayList<Integer> ele = new ArrayList<>();
                    ele.add(num[i]);
                    ele.add(num[j]);
                    ele.add(num[k]);
                    list.add(ele);
                }
            }
        }
        return list;
    }
}
