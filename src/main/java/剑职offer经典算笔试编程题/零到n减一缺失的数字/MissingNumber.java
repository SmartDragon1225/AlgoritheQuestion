package 剑职offer经典算笔试编程题.零到n减一缺失的数字;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 */
public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,8,9};
        System.out.println(new MissingNumber().missingNumber(arr));
        System.out.println(new MissingNumber().solve(arr));
    }

    /**
     * 下标是否一一对应
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums[0]==1)
            return 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=i)
                return i;
        }
        return nums.length;
    }

    /**
     * 求和
     * @param arr
     * @return
     */
    public  int solve(int arr[]){
        int sum = 0;
        int presum = arr.length * (arr.length + 1) / 2;//对数组进行求和.等差数列就和
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return presum - sum;
    }

    /**
     * 二分法
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

}
