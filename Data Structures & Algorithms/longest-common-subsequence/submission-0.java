class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1][n2];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,0,text1,text2,n1,n2,dp);
    }
    private int helper(int i, int j, String s1, String s2, int n1, int n2, int[][]dp){
        if(i>=n1 || j>=n2) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+helper(i+1,j+1,s1,s2,n1,n2,dp);
                }
                else{
                    dp[i][j]=Math.max(helper(i+1,j,s1,s2,n1,n2,dp),helper(i,j+1,s1,s2,n1,n2,dp));
                }
        return dp[i][j];
    }
}
