package 算法练习第五天5月16日;

/**
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 */
public class 矩阵的最小路径和 {
    public static void main(String[] args) {
         int arr[][] = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(new 矩阵的最小路径和().minPathSum(arr));
    }

    public int minPathSum (int[][] matrix) {
        // write code here
        int arr[][] = new int[matrix.length][matrix[0].length];
        arr[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            arr[i][0] = arr[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            arr[0][i] = arr[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = matrix[i][j] + Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr[matrix.length - 1][matrix[0].length - 1];
    }

    public int knapsack (int V, int n, int[][] vw) {
        // write code here
        int[][] dp = new int[n+1][V+1];
        for(int i = 1; i<=n;i++){
            for(int j = 1;j<=V;j++){
                if(j<vw[i-1][0]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-vw[i-1][0]]+vw[i-1][1]);
                }
            }
        }
        return dp[n][V];
    }
}
