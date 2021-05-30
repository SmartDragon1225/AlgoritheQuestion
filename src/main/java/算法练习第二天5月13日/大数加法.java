package 算法练习第二天5月13日;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class 大数加法 {
    public static void main(String[] args) {
        System.out.println(maxAdd2("123", "12"));
        System.out.println(revserse1("123"));
        int arr[] = {8,9,3,2,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxAdd2("23132132132131","32424343432432"));
        System.out.println(bigAdd("121324454545454556454545454454544645445545454545454645545" +
                "13", "3251515155151515151153212565655655656556212121212121212"));
    }

    /**
     * * 字符串逐位相加，需要进位则进位处理，考虑两个问题：
     *  * 1、char怎么转换为integer, 减去'0'即可
     *  * 2、怎么处理对应位相加?反转字符串相加，正确处理进位即可，
     *  *    这样个位对应个位，十位对应十位，剩余的直接追加
     * @param
     * @param
     * @return
     */
    public String add(String str1, String str2) {
        // 一个字符串为空 直接返回另外一个
        if (str1 == null || "".equals(str1)) {
            return str2;
        }
        if (str2 == null || "".equals(str2)) {
            return str1;
        }
        StringBuilder sb = new StringBuilder();
        // 字符串都不为空时
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int idx1 = arr1.length - 1;
        int idx2 = arr2.length - 1;

        // 缓存是否需要进位
        boolean carry = false;
        // 遍历两个字符串 处理元素相加
        while (idx1>=0 && idx2 >=0) {
            char cur1 = arr1[idx1];
            char cur2 = arr2[idx2];
            // 相加
            int sum = cur1 - '0' + cur2 - '0';
            // 上一次运算是否有进位
            sum = carry ? sum+1: sum;
            // 是否需要进位
            carry = sum >= 10 ? true : false;
            // 相加结果 取个位数->字符类型
            sb.append((char)((sum%10) + '0'));
            // 索引递减
            idx1--;
            idx2--;
        }

        // 处理剩余的元素
        while (carry || idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0) {
                // 当前元素处理
                int sum = arr1[idx1] - '0' + (carry ? 1 : 0);
                // 下次是否需要进位
                carry = sum >= 10 ? true : false;
                // 添加到结果
                sb.append((char)((sum%10) + '0'));
                idx1--;
            } else if (idx2 >= 0) {
                // 当前元素处理
                int sum = arr2[idx2] - '0' + (carry ? 1 : 0);
                // 下次是否需要进位
                carry = sum >= 10 ? true : false;
                // 添加到结果
                sb.append((char)((sum%10) + '0'));
                idx2--;
            } else {
                sb.append('1');
                carry = false;
            }
        }

        // 反转sb 后返回
        return sb.reverse().toString();
    }

    public static String maxAdd2(String s1,String s2){
        StringBuilder stringBuilder = new StringBuilder();
        int i = s1.length()-1;int j = s2.length()-1;
        int carry = 0;
        while (i>=0 || j>=0 || carry != 0){
            int x = i < 0 ? 0 : s1.charAt(i--)-'0';
            int y = j < 0 ? 0 : s2.charAt(j--)-'0';
            int sum = x + y + carry;
            stringBuilder.append(sum%10);
            carry = sum/10;
        }
        return stringBuilder.reverse().toString();
    }

    public static String maxAdd(String s1,String s2){
        StringBuilder stringBuilder = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;//表示位数，个位，十位，百位等
        while (i >= 0 || j >= 0 || carry != 0){
            int x = i < 0 ? 0 : s1.charAt(i--) - '0';  //把char转换成int数组，为什么要减去一个'0'呢？
                                                       // 因为要减去0的ascii码得到的就是实际的数字
            int y = j < 0 ? 0 : s2.charAt(j--) - '0';
            int sum = x+y+carry;
            stringBuilder.append(sum%10);
            carry = sum / 10;
        }
        return stringBuilder.reverse().toString();//转为字符串
    }

    /**
     *  * * 字符串逐位相加，需要进位则进位处理，考虑两个问题：
     *      *  * 1、char怎么转换为integer, 减去'0'即可
     *      *  * 2、怎么处理对应位相加?反转字符串相加，正确处理进位即可，
     *      *  *    这样个位对应个位，十位对应十位，剩余的直接追加
     * @param s
     * @param t
     * @return
     */
    public static String solve (String s, String t) {
        //StringBuilder stringBuilder = new StringBuilder();
        String s1 = new String();
        int i = s.length() - 1, j = t.length() - 1;
        int carry = 0;//表示进位
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';//int x = s.charAt(i) - '0';把x转换位字符串
            int y = j < 0 ? 0 : t.charAt(j--) - '0';//int y = s.charAt(i) - '0';把y转化为字符串
            int sum = x + y + carry;
            //stringBuilder.append(sum % 10);//添加到字符串尾部
            s1 = s1 + (sum%10);
            carry = sum / 10;
        }
        return revserse1(s1);
        //return stringBuilder.toString();//因为从左向右加，所以对字符串反转
    }

    private static String revserse1(String str){
        char[] arr = str.toCharArray();//先转化位字符数组
        String res = "";//用来存放反转的字符串
        for (int i = arr.length-1; i >= 0; i--) {
            res = res + arr[i];
        }
        return res;
    }
    /**
     * java包装类实现
     * @param s
     * @param t
     * @return
     */
    public static String solve1 (String s, String t) {
        // write code here
        BigInteger bigInteger1 = new BigInteger(s);
        BigInteger bigInteger2 = new BigInteger(t);
        return bigInteger1.add(bigInteger2).toString();
    }

    //大数加法
    public static String bigAdd(String s1,String s2){
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i>=0 || j>=0 || carry != 0){
            int x = i < 0 ? 0 : s1.charAt(i--) - '0';
            int y = j < 0 ? 0 : s2.charAt(j--) - '0';
            int sum = x + y + carry;
            stringBuilder.append(sum%10);
            carry = sum / 10;
        }
        return stringBuilder.reverse().toString();
    }
}
