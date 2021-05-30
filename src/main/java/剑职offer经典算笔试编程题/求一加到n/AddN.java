package 剑职offer经典算笔试编程题.求一加到n;

public class AddN {
    public static void main(String[] args) {
        System.out.println(new AddN().sumNums(0));
        System.out.println(sum(0));
    }

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static int sum(int n){
        if(n == 1){
            return 1;        //boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        }
        if(n == 0){
            return 0;
        }
        n = n+ sum(n-1);
        return n;
    }
}
