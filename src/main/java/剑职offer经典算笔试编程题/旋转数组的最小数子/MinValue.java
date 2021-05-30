package 剑职offer经典算笔试编程题.旋转数组的最小数子;

public class MinValue {
    public static void main(String[] args) {
        int arr[] = {1,2,4,3,6,8,7,5};
        new MinValue().min(arr);
        System.out.println(new MinValue().minArray(arr));
    }

    public void min(int arr[]){
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("max = "+max);
        System.out.println("min = "+min);
    }

    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
