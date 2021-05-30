package 剑职offer经典算笔试编程题.斐波那契数列;

public class FibQuestion {
    public static void main(String[] args) {
        System.out.println(new FibQuestion().fib(44));
        System.out.println(new FibQuestion().fib1(44));
    }


    public int fib(int n){
        if(n == 1 || n == 0){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public int fib1(int n){
        if(n==1 || n == 0){
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

    public int fib2(int n){
        if(n==1 || n == 0){
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = a+b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a+b)%1000000007;
        }
        return sum;
    }
}
