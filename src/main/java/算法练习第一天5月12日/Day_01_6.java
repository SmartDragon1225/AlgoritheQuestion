package 算法练习第一天5月12日;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,2,3,4,5]的子数组有[1,2]，[2,3,4]等等，但是[1,3,4]不是子数组
 */
public class Day_01_6 {
    public static void main(String[] args) {
        int arr[] = {2,2,3,4,3,5,6,4,3,2,4,8};
        System.out.println(maxLength(arr));
    }

    public static int maxLength (int[] arr) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        int r = 0;
        int l = 0;
        int count = 0;//最长无重复元素子数组的长度
        while (l < arr.length && r < arr.length){
            if(set.contains(arr[r]) == false){  //如果集合中没有重复的值
                set.add(arr[r]);//添加集合
                r++;//后移
                count = Math.max(r-l,count);//（默认为0）更新最长无重复元素子数组的长度
            }else { //如果集合中没有重复的值,那么就移除
                set.remove(arr[l]);
                l++;
            }
        }
        return count;
    }

    public static int maxLength1 (int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int start = 0, end = 0; end<arr.length ; end++){
            if(map.containsKey(arr[end])){
                //重复了
                start = Math.max(start, map.get(arr[end])+1);
                //注意：这里一定要取最大的start，不然就错误了
                //为什么？ 因为重复数字的索引很可能比start小
            }
            max = Math.max(max , end-start+1);
            map.put(arr[end],end);
        }
        return max;
    }
}
