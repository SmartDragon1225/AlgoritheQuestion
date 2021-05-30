package 算法练习第二天5月13日;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，
 * 因此输出2。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 1<=数组长度<=50000
 */
public class 数组出现超过一半的数 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,2,2,2,5,4,2,6,5,4,3,3,0,9,8,7,6,5};
        System.out.println(new 数组出现超过一半的数().MoreThanHalfNum_Solution(arr));
        System.out.println(new 数组出现超过一半的数().MoreThanHalfNum_Solution1(arr));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;//记录perValue的次数
        int preValue = array[0];//用来记录上一次的记录
        for (int i = 0; i < array.length; i++) {
            if(array[i] == preValue){
                count++;
            }else {
                count--;
                if(count == 0){
                    preValue = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;
        for (int i = 0; i < array.length; i++) {  //用来需要判断是否真的是大于1半数，这一步骤是非常有必要的，
            // 因为我们的上一次遍历只是保证如果存在超过一半的数就是preValue，但不代表preValue一定会超过一半
            if(preValue == array[i]){
                num++;
            }
        }
        return (num > array.length/2) ? preValue : 0;
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

    public int MoreThanHalfNum_Solution1(int [] array){
        //quicksort(array,0,array.length-1);//先排序
        Arrays.sort(array);
        int value = array[array.length/2];//中间的值
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            if(value == array[i]){
                count++;
            }
        }
        if(count > array.length/2){
            return value;
        }
        return -1;//表示没有找到超过一般的数子
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int mid = nums[nums.length/2];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == mid){
                count++;
            }
        }
        if(count > nums.length/2){
            return mid;
        }
        return -1;
    }
}
