package 算法练习第四天5月15日.二分查找;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,3,2,2,2,2,2,3,4};
        System.out.println(search(arr,2));
        System.out.println(binaryFind(arr,2));
    }

    public static int binarySearch(int arr[],int target){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid1 = (left+right)/2;//普通二分法
            int mid = left + (right-left)*(target-arr[left])/(arr[right]-arr[left]);//插入二分查找(效率高)
            if(arr[mid] == target){
                while(mid != 0 &&(arr[mid-1] == arr[mid])){
                    mid--;
                }//处理特列情况
                return mid;
            }else if(target>arr[mid]){
                left = mid + 1;
            }else if(target<arr[mid]){
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int search(int arr[],int val){
        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            int mid1 = l + (r-l)*(val-arr[l])/(arr[r]-arr[l]);
            if(arr[mid]==val){         //优化
                while (mid != 0 && arr[mid-1]==arr[mid]){
                    mid--;
                }
                return mid;
            }else if(arr[mid]>val){
                r = mid - 1;
            }else if(arr[mid]<val){
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int binaryFind(int arr[],int value){
        int l = 0;
        int r = arr.length-1;
        while (l<r){
            int mid = arr[(l+r)/2];
            if(arr[mid] == value){
                while (mid!= 0 && arr[mid-1]== arr[mid]){
                    mid--;
                }
                return mid;
            }else if(arr[mid] > value){  //在右面
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
