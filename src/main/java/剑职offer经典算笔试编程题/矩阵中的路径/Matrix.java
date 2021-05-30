package 剑职offer经典算笔试编程题.矩阵中的路径;

public class Matrix {
    public static void main(String[] args) {
        char s[][] = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
        System.out.println(new Matrix().exist(s, "abe"));
    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     * 回溯法解决
     * @param board 矩阵
     * @param word  路径
     * @param i     行
     * @param j     列
     * @param k    表示匹配路径
     * @return
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length
                || j < 0 || board[i][j] != word[k])
            return false;
        if(k == word.length - 1)
            return true;
        board[i][j] = '\0';
        boolean res =
                dfs(board, word, i + 1, j, k + 1) ||   //朝上走
                dfs(board, word, i - 1, j, k + 1) ||   //朝下走
                dfs(board, word, i, j + 1, k + 1) ||   //朝左走
                dfs(board, word, i , j - 1, k + 1);    //朝右走
        board[i][j] = word[k];
        return res;
    }
}
