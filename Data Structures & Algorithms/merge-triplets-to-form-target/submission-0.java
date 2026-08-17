class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = target[0], y = target[1], z=target[2];
        int a=0,b=0,c=0;
        for(int t[]: triplets){
            if(t[0]<=x && t[1]<=y && t[2]<=z){
                a=Math.max(a,t[0]);
                b=Math.max(b,t[1]);
                c=Math.max(c,t[2]);
            }
        }
        return a==x&&b==y&&c==z;
    }
}
