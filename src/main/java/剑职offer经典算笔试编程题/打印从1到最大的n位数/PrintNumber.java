package 剑职offer经典算笔试编程题.打印从1到最大的n位数;

import java.util.Arrays;

public class PrintNumber {
    public static void main(String[] args) {
        int[] numbers = new PrintNumber().printNumbers(2);
        System.out.println(Arrays.toString(numbers));
    }

    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10,n) - 1;
        int result[] = new int[end];
        for (int i = 0; i < end; i++) {
            result[i] = i + 1;
        }
        return result;
    }

}
