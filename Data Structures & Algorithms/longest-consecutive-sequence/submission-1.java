class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int x: nums){
            set.add(x);
        }
        for(int x: set){
            if(!set.contains(x-1)){
                int len = 1;
                int curr = x;

                while(set.contains(curr+1)){
                    len++;
                    curr++;
                }
                ans = Math.max(ans,len);
            }
        }
        return ans;
    }
}
