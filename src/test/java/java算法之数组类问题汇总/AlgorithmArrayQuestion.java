package java算法之数组类问题汇总;

import java.util.*;

public class AlgorithmArrayQuestion {


    /**
     * 优化法(求两个数之和)
     * @param numbers
     * @param target
     * @return
     */
    //ok
    public int[] twoSum1 (int[] numbers, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int result = target - numbers[i];
            if(hashMap.containsKey(result)){
                return new int[]{hashMap.get(result),i};
            }
            hashMap.put(numbers[i],i);
        }
        return null; //返回值
    }
    /**
     * 暴力法(求两个数之和)
     * @param numbers
     * @param target
     * @return
     */
    //ok
    public int[] twoSum2 (int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(target - numbers[i] == numbers[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 求最小的K个数（排序）
     * @param input
     * @param k
     * @return
     */
    //ok 排序算法的理解
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 1; i <= k; i++) {
            list.add(new Integer(i));
        }
        return list;
    }

    /**
     * 二分查找（掌握）
     * @param nums
     * @param target
     * @return
     */
    //ok
    public int search (int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;  //int mid = (right-left)*(mid-arr[left])/(arr[right]-arr[left])
            int insertMid = (right-left)*(mid-nums[left])/(nums[right]-nums[left]);//插值查找
            if(nums[mid] == target){
                while (mid != 0 && nums[mid] == nums[mid - 1]){
                    mid--;
                }
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     *  * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
     *  * 子数组是连续的，比如[1,2,3,4,5]的子数组有[1,2]，[2,3,4]等等，但是[1,3,4]不是子数组
     * @param arr
     * @return
     */
    //利用set的无重复性解决
    public static int maxLength (int[] arr) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        int r = 0;
        int l = 0;
        int count = 0;//最长无重复元素子数组的长度
        while (l < arr.length && r < arr.length){
            if(set.contains(arr[r]) == false){  //如果集合中没有重复的值
                set.add(arr[r]);//添加集合
                r++;//后移
                count = Math.max(r-l,count);//（默认为0）更新最长无重复元素子数组的长度
            }else { //如果集合中没有重复的值,那么就移除
                set.remove(arr[l]);
                l++;
            }
        }
        return count;
    }

    /**
     * 找出数组的第二大数
     * @param arr
     * @return
     */
    //找出数组的第二大数 🆗
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

    /**
     * 斐波那契数列第n项
     * @param n
     * @return
     */
    //递归法 🆗
    public static int Fibonacci(int n) {
        if(n == 0 || n==1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
    //迭代法 🆗
    public static int fib(int n){
        if(n == 0 || n==1){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 青蛙跳台阶
     * @param n
     * @return
     */
    //递归法 🆗
    public int jump(int n){
        if(n==1 || n == 0){
            return 1;
        }
        int a = 1;
        int b = 1;
        int sum = a+b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a+b)%1000000007;
        }
        return sum;
    }
    //迭代法 🆗
    public int jump1(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return jump1(n-1) + jump1(n-2);
    }

    /**
     * 找出两个数和等于sum的数
     * @param arr
     * @param sum
     */
    // 🆗
    public static void findSum(int arr[],int sum){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum){
                    System.out.println(arr[i]+" "+arr[j]);
                }
            }
        }
    }

    /**
     * 数组的最大、最小值
     * @param arr
     */
    // 欧克
    public static void getMaxAndMin(int arr[]){
        int max = arr[0];//最大值
        int min = arr[0];//最小值
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
    //🆗
    public static void getMaxMinValue(int arr[]){
        int max = arr[0];int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
        }
        //Arrays.stream(arr).min();
        System.out.println("max ="+max+" " + "min ="+min);
    }

    /**
     *
     *  * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
     *  * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。
     *  * 请你设计一个算法来计算可以获得的最大收益。
     *
     * @param prices
     * @return
     */
    //类似于选择排序 🆗
    public int maxProfit (int[] prices) {
        // write code here
        int minValue = prices[0];//最小收益
        int price = 0;//收益
        for (int i = 1; i < prices.length; i++) {
            if(minValue>prices[i]){
                minValue = prices[i];
            }
            price = Math.max(price,prices[i]-minValue);//最大获益值
        }
        return price;
    }
    //要想获得最大收益就必须买最小的，然后卖最大的！
    public int maxValue(int arr[]){
        int min = arr[0]; //假设第一个最小
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
            value = Math.max(value,arr[i] - min);
        }
        return value;
    }

    /**
     * 反转数子  12345 ===> 54321 (诸位取余相加)
     * @param x
     * @return
     */
    //简化版 🆗
    public int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = 10 * res + t;
            //res = res * 10 + x % 10;
            res = newRes;
            x /= 10;
        }
        //return (int) res == res ? (int) res : 0;
        return res;
    }

    /**
     * 判断回文数 12321 ===> 12321 回文数
     * @param x
     * @return
     */
    //判断回文数 🆗
    public static int huiwen1(int x) {
        int res = 0;
        int m = x;
        while (x != 0) {
            int t = x % 10;
            int newRes = 10 * res + t;
            //res = res * 10 + x % 10;
            res = newRes;
            x /= 10;
        }
        if(res == m){
            System.out.println("这是一个回文数！");
        }else {
            System.out.println("这不是一个回文数！");
        }
        //return (int) res == res ? (int) res : 0;
        return res;
    }


    /**
     * 公式：AB*CD = AC (BC+AD) BD
     * * 然后从后到前满十进位，顺序如右(BD,(BC+AD),AC)。
     * @param num1          result[i+j]+=n1[i]*n2[j];
     *                      result[i-1] += result[i] / 10;
     *                      result[i] = result[i] % 10;
     * @param num2
     * @return
     */
    //大数乘法 🆗
    public static String multiply(String num1, String num2){
        //把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();
        //声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];
        //把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for(int i = 0; i < chars1.length;i++)
            n1[i] = chars1[i]-'0';
        for(int i = 0; i < chars2.length;i++)
            n2[i] = chars2[i]-'0';
        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for(int i =0 ; i < chars1.length; i++){
            for(int j =0; j < chars2.length; j++){
                result[i+j]+=n1[i]*n2[j];
            }
        }
        //满10进位，从后往前满十进位
        for(int i =result.length-1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        //转成string并返回
        String resultStr = "";
        for(int i = 0; i < result.length-1; i++){
            resultStr+=""+result[i];
        }
        return resultStr;
    }

    /**
     * 大数加法
     * @param s1
     * @param s2
     * @return
     */
    //大数相加
    public static String maxAdd2(String s1,String s2){
        StringBuilder stringBuilder = new StringBuilder();
        int i = s1.length()-1;int j = s2.length()-1;
        int carry = 0;
        while (i>=0 || j>=0 || carry != 0){
            int x = i < 0 ? 0 : s1.charAt(i--)-'0';
            int y = j < 0 ? 0 : s2.charAt(j--)-'0';
            int sum = x + y + carry;
            stringBuilder.append(sum%10);
            carry = sum/10;
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *  * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，
     *  * 因此输出2。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *  * 1<=数组长度<=50000
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array){
        //quicksort(array,0,array.length-1);//先排序
        Arrays.sort(array);
        int value = array[array.length/2];//中间的值
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            if(value == array[i]){
                count++;
            }
        }
        if(count > array.length/2){
            return value;
        }
        return -1;//表示没有找到超过一般的数子
    }

    /**
     * 数组的最大累加和
     * @param arr
     * @return
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        int max = arr[0];//假设第一个数累计和最大
        for (int i = 1; i < arr.length; i++) { //依次比较进行交换
            arr[i] = Math.max(arr[i],arr[i]+arr[i-1]);
            max = Math.max(max,arr[i]);
        }
        return max;
    }

    /**
     *
     *  * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
     *  * 注意：
     *  * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
     *  * 解集中不能包含重复的三元组。
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //先排序避免重复
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();//解集
        for (int i = 0; i < num.length - 2; ++i) {
            if (i != 0 && num[i - 1] == num[i])
                continue;
            int k = num.length - 1;
            for (int j = i + 1; j < num.length - 1; ++j) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;
                while (j < k && num[i] + num[j] + num[k] > 0)
                    --k;
                if (j == k)
                    break;
                if (num[i] + num[j] + num[k] == 0) {
                    ArrayList<Integer> ele = new ArrayList<>();
                    ele.add(num[i]);
                    ele.add(num[j]);
                    ele.add(num[k]);
                    list.add(ele);
                }
            }
        }
        return list;
    }

    /**
     * 合并两个数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j])
                temp[index++] = nums1[i++];
            else
                temp[index++] = nums2[j++];
        }
        for (; i < m; ) {
            temp[index++] = nums1[i++];
        }
        for (; j < n; ) {
            temp[index++] = nums2[j++];
        }
        //再把数组temp中的值赋给nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
    }

    /**
     * 求连续数组缺失的数子
     * @param arr
     * @return
     */
    public static int solve(int arr[]){
        int sum = 0;
        int presum = arr.length * (arr.length + 1) / 2;//对数组进行求和.等差数列就和
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return presum - sum;
    }

    /**
     * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
     * 路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
     * 矩阵的最小路径和
     * @param matrix
     * @return
     */
    public int minPathSum (int[][] matrix) {
        // write code here
        int arr[][] = new int[matrix.length][matrix[0].length];
        arr[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            arr[i][0] = arr[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            arr[0][i] = arr[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = matrix[i][j] + Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr[matrix.length - 1][matrix[0].length - 1];
    }

    /**
     * 零一背包（动态规划）
     * @param V
     * @param n
     * @param vw
     * @return
     */
    public int knapsack (int V, int n, int[][] vw) {
        // write code here
        int[][] dp = new int[n+1][V+1];
        for(int i = 1; i<=n;i++){
            for(int j = 1;j<=V;j++){
                if(j<vw[i-1][0]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-vw[i-1][0]]+vw[i-1][1]);
                }
            }
        }
        return dp[n][V];
    }

    /**
     * 二进制中1的个数
     * @param n
     * @return
     */
    public static int numberOf1(int n){
        int count = 0;
        while (n!=0){
            count++;
            //n&(n-1)都会减少1个1
            n = n&(n-1);//现考虑二进制数：val :1101000, val-1: 1100111 那么val & （val-1） : 1100000
        }
        return count;
    }

    /**
     * 给出一组候选数C 和一个目标数 T，找出候选数中起来和等于 T 的所有组合。
     * C中的每个数字在一个组合中只能使用一次。
     * @param num
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        if(num == null || num.length <= 0) return null;
        Arrays.sort(num);
        dfs(num,visited,target,0,list,result);
        return result;
    }
    public static void dfs(int[] num,boolean[] visited, int diff, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(diff == 0 && !result.contains(list)){//找到一个合法解
            result.add(new ArrayList<>(list));//这里要注意！！！！！一定要new
            return;
        }
        for (int i = start; i < num.length; i++) {//扩展状态
            if(diff < num[i]) return ;   //剪枝
            if(!visited[i]){
                list.add(num[i]);           //执行扩展动作
                visited[i] = true;
                dfs(num,visited,diff-num[i],i,list,result);
                list.remove(list.size()-1);         //撤销扩展动作
                visited[i] = false;
            }
        }
    }

    /**
     * 数组中只出现一次的值
     * @param arr
     * @param k
     * @return
     */
    public int foundOnceNumber (int[] arr, int k) {
        // write code here
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == arr[i+1]){
                i = i + k - 1;
            }else {
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }

    //详细算法，利用set的元素不能重复性。@author YYM。
    public static Set<Integer> searchSingle(int[]nums) {
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0;i<nums.length;i++) {
            if(!set1.add(nums[i])) {//如果添加不成功
                set1.remove(nums[i]);
            }
        }
        return set1;
    }

    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int i = 0, m = 0, n = 0;
        int[] num = new int[index];
        num[0] = 1;
        for (int j = 1; j < index; j++) {
            num[j] = Math.min(num[i] * 2, Math.min(num[m] * 3, num[n] * 5));
            if (num[j] == num[i] * 2) i++;
            if (num[j] == num[m] * 3) m++;
            if (num[j] == num[n] * 5) n++;
        }
        return num[index - 1];
    }

    /**
     * 阶乘后面含有0的个数
     * @param n
     * @return
     */
    public long thenumberof_0 (long n) {
        //每次对10取余，然后再/10，再取余
        if(n==0) {
            return 1;
        }
        //结果为0的个数只与2与5的个数有关。因为2的个数肯定要大于5的个数，所以只要关注5的个数就可以了.
        long i=5,count=0;
        while(i<=n){
            count=count+n/i;
            i=i*5;//5有1个5，因此n是5的几倍就有几个5，而n有几个25又多出一个5来
        }
        return count;
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void maoPao(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }

    /**
     * 合并排序
     * @param arr
     * @param left
     * @param middle
     * @param rihgt
     * @param temp
     */
    public static void merge(int arr[],int left,int middle,int rihgt,int temp[]){
        int i = left;
        int j = middle+1;
        int t = 0;

        while (i<=middle && j<=rihgt){
            if(arr[i]<arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while (i<=middle){
            temp[t++] = arr[i++];
        }
        while (j<=rihgt){
            temp[t++] = arr[j++];
        }

        t = 0;
        int templeft = left;
        while (templeft<=rihgt){
            arr[templeft++] = temp[t++];
        }
    }

    public static void mergeSort(int arr[],int left,int right,int temp[]){
        if(left<right){
            int middle = (left+right)/2;
            mergeSort(arr,left,middle,temp);
            mergeSort(arr,middle+1,right,temp);
            merge(arr,left,middle,right,temp);
        }
    }

    /**
     * 基数排序方法
     * @param arr
     */
    //基数排序方法
    public static void radixSort(int[] arr) {

        //根据前面的推导过程，我们可以得到最终的基数排序代码

        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();


        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];


        //这里我们使用循环将代码处理

        for(int i = 0 , n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for(int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for(int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if(bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for(int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;

            }
            //System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        }
    }

    /**
     * 堆排序
     * @param arr
     * @param i
     * @param length
     */
    public static void adjust(int arr[],int i,int length){
        int temp = arr[i];
        for (int j = 2*i+1; j < length; j=2*i+1) {
            if(j+1<length && arr[j+1]>arr[j]){ //左子树大于右子树
                j++;
            }
            if(arr[j]>temp){       //如果大于当前节点值
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
            arr[i] = temp;  //循环比较
        }
    }

    public static void heapSort(int arr[]){
        //构建大顶堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        //将堆顶元素与末尾交换
        for (int i = arr.length-1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr,0,i);
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int arr[]){
        for (int gap = arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if(arr[j]>arr[gap+j]){
                        int t = arr[j];
                        arr[j] = arr[gap+j];
                        arr[gap+j] = t;
                    }
                }
            }
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int arr[],int left,int right){
        int l = left;
        int r = right;
        int q = arr[(left+right)/2];
        while (l<r){
            while (arr[l]<q){
                l++;
            }
            while (arr[r]>q){
                r--;
            }
            if(l>=r){
                break;
            }
            int t = arr[l];arr[l] = arr[r];arr[r] = t;
            if(arr[l]==q){
                r--;
            }
            if(arr[r]==q){
                l++;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if(left<r){
            quickSort(arr,left,r);
        }
        if(right>l){
            quickSort(arr,l,right);
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int arr[]){
        for (int i = 0; i <arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && insertVal<arr[insertIndex]){   //没有找到插入位置，需要后移
                arr[insertIndex+1] = arr[insertIndex];   //没有找到插入位置，需要后移
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }

}
