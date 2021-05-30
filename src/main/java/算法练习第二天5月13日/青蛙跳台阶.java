package 算法练习第二天5月13日;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class 青蛙跳台阶 {
    public static void main(String[] args) {
        System.out.println(new 青蛙跳台阶().jumpFloor(34));
        System.out.println(new 青蛙跳台阶().jumpFloor1(1));
    }

    public int jumpFloor(int target) {
        if(target == 0 || target == 1){
            return 1;
        }
        return jumpFloor(target-1) + jumpFloor(target - 2);
    }

    public int jumpFloor1(int target){
        if(target == 0 || target ==1){
            return target;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
