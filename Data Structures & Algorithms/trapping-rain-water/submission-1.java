class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int l=0, r=n-1;
        int maxLeft = height[0];
        int maxRight = height[n-1];
        while(l<r){
            if(maxLeft<=maxRight){
                l++;
                ans += Math.max(0,maxLeft-height[l]);
                maxLeft=Math.max(maxLeft,height[l]);
            }else{
                r--;
                ans+=Math.max(0, maxRight-height[r]);
                maxRight=Math.max(maxRight,height[r]);
            }
        }
        return ans;
    }
}
