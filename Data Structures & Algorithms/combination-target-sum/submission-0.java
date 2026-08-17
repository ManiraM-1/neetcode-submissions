class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        helper(0,nums,target,ans,al);
        return ans;
    }
    private void helper(int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> al){
        if(target==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        if(target<0 || idx==nums.length) return;
        //take
        al.add(nums[idx]);
        helper(idx,nums,target-nums[idx],ans,al);
        al.remove(al.size()-1);
        //not
        helper(idx+1,nums,target,ans,al);
    }
}
