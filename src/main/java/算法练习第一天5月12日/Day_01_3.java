package 算法练习第一天5月12日;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */
public class Day_01_3 {
    public static void main(String[] args) {
        int arr[] = {4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution(arr,4).forEach(System.out::println);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        quicksort(input,0,input.length-1);
        for (int i = 1; i <= k; i++) {
            list.add(new Integer(i));
        }

        return list;
    }

    public static void sort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }

    public static void quicksort(int arr[],int left,int right){
        int l = left;
        int r = right;
        int q = arr[(left+right)/2];
        while (l<r){
            while (arr[l]<q){
                l++;
            }
            while (arr[r]>q){
                r--;
            }
            if(l>=r){
                break;
            }
            int t = arr[l];arr[l]=arr[r];arr[r]=t;
            if(arr[l]==q){
                r--;
            }
            if(arr[r]==q){
                l++;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if(l<right){
            quicksort(arr,l,right);
        }
        if(r>left){
            quicksort(arr,left,r);
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if(input.length >= k&& k>0){
            Arrays.sort(input);
            for(int i = 0;i < k;i++){
                result.add(new Integer(input[i]));
            }
        }
        return result;
    }
}
