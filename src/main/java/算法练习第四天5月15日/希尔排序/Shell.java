package 算法练习第四天5月15日.希尔排序;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        int arr[] = {-9,-4,5,6,7,9,0,2,-4,-8};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int arr[]){
        for (int gap = arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if(arr[j]>arr[gap+j]){
                        int t = arr[j];
                        arr[j] = arr[gap+j];
                        arr[gap+j] = t;
                    }
                }
            }
        }
    }
}
