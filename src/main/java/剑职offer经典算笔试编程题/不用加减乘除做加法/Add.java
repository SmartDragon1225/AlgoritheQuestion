package 剑职offer经典算笔试编程题.不用加减乘除做加法;

public class Add {
    public static void main(String[] args) {
        System.out.println(new Add().add(2, 3));
    }

    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public int add1(int a, int b) {
        int n=a^b;
        int c=(a&b)<<1;
        return n+c;
    }


}
