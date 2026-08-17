class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0)return false;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i: hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Arrays.sort(hand);

        for(int i: hand){
            if(map.get(i)==0)continue;
            for(int j=0; j<groupSize; j++){
                int curr = i+j;
                if(!map.containsKey(curr) || map.get(curr)==0) return false;
                map.put(curr,map.get(curr)-1);
            }
        }
        return true;
    }
}
