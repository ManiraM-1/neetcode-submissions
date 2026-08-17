class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,s,set,dp);
    }
    private boolean helper(int i, String s, Set<String>set,int[] dp){
        if(i==s.length()) return true;
        if(dp[i]!=-1) return dp[i]==1;
        for(int j=i; j<s.length(); j++){
            String subs = s.substring(i,j+1);
            if(set.contains(subs) && helper(j+1,s,set,dp)){
                dp[i]=1;
                return true;
            }
        }
        dp[i]=0;
        return false;
    }
}
