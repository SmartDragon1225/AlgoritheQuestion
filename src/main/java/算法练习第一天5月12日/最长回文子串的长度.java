package 算法练习第一天5月12日;

/**
 * 求出最长数子串的长度
 */
public class 最长回文子串的长度 {
    public static void main(String[] args) {
         Str("abc1234321ab2",13);
    }

    public static void Str(String str,int n) {
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
        System.out.println(result.length());
    }


}
