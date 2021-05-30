package 算法练习第四天5月15日.堆排序;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int arr[] = {-9,-4,5,62423,7,93424,0,2,-4,-8434};
        heapSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void adjust(int arr[],int i,int length){
        int temp = arr[i];
        for (int j = 2*i+1; j < length; j=2*i+1) {
            if(j+1<length && arr[j+1]>arr[j]){ //左子树大于右子树
                j++;
            }
            if(arr[j]>temp){       //如果大于当前节点值
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
            arr[i] = temp;  //循环比较
        }
    }
    
    public static void heapSort(int arr[]){
        //构建大顶堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        //将堆顶元素与末尾交换
        for (int i = arr.length-1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr,0,i);
        }
    }

    public static void adjust1(int arr[],int i,int length){
        int temp = arr[i];//当前节点
        for (int j = 2*i+1; j < length; j=2*i+1) {
            if(j+1<length && arr[j+1]>arr[j]){
                j++;
            }
            if(arr[j]>temp){
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
            arr[i] = temp;
        }
    }

    public static void heapSort1(int arr[]){
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjust(arr,i, arr.length);
        }
        for (int i = arr.length-1; i > 0; i--) {
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            adjust(arr,0,i);
        }
    }

    public static void heapSort2(int arr[]){
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjust1(arr,i,arr.length);
        }
        for (int i = arr.length-1; i > 0; i--) {
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            adjust1(arr,0,i);
        }
    }
}
