package 剑职offer经典算笔试编程题.二进制中1的个数;

public class NumOf1 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(256));
        System.out.println(hammingZero(256));
    }

    public static int hammingWeight(int n){
        int count = 0;
        while (n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }

    //8位二进制数的0的个数
    public static int hammingZero(int n){
        int count = 0;
        while (n!=0){
            count++;
            n = n&(n-1);
        }
        return 8 - count;
    }
}
