package 剑职offer经典算笔试编程题.数组中重复发数子;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RepeatNumber {
    public static void main(String[] args) {
         int arr[] = {1,2,5,3,3,5,5,7,8,9,8};
        System.out.println(findRepeatNumber2(arr));
    }

    /**
     * 利用Hashset的特性进行求解
     * @param nums
     * @return
     */
    public static ArrayList<Object> findRepeatNumber(int[] nums) {
        HashSet set = new HashSet<>();
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums)
            if(!set.add(num))
                return num;
        return 0;
    }

    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        Integer d = null;
        for(int i = 0;i<nums.length;i++){
            int s = set.size();
            // d = new Integer(nums[i]);
            d = nums[i];
            set.add(d);
            int e = set.size();
            if(s==e){
                break;
            }
        }
        return d;
    }
}
