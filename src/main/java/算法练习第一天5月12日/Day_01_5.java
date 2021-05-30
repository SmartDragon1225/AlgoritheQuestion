package 算法练习第一天5月12日;

import java.util.Stack;

public class Day_01_5 {
    public static void main(String[] args) {
        String s = "{}[()]{";
        System.out.println(isValid2(s));
        System.out.println(isValid(s));
    }

    /**
     * 该方法存在不足之处！
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
     *  //出栈，入栈操作！
     * @param s
     * @return
     */
    //出栈，入栈操作！
    public static boolean isValid2 (String s) {
        Stack<Character> c = new Stack<Character>();
        for(int i = 0 ; i < s.length(); i++){
            if(c.empty()){
                c.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i)==')'&&c.peek()=='('){
                c.pop();
            } else if(s.charAt(i)=='}'&&c.peek()=='{'){
                c.pop();
            } else if(s.charAt(i)==']'&&c.peek()=='['){
                c.pop();
            } else {
                c.push(s.charAt(i));
            }
        }
        return c.empty();//看是否为空！
    }
}
