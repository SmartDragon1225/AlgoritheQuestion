package 剑职offer经典算笔试编程题;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 */
public class 把数字排成最小的数 {
    public static void main(String[] args) {
          int arr[] = {2,34,21,56,45,78,9,0};
        System.out.println(new 把数字排成最小的数().minNumber(arr));
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
