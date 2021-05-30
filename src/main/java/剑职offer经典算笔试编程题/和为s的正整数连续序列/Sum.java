package 剑职offer经典算笔试编程题.和为s的正整数连续序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum {
    public static void main(String[] args) {
        int arr[] = {2,3,4,6,5,7,2};
        int[][] ints = new Sum().findContinuousSequence(9);
    }

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;    //初始化左右边界和区间和
        List<int[]> res = new ArrayList<>();    //记录最终答案
        while(i < j) {      //如果左边界大于等于右边界就退出
            if(s == target) {   //区间和等于target
                int[] ans = new int[j - i + 1]; //记录答案
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {   //如果s >= target，i往右移，并且s减去i；
                s -= i;
                i++;
            } else {    //如果s < target，j往右移，s加上j；
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }

}
