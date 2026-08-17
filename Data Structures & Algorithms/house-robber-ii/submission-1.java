class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        int one = helper(1,n-1,nums,dp);
        Arrays.fill(dp,-1);
        int two = helper(0,n-2,nums,dp);
        return Math.max(one,two);
    }
    private int helper(int i, int end, int nums[], int dp[]){
        if(i>end) return 0;
        if(dp[i]!=-1) return dp[i];
        int rob = nums[i]+helper(i+2,end,nums,dp);
        int notrob = helper(i+1,end,nums,dp);
        return dp[i]=Math.max(rob,notrob);
    }
}
