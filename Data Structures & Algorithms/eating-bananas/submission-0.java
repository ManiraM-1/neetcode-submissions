class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int x: piles){
            r=Math.max(r,x);
        }
        while(l<r){
            int mid = l+(r-l)/2;
            if(canEat(piles,mid,h)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    private boolean canEat(int piles[], int mid, int h){
        int time = 0;
        for(int i=0; i<piles.length; i++){
            time+=Math.ceil((double)piles[i]/mid);
        }
        return time<=h;
    }
}
