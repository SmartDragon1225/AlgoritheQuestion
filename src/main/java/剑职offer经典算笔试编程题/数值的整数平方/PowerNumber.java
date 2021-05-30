package 剑职offer经典算笔试编程题.数值的整数平方;

public class PowerNumber {
    public static void main(String[] args) {
        System.out.println(myPower(2, 5));
        System.out.println(myPower(2, 10));
        System.out.println(myPow(2, 5));
        System.out.println(myPow(2, 10));
    }

    /**
     * 利用递归如果n == 0，返回1
     * 如果n < 0，最终结果为 1/x^{-n}1/x
     * −n
     * 如果n为奇数，最终结果为 x * x ^ {n - 1}x∗x
     * n−1
     * 如果n为偶数，最终结果为 x ^ {2*(n/2)}x
     * 2∗(n/2)
     * @param x 数
     * @param n 次方
     * @return
     */
    public static double myPower(double x,double n){
        if(n == 0){
            return 1;
        }else if(n<0){
            return 1/x*(myPower(x,-n-1));
        }else if(n%2 == 1){ //奇数
            return x * myPower(x,n-1);
        }else if(n%2 == 0){
            return myPower(x*x,n/2);
        }
        return 1;
    }

    /**
     * 迭代法
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        long b = n;
        if(b < 0){
            x = 1 / x;
            b = - b;
        }
        double res = 1;
        while(b != 0){
            if(b % 2 != 0){
                res *= x;
            }
            b >>= 1;
            x *= x;
        }
        return res;
    }
}
