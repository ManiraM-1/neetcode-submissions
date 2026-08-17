class Solution {
    public int jump(int[] nums) {
        int l=0, r=0, ans=0;
        int n = nums.length;
        while(r<n-1){
            int maxJump = 0;
            for(int i=l; i<=r; i++){
                maxJump = Math.max(maxJump, nums[i]+i);
            }
            l = r+1;
            r=maxJump;
            ans++;
        }
        return ans;
    }
}
