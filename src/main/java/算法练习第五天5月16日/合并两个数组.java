package 算法练习第五天5月16日;

import java.util.Arrays;

public class 合并两个数组 {
    public static void main(String[] args) {
        int A[] = {5,6,7,8,9,10};
        int B[] = {1,2,3,4};
        System.arraycopy(A, 6, B, 4, 10);
        Arrays.sort(A);
        //new 合并两个数组().merge(A,6,B,4);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j])
                temp[index++] = nums1[i++];
            else
                temp[index++] = nums2[j++];
        }
        for (; i < m; ) {
            temp[index++] = nums1[i++];
        }
        for (; j < n; ) {
            temp[index++] = nums2[j++];
        }
        //再把数组temp中的值赋给nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j])
                temp[index++] = nums1[i++];
            else
                temp[index++] = nums2[j++];
        }
        for (; i < m; ) {
            temp[index++] = nums1[i++];
        }
        for (; j < n; ) {
            temp[index++] = nums2[j++];
        }
        //再把数组temp中的值赋给nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
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
}
