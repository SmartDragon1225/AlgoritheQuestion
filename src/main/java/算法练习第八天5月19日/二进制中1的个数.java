package 算法练习第八天5月19日;

public class 二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(numberOf1(255));
    }

    public static int numberOf1(int n){
        int count = 0;
        while (n!=0){
            count++;
            //n&(n-1)都会减少1个1
            n = n&(n-1);//现考虑二进制数：val :1101000, val-1: 1100111 那么val & （val-1） : 1100000
        }
        return count;
    }
}
