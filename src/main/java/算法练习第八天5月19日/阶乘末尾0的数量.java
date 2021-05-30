package 算法练习第八天5月19日;

/**
 * 给定一个非负整数 NN，返回 N!N! 结果的末尾为 00 的数量。
 * N!N! 是指自然数 NN 的阶乘,即:N!=1*2*3…(N-2)*(N-1)*NN!=1∗2∗3…(N−2)∗(N−1)∗N。
 */
public class 阶乘末尾0的数量 {
    public static void main(String[] args) {
        System.out.println(fib(12));
        System.out.println(thenumberof0(12));
        System.out.println(has0(10000));
    }

    public static long fib(long n){
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(n>1){
            return n*fib(n-1);
        }
        return 0;
    }
    //判断一个数的阶乘末尾含有0的个数
    public static long thenumberof0(long n){
        long count = 0;
        long d = 5;
        while (n >= d){
            count = count + n/d;
            d = d*5;
        }
        return count;
    }
    public static long has0(long n){
        int count = 0;
        if(n<10){
            return 0;
        }
        while (n>=10){
            n = n/10;
            count++;
        }
        return count;
    }

    public long thenumberof_0 (long n) {
        //每次对10取余，然后再/10，再取余
        if(n==0) {
            return 1;
        }
        //结果为0的个数只与2与5的个数有关。因为2的个数肯定要大于5的个数，所以只要关注5的个数就可以了.
        long i=5,count=0;
        while(i<=n){
            count=count+n/i;
            i=i*5;//5有1个5，因此n是5的几倍就有几个5，而n有几个25又多出一个5来
        }
        return count;
    }
}
