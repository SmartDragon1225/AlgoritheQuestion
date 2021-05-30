package 算法练习第三天5月14日;

import java.util.ArrayList;
import java.util.Arrays;

public class 数组两个数之和等于一个数的值 {
    public static void main(String[] args) {
        int arr[] = {0,3,4,5,6,7,3,9,10,11,-9,-5,-6,12};
        findSum(arr,21);
        //findZero(arr,0);
        System.out.println(threeSum(arr, 0));
    }

    public static void findSum(int arr[],int sum){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum){
                    System.out.println(arr[i]+" "+arr[j]);
                }
            }
        }
    }

    public static void findZero(int arr[],int sum){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if(arr[i]+arr[j]+arr[k] == sum){
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    }
                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num,int sum) {
        //先排序避免重复
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();//解集
        for (int i = 0; i < num.length - 2; ++i) {
            if (i != 0 && num[i - 1] == num[i])
                continue;
            int k = num.length - 1;
            for (int j = i + 1; j < num.length - 1; ++j) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;
                while (j < k && num[i] + num[j] + num[k] > 0)
                    --k;
                if (j == k)
                    break;
                if (num[i] + num[j] + num[k] == sum) {
                    ArrayList<Integer> ele = new ArrayList<>();
                    ele.add(num[i]);
                    ele.add(num[j]);
                    ele.add(num[k]);
                    list.add(ele);
                }
            }
        }
        return list;
    }
}
