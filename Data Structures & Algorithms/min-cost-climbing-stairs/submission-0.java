class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(helper(0,cost,dp),helper(1,cost,dp));
    }
    private int helper(int i,int[] cost, int[]dp){
        int n = cost.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int one = cost[i]+helper(i+1,cost,dp);
        int two = cost[i]+helper(i+2,cost,dp);
        return dp[i]=Math.min(one,two);
    }
}
