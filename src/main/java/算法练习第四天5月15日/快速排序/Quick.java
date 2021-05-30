package 算法练习第四天5月15日.快速排序;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int arr[] = {-9,-4,5,6,7,9,0,2,-4,-8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[],int left,int right){
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
            int t = arr[l];arr[l] = arr[r];arr[r] = t;
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
        if(left<r){
            quickSort(arr,left,r);
        }
        if(right>l){
            quickSort(arr,l,right);
        }
    }
}
