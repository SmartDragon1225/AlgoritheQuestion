package 算法练习第四天5月15日.插入排序;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int arr[] = {-9,-4,5,6,7,9,0,2,-4,-8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int arr[]){
        for (int i = 0; i <arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && insertVal<arr[insertIndex]){   //没有找到插入位置，需要后移
                arr[insertIndex+1] = arr[insertIndex];   //没有找到插入位置，需要后移
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
    }
}
