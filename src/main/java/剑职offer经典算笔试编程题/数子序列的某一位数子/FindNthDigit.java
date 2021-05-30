package 剑职offer经典算笔试编程题.数子序列的某一位数子;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
 * 第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 */
public class FindNthDigit {
    public static void main(String[] args) {

    }

    //数子序列的某一位数子
    public int findNthDigit(int n) {
        if(n == 0) {
            return 0;
        }
        //由于是n=0时对应开始的0，这里不需要进行减操作n--;，但是如果n=1对应开始的0则需要减操作
        //排除n=0后，后面n从1开始。
        int digit = 1;
        int start = 1;
        long count = 9; //count的值有可能会超出int的范围，所以变量类型取为long
        while (n > count) {//不能带=号，此时n从1开始，n=count时，属于上一个循环的最后一个数字
            n = (int)(n - count);//这里(int)不能省略
            digit++;
            start = start * 10;
            count = (long)start * 9 * digit;
            //这里的long不能省略，否则，会先按照int类型进行计算，然后赋值给long型的count，超过int大小限制时，会出现负数
        }
        int num = start + (n - 1) / digit;
        int index = (n-1) % digit;//index最大取digit-1,即此时num坐标从左到右为0,1,...,digit-1,共digit位
        while (index < (digit - 1)){
            //最后的结果是num中的第index个数字，index从左到右从0开始递增，考虑到踢出右侧末尾的数字比较简单，我们从右侧开始依次踢出数字
            num = num / 10;
            digit--;
        }
        return num % 10;//此时num的右侧末尾数字即为结果
    }
}
