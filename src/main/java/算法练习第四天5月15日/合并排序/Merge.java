package 算法练习第四天5月15日.合并排序;

import 算法练习第四天5月15日.快速排序.Quick;

import java.util.Arrays;

public class Merge extends Quick {
    public static void main(String[] args) {
        int arr[] = {-9,-4,5,6,7,9,0,2,-4,-8};
        int temp[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int arr[],int left,int middle,int rihgt,int temp[]){
        int i = left;
        int j = middle+1;
        int t = 0;

        while (i<=middle && j<=rihgt){
            if(arr[i]<arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while (i<=middle){
            temp[t++] = arr[i++];
        }
        while (j<=rihgt){
            temp[t++] = arr[j++];
        }

        t = 0;
        int templeft = left;
        while (templeft<=rihgt){
            arr[templeft++] = temp[t++];
        }
    }

    public static void mergeSort(int arr[],int left,int right,int temp[]){
        if(left<right){
            int middle = (left+right)/2;
            mergeSort(arr,left,middle,temp);
            mergeSort(arr,middle+1,right,temp);
            merge(arr,left,middle,right,temp);
        }
    }
}
