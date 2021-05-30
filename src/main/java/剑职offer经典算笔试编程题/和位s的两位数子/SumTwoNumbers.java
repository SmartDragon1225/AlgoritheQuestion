package 剑职offer经典算笔试编程题.和位s的两位数子;

import java.util.Arrays;

public class SumTwoNumbers {
    public static void main(String[] args) {
        int arr[] = {2,7,11,15,4,4};
        int[] sum = new SumTwoNumbers().twoSum1(arr, 9);
        System.out.println(Arrays.toString(sum));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    return new int[]{nums[i],nums[j]};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];

    }
}
