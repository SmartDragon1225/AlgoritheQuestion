package 算法练习第二天5月13日;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */

public class 数组最大累计和 {
    public static void main(String[] args) {
        int arr[] = {1, -2, 3, 5, -2, 6, -1};
        int arr1[] = {1};
        System.out.println(new 数组最大累计和().maxsumofSubarray(arr));
    }

    public int maxsumofSubarray (int[] arr) {
        // write code here
        int max = arr[0];//假设第一个数累计和最大
        for (int i = 1; i < arr.length; i++) { //依次比较进行交换
            arr[i] = Math.max(arr[i],arr[i]+arr[i-1]);
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}

