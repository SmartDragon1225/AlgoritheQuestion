package 算法练习第三天5月14日;

import java.util.*;

public class 找出数组中只出现过一次的数 {
    public static void main(String[] args) {
        int arr[] = {0,0,3,1,4,5,6,7,3,9,11,10,12,11,12};
        int arr1[] = {1,2,3,2,4,3,5,4,1,5,6,7,8,9,0};
        System.out.println(findOnlyNum(arr));
        System.out.println(findRespetNum(arr1));
        System.out.println(firstStr("leetcode"));
        System.out.println(firstNum(arr,11));
    }

    //数组去重
    public static Set findOnlyNum(int arr[]){
        Set set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set;
    }

    //找出数组中重复的数，利用hashset特性进行求解
    public static List findRespetNum(int arr[]){
        List list = new ArrayList();
        Set set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if(!set.add(arr[i])){
                list.add(arr[i]);
            }
        }
        return list;
    }

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

    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
    //第一个只出现一次的数子的下标(要求目标值只出现一次)
    public static int firstNum(int arr[],int value){
        if(arr == null){
            return -1;
        }
        int index = 0;
        Arrays.sort(arr);
        while (index < arr.length){
            if(arr[index] == value){
                return index;
            }else {
                index = index + Math.abs(value-arr[index]);
            }
        }
        return -1;
    }


}
