package 算法练习第二天5月13日;

/**
 * 将给出的32位整数x翻转。
 * 例1:x=123，返回321
 * 例2:x=-123，返回-321
 *
 * 你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，
 * 翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
 */
public class 反转数子 {
    public static void main(String[] args) {
        //数子反转
        System.out.println(new 反转数子().reverse(-1213));
        System.out.println(new 反转数子().reverse1(-1213));
        //字符转反转
        System.out.println(new 反转数子().reverse2("asdewq"));
        //字符转自带api
        System.out.println(new 反转数子().reverse3("asdewq"));
        huiwen(12321);
        System.out.println(huiwen1(12321));
    }

    public int reverse (int x) {
        // write code here
        int result = 0;
        while (x!=0){
            int t = x % 10;//个位
            int newResult = 10 * result + t;//得到新数字
            /*if ((newResult - t)/10 != result){ // //数子溢出返回0
                return 0; //数子溢出返回0
            }*/
            result = newResult;//交换，
            x = x / 10;//反复去位
        }
        return result;
    }

    //简化版
    public int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = 10 * res + t;
            //res = res * 10 + x % 10;
            res = newRes;
            x /= 10;
        }
        //return (int) res == res ? (int) res : 0;
        return res;
    }

    //判断回文数
    public static int huiwen1(int x) {
        int res = 0;
        int m = x;
        while (x != 0) {
            int t = x % 10;
            int newRes = 10 * res + t;
            //res = res * 10 + x % 10;
            res = newRes;
            x /= 10;
        }
        if(res == m){
            System.out.println("这是一个回文数！");
        }else {
            System.out.println("这不是一个回文数！");
        }

        //return (int) res == res ? (int) res : 0;
        return res;
    }

    /** 反转字符串
     * 涉及正负号，故不能使用字符串进行操作！
     * @param
     * @return
     */
    public String reverse2(String str){
        char[] array = str.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--) {
            reverse += array[i];
        }
        return reverse;
    }

    /**
     * 自带函数实现反转
     * @param str
     * @return
     */
    public StringBuilder reverse3(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder;
    }

    /**
     * 判断回文数
     * @param s:String ...s位参数数组
     */
    public static void huiwen(int s)
    {
        int n,m,rev=0;
        //n=Integer.parseInt(s[0]);
        n = s;
        m = n;
        while(n!=0) {
            int i=n%10;
            rev=(rev*10)+i;
            n/=10;
        }
        if(m==rev)
            System.out.println("\nNumber is palindrome");
        else
            System.out.println("\nNumber is not palindrome");

    }
}
