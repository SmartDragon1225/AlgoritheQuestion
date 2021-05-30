package 算法练习第三天5月14日;

public class 找出数组第二大数 {
    public static void main(String[] args) {
        int arr[] = {0,3,4,5,6,7,3,9,10,11,12};
        System.out.println(getSecond(arr));
    }

    public static int getSecond(int arr[]){
        int max = arr[0];//最大数
        int second_Max = Integer.MIN_VALUE;//第二大数默认为最小
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                second_Max = max;
                max = arr[i];
            }else {
                if(arr[i]>second_Max){
                    second_Max = arr[i];
                }
            }
        }
        return second_Max;
    }
}
