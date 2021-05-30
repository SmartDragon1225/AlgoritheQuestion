package 算法练习第三天5月14日;

public class 字符串替换空格 {
    public static void main(String[] args) {
        String str = "I love you";
        System.out.println(replacespace(str,"&"));
    }

   public static StringBuilder replacespace(String str,String tag){
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
}
