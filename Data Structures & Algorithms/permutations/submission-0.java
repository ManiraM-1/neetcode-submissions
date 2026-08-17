class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        boolean flag[] = new boolean[nums.length];
        helper(0,nums,ans,al,flag);
        return ans;
    }
    
    private void helper(int idx, int nums[], List<List<Integer>> ans, List<Integer> al, boolean flag[]){
        if(idx==nums.length){
            ans.add(new ArrayList<>(al));
            return;
        }
        if(idx>nums.length) return;

        for(int i=0; i<nums.length;i++){
            if(flag[i]==true) continue;
            al.add(nums[i]);
            flag[i] = true;
            helper(idx+1,nums,ans,al,flag);
            al.remove(al.size()-1);
            flag[i] = false;
        }
    }
}
