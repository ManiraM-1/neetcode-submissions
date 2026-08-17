class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(map.containsKey(target-x)){
                ans[1]= i;
                ans[0]=map.get(target-x);
                return ans;
            }else{
                map.put(x,i);
            }
        }
        return ans;
    }
}
