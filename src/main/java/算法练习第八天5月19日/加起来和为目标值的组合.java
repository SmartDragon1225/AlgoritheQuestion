package 算法练习第八天5月19日;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一组候选数C 和一个目标数 T，找出候选数中起来和等于 T 的所有组合。
 * C 中的每个数字在一个组合中只能使用一次。
 */
public class 加起来和为目标值的组合 {
    public static void main(String[] args) {
        int arr[] = {23,21,34,21,5,6,7,35,8,9};
        combinationSum2(arr,42).forEach(System.out::println);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        if(num == null || num.length <= 0) return null;
        Arrays.sort(num);
        dfs(num,visited,target,0,list,result);
        return result;
    }
    public static void dfs(int[] num,boolean[] visited, int diff, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(diff == 0 && !result.contains(list)){//找到一个合法解
            result.add(new ArrayList<>(list));//这里要注意！！！！！一定要new
            return;
        }
        for (int i = start; i < num.length; i++) {//扩展状态
            if(diff < num[i]) return ;   //剪枝
            if(!visited[i]){
                list.add(num[i]);           //执行扩展动作
                visited[i] = true;
                dfs(num,visited,diff-num[i],i,list,result);
                list.remove(list.size()-1);         //撤销扩展动作
                visited[i] = false;
            }
        }
    }
}
