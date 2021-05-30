package 算法练习第一天5月12日;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。
 注意：下标是从1开始的
 假设给出的数组中只存在唯一解
 例如：
 给出的数组为 {20, 70, 110, 150},目标值为90
 输出 index1=1, index2=2
 *
 */
public class Day_01_2 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < numbers.length; i++) {
            if(map.get(target - numbers[i]) != null) {
                result[0] = map.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    /**
     * 暴力法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum4 (int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(target - numbers[i] == numbers[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 优化法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3 (int[] numbers, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int result = target - numbers[i];
            if(hashMap.containsKey(result)){
                return new int[]{hashMap.get(result),i};
            }
            hashMap.put(numbers[i],i);
        }
        return null;
    }

    public int[] twoSum2 (int[] numbers, int target){
        int arr[] = new int[2];//保存结果
        //int arr[] = {0,0};//保存结果
        for (int i = 0; i < numbers.length; i++) {
            int  temp = target - numbers[i]; //需要在数组找temp
            for (int j = i+1; j < numbers.length; j++) { //从第二个位置开始找
                 if(temp == numbers[j]){
                    arr[0] = i+1;
                    arr[1] = j+1;
                 }//找到了
            }
        }
        return arr;
    }

    public static int[] twoSum1(int[] nums,int value){
        int arr[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = value - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(temp == arr[j]){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    public static void main(String []args){
        int arr[] = {20,70,110,150,80};
        Day_01_2 s = new Day_01_2();
        int arr1[] = s.twoSum4(arr, 190);
        System.out.println(Arrays.toString(arr1));
    }
}
