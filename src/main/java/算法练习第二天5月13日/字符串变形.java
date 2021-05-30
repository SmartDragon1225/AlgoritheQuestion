package 算法练习第二天5月13日;

/**
 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。
 * 首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把着个字符串中由空格隔开的单词反序，
 * 同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。
 */
public class 字符串变形 {
    public static int count = 0;
    public static void main(String[] args) {
        System.out.println(new 字符串变形().tranes("This is a Dog", 13));
        int arr[] = {3,4,2,7,8,9,0,1,2,3,4,7};
        bubbleSort(arr);
        System.out.println(count);
    }

    public String tranes(String s,int n){
        String res = "";
        String temp = "";
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c>='a' && c<='z'){
                temp = temp + Character.toUpperCase(c);
            }else if(c>='A' && c<='Z'){
                temp = temp + Character.toLowerCase(c);
            }else {
                temp = temp + c;
                res = temp + res;
                temp = "";
            }
        }
        res = res + temp;
        return res;
    }

    /**
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

    public static void bubbleSort(int arr[]) {
        boolean didSwap;
        for(int i = 0, len = arr.length; i < len - 1; i++) {
            didSwap = false;
            for(int j = 0; j < len - i - 1; j++) {
                if(arr[j + 1] < arr[j]) {
                    int t = arr[j+1];
                    arr[j+1] =arr[j];
                    arr[j] = t;
                    didSwap = true;
                }
                count++;
            }
            if(didSwap == false){
                return;
            }
        }
    }

}
