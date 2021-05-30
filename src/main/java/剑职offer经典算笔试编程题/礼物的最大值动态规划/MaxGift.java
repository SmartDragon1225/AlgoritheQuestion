package 剑职offer经典算笔试编程题.礼物的最大值动态规划;

public class MaxGift {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new MaxGift().maxValue(arr));
        System.out.println(new MaxGift().maxVlaue1(arr));
    }

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(i == 0)
                    grid[i][j] += grid[i][j - 1] ;
                else if(j == 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public int maxVlaue1(int arr[][]){
        int m = arr.length, n = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i ==0 && j==0){
                    continue;
                }
                if(i == 0){
                    arr[i][j] = arr[i][j] + arr[i][j-1];
                }else if(j == 0){
                    arr[i][j] = arr[i][j] + arr[i-1][j];
                }else {
                    arr[i][j] = arr[i][j] + Math.max(arr[i][j-1],arr[i-1][j]);
                }
            }
        }
        //最大值在  ========= 左下角
        return arr[m-1][n-1];
    }
}
