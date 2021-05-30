package 算法练习第八天5月19日;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class 牛客网之丑数 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(5));
        System.out.println(bigAdd("122","212"));
        System.out.println(solve("122","212"));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int i = 0, m = 0, n = 0;
        int[] num = new int[index];
        num[0] = 1;
        for (int j = 1; j < index; j++) {
            num[j] = Math.min(num[i] * 2, Math.min(num[m] * 3, num[n] * 5));
            if (num[j] == num[i] * 2) i++;
            if (num[j] == num[m] * 3) m++;
            if (num[j] == num[n] * 5) n++;
        }
        return num[index - 1];
    }

    //大数乘法
    public static String solve(String s1,String s2){
        char chars1[] = s1.toCharArray();
        char chars2[] = s2.toCharArray();
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            n1[i] = chars1[i] - '0';
        }
        for (int i = 0; i < chars2.length; i++) {
            n2[i] = chars2[i] - '0';
        }
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                result[i+j] = result[i+j]+n1[i]*n2[j];
            }
        }
        //满10进位
        for (int i = result.length-1; i > 0; i--) {
            result[i-1] += result[i] / 10;
            result[i] = result[i]%10;
        }
        String str = "";//转换位字符串返回
        for (int i = 0; i < result.length-1; i++) {
            str = str + result[i];
        }
        return str;
    }

    //大数加法
    public static String bigAdd(String s1,String s2){
        int i = s1.length()-1;
        int j = s2.length()-1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i>=0 || j>=0 || carry != 0){
            int x = i < 0 ? 0 : s1.charAt(i--) - '0';
            int y = j < 0 ? 0 : s2.charAt(j--) - '0';
            int sum = x+y+carry;
            builder.append(sum%10);
            carry = sum/10;
        }
        return builder.reverse().toString();
    }
}
