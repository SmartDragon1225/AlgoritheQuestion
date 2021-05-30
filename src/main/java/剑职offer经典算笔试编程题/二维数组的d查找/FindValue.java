package 剑职offer经典算笔试编程题.二维数组的d查找;

import java.util.*;

public class FindValue {
    public static void main(String[] args) {
         int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new FindValue().findNumberIn2DArray(arr, 14));

        HashMap<String, HashSet> hashMap = new HashMap<>();
        HashSet<Object> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        HashSet<Object> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        HashSet<Object> set3 = new HashSet<>();
        set3.add(2);
        set3.add(5);
        set3.add(4);
        set3.add(8);
        hashMap.put("2",set1);
        hashMap.put("3",set3);
        hashMap.put("1",set2);
        List<Map.Entry<String,HashSet>> lstEntry=new ArrayList<>(hashMap.entrySet());
        Collections.sort(lstEntry,((o1, o2) -> {
            return o1.getValue().size() - o2.getValue().size();
        }));
        lstEntry.forEach(o->{
            System.out.println(o.getKey()+":"+o.getValue());
        });
    }

    /**
     * 暴力查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 线性查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i; j < nums.length; j++) {
                if(temp == nums[j]){
                    arr[0] = nums[i];
                    arr[1] = nums[j];
                }
            }
        }
        return arr;
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

   /* public int[] singleNumbers(int[] nums) {
        int arr[] = new int[nums.length];
        HashSet<Object> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){

            }
        }
    }*/
}


