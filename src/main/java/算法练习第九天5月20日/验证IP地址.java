package 算法练习第九天5月20日;

/**
 * IPv6的错误形式可能有如下：
 *
 * 多了0
 * 出现::
 * 字符不在0-9 a-f A-F之间
 * IPv4错误形式可能有如下：
 *
 * 多了首位'0'
 * 超过0-255范围
 * 出现的..
 */
public class 验证IP地址 {
    public static void main(String[] args) {
        System.out.println(new 验证IP地址().solve("192.168.1.1"));
    }

    public String solve (String IP) {
        // write code here
        if (IP == null && IP.length() == 0){
            return "Neither";
        }
        if (IP.contains(":")){
            String[] fields = IP.split(":");
            if (fields.length != 8){
                return "Neither";
            }
            for (String field : fields) {
                if (!isIPV6(field)){
                    return "Neither";
                }
            }
            return "IPv6";
        }else if (IP.contains(".")){
            String[] fields = IP.split("\\.");
            if (fields.length != 4){
                return "Neither";
            }
            for (String field : fields) {
                if (!isIPV4(field)){
                    return "Neither";
                }
            }
            return "IPv4";
        }else {
            return "Neither";
        }
    }

    private boolean isIPV6(String str){
        if (str.length() > 4 || str.length() == 0){
            return false;
        }
        try {
            int max = Integer.valueOf("FFFF",16);
            int num = Integer.valueOf(str, 16);

            if (num > max){
                return false;
            }
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private boolean isIPV4(String str){
        if (str.length() == 0 || str.length() > 3){
            return false;
        }
        try {
            int n = str.length();
            int num = Integer.valueOf(str);
            if (num > 255 || num < 0){
                return false;
            }
            if (n == 3 && num < 100){
                return false;
            }
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
