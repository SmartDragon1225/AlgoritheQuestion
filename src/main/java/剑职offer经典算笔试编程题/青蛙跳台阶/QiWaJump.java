package 剑职offer经典算笔试编程题.青蛙跳台阶;

public class QiWaJump {
    public static void main(String[] args) {
        System.out.println(new QiWaJump().jump(1));
    }

    public int jump(int n){
        if(n==1 || n == 0){
            return 1;
        }
        int a = 1;
        int b = 1;
        int sum = a+b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a+b)%1000000007;
        }
        return sum;
    }

    public int fib(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public int fib1(int n){
        if(n == 1 || n == 0){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}
