package 算法练习第五天5月16日;

/**
 * 从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小
 */
public class 求出缺失数子 {
    public static void main(String[] args) {
        int arr[] = {0,1,3,4,5,6,7};
        int solve = solve(arr);
        System.out.println(solve);
    }

    public static int solve(int arr[]){
        int sum = 0;
        int presum = arr.length * (arr.length + 1) / 2;//对数组进行求和.等差数列就和
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return presum - sum;
    }
}
