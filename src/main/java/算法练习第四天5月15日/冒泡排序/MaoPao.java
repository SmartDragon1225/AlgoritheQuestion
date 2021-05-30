package 算法练习第四天5月15日.冒泡排序;

import java.util.Arrays;

public class MaoPao {
    public static void main(String[] args) {
        int arr[] = {-9,-4,5,6,7,9,0,2,-4,-8};
        maoPao(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void maoPao(int arr[]){
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
}
