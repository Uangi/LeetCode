class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp 배열을 사용하여 최소 비용을 저장
        int[] dp = new int[n + 1];
        
        // 초기값 설정
        dp[0] = 0;
        dp[1] = 0;
        
        // DP를 이용하여 최소 비용을 계산
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        
        // 마지막 계단에 도달했을 때의 최소 비용 반환
        return dp[n];
    }
}