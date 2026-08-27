class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int ans=0;
        int l = 0;
        int r = n-1;
        while(l<r){
            int area = Math.min(heights[l],heights[r]) *(r-l);
            ans = Math.max(ans,area);
            if(heights[l]<=heights[r]) l++;
            else r--;
        }
        return ans;
    }
}
