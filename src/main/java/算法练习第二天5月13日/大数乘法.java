package 算法练习第二天5月13日;

import java.util.Arrays;

public class 大数乘法 {
    public static void main(String[] args) {
        maxmultiply("121324454545454556454545454454544645445545454545454645545" +
                "13","325151515515151515115321256565565565655621212121212121212121112121132132");
        System.out.println(multiply("121324454545454556454545454454544645445545454545454645545" +
                "13", "325151515515151515115321256565565565655621212121212121212121112121132132"));
        System.out.println(maxAdd("121324454545454556454545454454544645445545454545454645545" +
                "13", "3251515155151515151153212565655655656556212121212121212"));
        System.out.println(bigMul("12","2"));
        maxmultiply("2","5");
    }

    /**
     * 公式：AB*CD = AC (BC+AD) BD
     * * 然后从后到前满十进位，顺序如右(BD,(BC+AD),AC)。
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2){
        //把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();
        //声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];
        //把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for(int i = 0; i < chars1.length;i++)
            n1[i] = chars1[i]-'0';
        for(int i = 0; i < chars2.length;i++)
            n2[i] = chars2[i]-'0';
        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for(int i =0 ; i < chars1.length; i++){
            for(int j =0; j < chars2.length; j++){
                result[i+j]+=n1[i]*n2[j];
            }
        }
        //满10进位，从后往前满十进位
        for(int i =result.length-1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        //转成string并返回
        String resultStr = "";
        for(int i = 0; i < result.length-1; i++){
            resultStr+=""+result[i];
        }
        return resultStr;
    }

    public static void maxmultiply(String s1, String s2){
        //转数组
        char chars1[] = s1.toCharArray();
        char chars2[] = s2.toCharArray();
        //声明存放乘法的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];
        //把char转int数组
        for (int i = 0; i < chars1.length; i++) {
            n1[i] = chars1[i] - '0';
        }
        for (int i = 0; i < chars2.length; i++) {
            n2[i] = chars2[i] - '0';
        }
        //逐个相乘，然后进位
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                result[i+j] = result[i+j] + n1[i]*n2[j];//核心
            }
        }
        //满10进位
        for (int i = result.length-1; i > 0; i--) {
            result[i-1] = result[i-1] + result[i]/10;//核心
            result[i] = result[i]%10; //核心
        }
        System.out.println(Arrays.toString(result));
       /* //转成string并返回
        String str = "";
        for (int i = 0; i < result.length-1; i++) {
            str = str+result[i];
        }
        return str;*/
    }

    public static String maxAdd(String s1,String s2){
        int i = s1.length()-1;
        int j = s2.length()-1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i>=0 || j>=0 || carry != 0){
            int x = i < 0 ? 0 : s1.charAt(i--)-'0';
            int y = j < 0 ? 0 : s2.charAt(j--)-'0';
            int sum = x + y + carry;
            stringBuilder.append(sum%10);
            carry = sum/10;
        }
        return stringBuilder.reverse().toString();
    }

    public static String bigMul(String s1,String s2){
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
                result[i+j] += n1[i]*n2[j];
            }
        }
        for (int i = result.length-1; i > 0; i--) {
            result[i-1] += result[i]/10;
            result[i]  = result[i] % 10;
        }
        String str = "";
        for (int i = 0; i < result.length-1; i++) {
            str += result[i];
        }
        return str;
    }
}
