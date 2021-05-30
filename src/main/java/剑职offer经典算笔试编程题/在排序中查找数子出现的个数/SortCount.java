package 剑职offer经典算笔试编程题.在排序中查找数子出现的个数;

import java.util.Arrays;

public class SortCount {
    public static void main(String[] args) {
        int arr[] = {5,7,7,8,8,10};
        System.out.println(new SortCount().search1(arr, 7));
    }

    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i]){
                count++;
            }
        }
        return count;
    }

    //优化法
    public int search1(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
}
