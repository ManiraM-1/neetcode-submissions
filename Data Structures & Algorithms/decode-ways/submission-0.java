class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,s,dp);
    }
    private int helper(int i, String s, int[] dp){
        int n = s.length();
        if(i==n) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int ways = 0;
        
        // 1 digit
        ways += helper(i+1,s,dp);

        // 2 digits
        if(i+1<n){
            int two = Integer.parseInt(s.substring(i,i+2));
            if(two>=10 && two<=26){
                ways+=helper(i+2,s,dp);
            }
        }

        return dp[i]=ways;
        
    }
}
