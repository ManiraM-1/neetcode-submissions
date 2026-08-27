class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n; i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }
                else if(sum<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
