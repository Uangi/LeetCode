class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int minPrice = Integer.MAX_VALUE;  // 최소 가격을 최대값으로 초기화
        int maxProfit = 0;  // 최대 이익을 0으로 초기화
        
        // 가격 배열을 순회하면서 최소 가격과 최대 이익을 갱신
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;  // 최소 가격 갱신
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;  // 최대 이익 갱신
            }
        }
        
        return maxProfit;
    }
}