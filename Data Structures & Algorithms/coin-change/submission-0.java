class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        int ans = helper(0,coins,amount,dp);
        return ans == Integer.MAX_VALUE/2 ? -1: ans;
    }
    private int helper(int i, int[] coins, int amount, int[][] dp){
        if(i>=coins.length) return Integer.MAX_VALUE/2;
        if(amount==0) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take  = Integer.MAX_VALUE/2;
        if(amount-coins[i]>=0){
            take = 1+helper(i,coins,amount-coins[i], dp);
        }
        int not = helper(i+1,coins,amount, dp);
        return dp[i][amount]=Math.min(take,not);

    }
}
