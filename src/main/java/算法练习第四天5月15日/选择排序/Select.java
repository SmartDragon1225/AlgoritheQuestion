package 算法练习第四天5月15日.选择排序;

import java.util.Arrays;

public class Select {
    public static void main(String[] args) {
        int arr[] = {-9,-4,5,6,7,9,0,2,-4,-8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
