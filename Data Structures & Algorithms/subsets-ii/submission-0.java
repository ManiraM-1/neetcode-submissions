class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Arrays.sort(nums);
        //boolean flag[] = new boolean[nums.length];
        helper(0,nums,ans,al);
        return ans;
    }
    private void helper(int idx, int[] nums, List<List<Integer>> ans, List<Integer> al){
        ans.add(new ArrayList<>(al));


        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            al.add(nums[i]);
            helper(i+1,nums,ans,al);
            al.remove(al.size()-1);
        }
        
    }
}
