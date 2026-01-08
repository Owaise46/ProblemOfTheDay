class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int[][] dp = new int[n][m];
        
        dp[0][0] = nums1[0] * nums2[0];
        
        // Initialize first row
        for (int j = 1; j < m; j++) {
            int prod = nums1[0] * nums2[j];
            dp[0][j] = Math.max(prod, dp[0][j - 1]);
        }
        
        // Initialize first column
        for (int i = 1; i < n; i++) {
            int prod = nums1[i] * nums2[0];
            dp[i][0] = Math.max(prod, dp[i - 1][0]);
        }

        // Fill DP
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                
                int prod = nums1[i] * nums2[j];
                
                // Option to extend or start fresh
                int bestWithPair = Math.max(prod, prod + dp[i-1][j-1]);
                
                dp[i][j] = Math.max(bestWithPair,
                               Math.max(dp[i-1][j],
                                        dp[i][j-1]));
            }
        }
        
        return dp[n-1][m-1];
    }
}
