class Solution {
    public int climbStairs(int n) {
        return helper(0,n);
    }
    private int helper(int i, int n){
        if(i==n) return 1;
        if(i>n) return 0;
        int one = helper(i+1,n);
        int two = helper(i+2,n);
        return one+two;
    }
}
