package 算法练习第五天5月16日;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 *
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 *
 *
 */
public class 最长回文字串 {
    public static void main(String[] args) {
        System.out.println(new 最长回文字串().getLongestPalindrome1("b", 1));
        System.out.println(new 最长回文字串().isPalindrome("baabc", 0,4 ));
        System.out.println(new 最长回文字串().isNumber("ba12"));
    }

    public int getLongestPalindrome(String A, int n) {
        //边界条件判断
        if (n < 2)
            return A.length();
        //maxLen表示最长回文串的长度
        int maxLen = 0;
        for (int i = 0; i < n; ) {
            //如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
            // （因为即使他是回文子串，也不是最长的，所以直接终止循环，不再判断）
            if (n - i <= maxLen / 2)
                break;
            int left = i;
            int right = i;
            while (right < n - 1 && A.charAt(right + 1) == A.charAt(right))
                ++right; //过滤掉重复的

            //下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            //然后往两边判断，找出回文子串的长度
            while (right < n - 1 && left > 0 && A.charAt(right + 1) == A.charAt(left - 1)) {
                ++right;
                --left;
            }
            //保留最长的
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
            }
        }
        //截取回文子串
        return maxLen;
    }

/**暴力求解
    暴力求解是最容易想到的，要截取字符串的所有子串，然后再判断这些子串中哪些是回文的，最后返回回文子串中最长的即可。

    这里我们可以使用两个变量，一个记录最长回文子串开始的位置，一个记录最长回文子串的长度，最后再截取。代码如下：
 */
    public int getLongestPalindrome1(String A, int n) {
        //边界条件判断
        if (n < 2)
            return A.length();
        int maxLen = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                //截取所有子串，然后在逐个判断是否是回文的
                if (isPalindrome(A, i, j)) {
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return maxLen;
    }
    //判断是否为数子
    public boolean isNumber(String s){
        char arr[] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if('0'<arr[i]&& arr[i]<'9'){
                return true;
            }
        }
        return false;
    }

    //判断是否是回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) //转数组
                return false;
        }
        return true;
    }

    //判断最长回文串的长度
    public int getLong(String A,int n){
        if(n < 2){  //如果是一个字符，直接返回
            return A.length();
        }
        int max_len = 0;
        for (int i = 0; i < A.length()-1; i++) {
            for (int j = i; j < A.length(); j++) {
                if(isPalindrome(A,i,j)){
                    if(max_len < j-i+1){
                        max_len = j-i+1;
                    }
                }
            }
        }
        return max_len;
    }
}
