package 剑职offer经典算笔试编程题.字符串替换空格;

public class Replace {
    public static void main(String[] args) {
        System.out.println(replacespace("i love you "));
        System.out.println(replacespace("i love you ","%20%"));
    }

    /**
     * 利用 StringBuilder 的可变性进行求解
     * @param str
     * @return
     */
    public static String replacespace(String str){
        String tag = "%20%";
        char s[] = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if(s[i] == ' '){
                stringBuilder.append(tag);
            }else {
                stringBuilder.append(s[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static String replacespace(String str,String shape){
        char s[] = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if(s[i] == ' '){
                stringBuilder.append(shape);
            }else {
                stringBuilder.append(s[i]);
            }
        }
        return stringBuilder.toString();
    }
}
