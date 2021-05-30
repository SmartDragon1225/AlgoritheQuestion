package 剑职offer经典算笔试编程题.减绳子;

/**
 * 切分规则：
 * 最优： 33 。把绳子尽可能切为多个长度为 33 的片段，留下的最后一段绳子的长度可能为 0,1,20,1,2 三种情况。
 * 次优： 22 。若最后一段绳子长度为 22 ；则保留，不再拆为 1+11+1 。
 * 最差： 11 。若最后一段绳子长度为 11 ；则应把一份 3 + 13+1 替换为 2 + 22+2，因为 2 \times 2 > 3 \times 12×2>3×1。
 *
 */
public class Cut {
    public static void main(String[] args) {
        System.out.println(new Cut().cuttingRope(10));
        System.out.println(new Cut().cuttingRope2(10));
    }

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if(n <= 3)
            return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0)
            return (int)Math.pow(3, a);
        if(b == 1)
            return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

    public int cuttingRope2(int n) {
        if(n <= 3)
            return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1)
                rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0)
            return (int)(rem * 3 % p);
        if(b == 1)
            return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }


}
