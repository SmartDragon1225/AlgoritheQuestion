package 算法练习第三天5月14日;

public class 数组最大最小值 {
    public static int max;
    public static int min;
    public static void main(String[] args) {
        int arr[] = {0,9,3,4,5,6,7,3,9};
        getMaxAndMin(arr);
        System.out.println(max);
        System.out.println(min);
    }

    public static void getMaxAndMin(int arr[]){
        max = arr[0];//最大值
        min = arr[0];//最小值
        for (int i = 0; i < arr.length-1; i=i+2) {
            if(i+1>arr.length){
                if(arr[i]>max){
                    max = arr[i];
                }
                if(arr[i]<min){
                    min = arr[i];
                }
            }
            if(arr[i]>arr[i+1]){
                if(arr[i]>max){
                    max = arr[i];
                }
                if(arr[i+1]<min){
                    min = arr[i+1];
                }
            }
            if(arr[i]<arr[i+1]){
                if(arr[i+1]>max){
                    max = arr[i+1];
                }
                if(arr[i]<min){
                    min = arr[i];
                }
            }
        }
    }
}
