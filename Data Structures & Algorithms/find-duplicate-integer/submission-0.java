class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x,map.getOrDefault(x,0)+1);
            if(map.get(x)>1){
                return x;
            }
        }
        return -1;
    }
}
