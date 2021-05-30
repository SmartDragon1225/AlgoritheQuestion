package java算法之String类型问题汇总;

public class AlgorithmStringQuestion {

    /**
     * 该方法存在不足之处！(替换括号！)
     * @param s
     * @return
     */
    public static boolean isValid (String s) {
        boolean flag = true;
        while (flag){
            int len = s.length();
            s = s.replace("()","");//字符替换发解决把（）{}【】替换为空。如果替换完为空就为ture
            s = s.replace("[]","");
            s = s.replace("{}","");
            if(len == s.length()){
                flag = false;
            }
        }
        return s.length() == 0;
    }

    /**
     * 最长回文子串的长度
     * @param str
     * @param n
     */
    public static int Str(String str,int n) {
        String result="";
        int count=0;//当作计算器
        char[]arr=str.toCharArray();//转换为字符数组；
        for(int i=0;i<n;i++){
            if('0'<=arr[i]&&arr[i]<='9'){
                //说明这些字符是数字
                count=1;//初始化计算器
                int index=i;
                for(int j=i+1;j<n;j++){
                    if('0'<arr[j]&&arr[j]<='9'){
                        count++;
                        index=j;
                    }else{
                        break;
                    }
                }if(count>result.length()){
                    result=str.substring(i,index+1);//返回i到index位置的字符串；
                }
            }else{
                continue;
            }
        }
        return result.length();
    }

    /**
     * 字符串替换空格（StringBuilder工具类）
     * @param str
     * @param tag
     * @return
     */
    public static StringBuilder replaceSpace(String str,String tag){
        if(str.length()<=0){
            System.out.println("错误！");
        }
        char arr[] = str.toCharArray();//转数组
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' '){
                stringBuilder.append(tag);
            }else {
                stringBuilder.append(arr[i]);
            }
        }
        return stringBuilder;
    }

    /**
     * 第一个只出现一次的字符的下标
     * @param str
     * @return
     */
    //第一个只出现一次的字符的下标
    public static int firstStr(String str){
        int arr[] = new int[100];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'0'] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if(arr[str.charAt(i)-'0']==1){
                return i;
            }
        }
        return -1;
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
     *
     *  * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。
     *  * 首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把着个字符串中由空格隔开的单词反序，
     *  * 同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。
     *
     * 三个条件，大写，小写，空格
     * @param s
     * @param n
     * @return
     */
    public String trans(String s, int n) {
        String res = "";
        String tempStr = "";
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c>='a'&& c<='z'){          //小写
                tempStr += Character.toUpperCase(c);
            } else if(c>='A'&& c<='Z'){     //大写
                tempStr += Character.toLowerCase(c);
            } else{                     //空格
                tempStr = c+tempStr; //反转单个字符串
                res = tempStr + res;
                tempStr="";         //处理完一个单词就置空
            }
        }
        res = tempStr+res;
        return res;
    }

    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 == 0 || len2 == 0)
            return "-1";
        int[][] dp = new int[len1+1][len2+1]; //动态规划思想
        for(int i = 0; i < len1+1; i++){
            for(int j = 0; j < len2+1; j++){
                //初始化行列第一个元素
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        //找出一个最长的公共子序列
        StringBuilder sb = new StringBuilder();
        int s1L = len1, s2L = len2;
        while(s1L != 0 && s2L != 0){
            if (s1.charAt(s1L-1) == s2.charAt(s2L-1)){
                sb.append(s1.charAt(s1L - 1));
                s1L--;
                s2L--;
            }else{
                if (dp[s1L-1][s2L] > dp[s1L][s2L-1]){
                    s1L--;
                }else{
                    s2L--;
                }
            }
        }
        if(sb.length() == 0)
            return "-1";
        return sb.reverse().toString();
    }


    /**
     * 判断最长回文子串的长度
     */
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
    //判断是否是回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) //转数组
                return false;
        }
        return true;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int solve(int arr[]){
        int sum = 0;
        int presum = arr.length * (arr.length + 1) / 2;//对数组进行求和.等差数列就和
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return presum - sum;
    }




}
