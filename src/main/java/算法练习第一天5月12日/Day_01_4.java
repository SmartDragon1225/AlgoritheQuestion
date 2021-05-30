package 算法练习第一天5月12日;

/**
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 */
public class Day_01_4 {
    public static void main(String[] args) {
        int arr[] = {5,6,8,9,12};
        Day_01_4 day_01_4 = new Day_01_4();
        System.out.println(day_01_4.search(arr, 0));
    }
    public int search (int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                while (mid != 0 && nums[mid] == nums[mid - 1]){
                    mid--;
                }
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search1 (int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = low+ (high- low) / 2;
            if(nums[mid] == target){
                while(mid != 0 &&(nums[mid-1] == nums[mid])){
                    mid--;
                }
                return mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
