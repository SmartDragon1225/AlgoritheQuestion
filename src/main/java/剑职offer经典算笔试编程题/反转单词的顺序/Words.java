package 剑职offer经典算笔试编程题.反转单词的顺序;

public class Words {
    public static void main(String[] args) {
        String s = new Words().reverseWords("I am a boy!");
        System.out.println(s);
    }

    public String reverseWords(String s){
        StringBuilder builder = new StringBuilder();
        String str[] = s.trim().split(" ");
        for (int i = str.length-1; i >= 0; i--) {
            if(str[i].equals(" ")){
                continue;
            }
            builder.append(str[i]+" ");
        }
        return builder.toString().trim();//删除末尾的空格！
    }
}
