package 算法练习第二天5月13日;

/**
 * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。
 * 请你设计一个算法来计算可以获得的最大收益。
 */
public class 买卖股票的最大收益 {
    public static void main(String[] args) {
        int arr[] = {2,4,1};
        System.out.println(new 买卖股票的最大收益().maxProfit(arr));
    }

    /**
     * 暴力解法
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

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

    public int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
