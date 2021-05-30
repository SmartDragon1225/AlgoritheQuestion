package 算法练习第二天5月13日;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class 第一个出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(new 第一个出现一次的字符().FirstNotRepeatingChar("qaassddew"));
    }

    public int FirstNotRepeatingChar(String str) {
        int arr[] = new int[100];
        for (int s = 0; s < str.length(); s++) {
            arr[str.charAt(s)-'0'] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if(arr[str.charAt(i)-'0']==1){         //str.charAt(i)-'0'   转化为字符串
                return i;
            }
        }
        return -1;
    }
}
