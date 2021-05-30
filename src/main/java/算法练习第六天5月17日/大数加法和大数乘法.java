package 算法练习第六天5月17日;

import java.util.Arrays;

public class 大数加法和大数乘法 {
    public static void main(String[] args) {
        System.out.println(bigAdd("232323231","223232321"));
        System.out.println(bigMult("2232323231","3232323231"));
        int arr[] = {0,-3,-2,4,5,7,8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *             int x = i < 0 ? 0 : s1.charAt(i--) - '0';
     *             int y = j < 0 ? 0 : s2.charAt(j--) - '0';
     *             int sum = x + y + carry;
     *             stringBuilder.append(sum%10);
     *             carry = sum / 10;
     * @param s1
     * @param s2
     * @return
     */
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

    /**
     *    result[i+j] = result[i+j] + n1[i]*n2[j]; 计算
     *    result[i-1] = result[i-1] + result[i]/10;  进位
     *    result[i] = result[i]%10;
     * @param s1
     * @param s2
     * @return
     */
    //大数乘法
    public static String bigMult(String s1,String s2){
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
                result[i+j] = result[i+j] + n1[i]*n2[j];
            }
        }
        //满10进位
        for (int i = result.length-1; i > 0; i--) {
            result[i-1] = result[i-1] + result[i]/10;
            result[i] = result[i]%10;
        }
        String str = "";
        for (int i = 0; i < result.length-1; i++) {
            str = str + result[i];
        }
        return str;
    }

    //堆排序
    public static void heapSort(int arr[]){
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            adjust(arr,0,i);
        }
    }

    //调整堆
    public static  void adjust(int arr[], int i, int length){
        int temp = arr[i];
        for (int j = 2*i+1; j < length; j=2*i+1) {
            if(j+1 < length && arr[j+1]>arr[j]){
                j++;
            }
            if(arr[j]>temp){
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
            arr[i] = temp;
        }
    }
}
