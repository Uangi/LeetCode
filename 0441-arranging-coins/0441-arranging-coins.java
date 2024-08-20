class Solution {
    public int arrangeCoins(int n) {
        
        int left = 0, right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = (long) mid * (mid + 1) / 2;
            
            if (sum == n) {
                return mid;
            } else if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
    
}