package 算法练习第一天5月12日;

public class 斐波那契数列第n项 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
        System.out.println(fib(45));
    }

    public static int Fibonacci(int n) {
        if(n == 0 || n==1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static int fib(int n){
        if(n == 0 || n==1){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
