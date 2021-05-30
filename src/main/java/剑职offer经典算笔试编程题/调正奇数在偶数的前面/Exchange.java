package 剑职offer经典算笔试编程题.调正奇数在偶数的前面;

public class Exchange {
    public static void main(String[] args) {

    }

    //首尾双指针链表中倒数第k个节点
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length-1, temp;
        while(i < j){
            while((nums[i] & 1) == 1 && i<j){
                i++;
            }
            while((nums[j] & 1) == 0 && j>0){
                j--;
            }
            if(i < j){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

    public int[] exchange1(int[] nums) {
        int i=0,j=0;
        while(j<nums.length){
            if((nums[j]&1)!=0){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;
            }
            j++;
        }
        return nums;
    }
}
