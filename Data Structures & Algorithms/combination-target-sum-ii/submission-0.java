class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,ans,al);
        return ans;
    }
    private void helper(int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> al){
        if(target==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        if(target<0 || idx==nums.length) return;

        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i]==nums[i-1]) continue;

            al.add(nums[i]);
            helper(i+1,nums,target-nums[i],ans,al);
            al.remove(al.size()-1);
        }
    }
}
