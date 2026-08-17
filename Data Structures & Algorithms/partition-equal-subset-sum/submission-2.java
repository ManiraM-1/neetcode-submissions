class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int x: nums){
            total+=x;
        }
        if(total%2 != 0) return false;
        int half = total/2;
        return helper(0,nums,0,half);
    }
    private boolean helper(int i, int[] nums, int currSum, int half){
        if(currSum==half)return true;
        if(i==nums.length || currSum > half)return false;
        boolean take = helper(i+1,nums,currSum+nums[i],half);
        boolean not = helper(i+1,nums,currSum,half);
        return take||not;
    }
}
