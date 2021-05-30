package 剑职offer经典算笔试编程题.零一背包;

public class 零一背包 {
    public static void main(String[] args) {
         int arr[][] = {{1,3},{10,4}};
        System.out.println(new 零一背包().knapsack(10, 2, arr));
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

    public static int ksp(int value,int num,int arr[][]){
        int matrx[][] = new int[value+1][num+1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= value; j++) {
                if(j < arr[i-1][0]){
                    matrx[i][j] = matrx[i-1][j];
                }else {
                    matrx[i][j] = Math.max(matrx[i-1][j],matrx[i-1][j-arr[i-1][0]]+arr[i-1][1]);
                }
            }
        }
        return matrx[num][value];
    }

    /**
     * 一个机器人在m×n大小的地图的左上角（起点）。
     * 机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
     * 可以有多少种不同的路径从起点走到终点？
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1 (int m, int n) {
        // write code here
        int[][] dp = new int[m+1][n+1];
        for(int i = 1 ; i <= m ; i++){dp[i][1]=1;}//第一列赋值为1
        for(int j = 1 ; j <= n ; j++){dp[1][j]=1;}//第一行赋值为1
        for(int i = 2 ; i <= m ; i++)
        {
            for(int j = 2 ; j <= n ; j++)
            {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    public int uniquePaths(int m,int n){
        int arr[][] = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            arr[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            arr[1][i] = 1;
        }
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m][n];
    }
}
