package 算法练习第二天5月13日;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，
 *
 * 请返回第K大的数，保证答案存在。
 */

public class 找出第k大的值 {
    public static void main(String[] args) {
        int arr[] = {1,3,5,2,2,4};
        int arr1[] = {1,5,2,6,8,0,6};
        System.out.println(new 找出第k大的值().findKth(arr, 3, 2));
        System.out.println(new 找出第k大的值().findKMin(arr, 3, 4));
    }

    /**
     * 采用局部排序法，时间复杂度在于排序的采取
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K){
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        return a[n-K];//第k大数的下标
    }

    public int findKMin(int[] a, int n, int K){
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(a[j]<a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        return a[K-n];//第k大数的下标
    }
}
