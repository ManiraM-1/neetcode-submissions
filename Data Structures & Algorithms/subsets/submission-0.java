class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        int n = nums.length;
        helper(0,nums,n,al,ans);
        return ans;
    }    
    private void helper(int i, int[] nums, int n, List<Integer> al, List<List<Integer>>ans){
        if(i==n){
            ans.add(new ArrayList<>(al));
            return;
        }
        al.add(nums[i]);
        helper(i+1,nums,n,al,ans);
        al.remove(al.size()-1);

        helper(i+1,nums,n,al,ans);
    }
}
