package 算法练习第八天5月19日;

/**
 * 给定一个整型数组 arrarr 和一个整数 k(k>1)k(k>1)。
 * 已知 arrarr 中只有 1 个数出现一次，其他的数都出现 kk 次。
 * 请返回只出现了 1 次的数。
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 数组中只出现一次的数其他的数出现k次 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,2,1};
        int [] nums = {1,2,16,3,4,17,1,2,10000,100,16,3,4,5,6,6,7,7,8,524,17,8,9,59,9,15,15};
        System.out.println(searchSingle(arr));
        System.out.println(new 数组中只出现一次的数其他的数出现k次().foundOnceNumber(arr, 3));
    }

    public int foundOnceNumber (int[] arr, int k) {
        // write code here
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == arr[i+1]){
                i = i + k - 1;
            }else {
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }

    //详细算法，利用set的元素不能重复性。@author YYM。
    public static Set<Integer> searchSingle(int[]nums) {
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0;i<nums.length;i++) {
            if(!set1.add(nums[i])) {//如果添加不成功
                set1.remove(nums[i]);
            }
        }
        return set1;
    }
}
