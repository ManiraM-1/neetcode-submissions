class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l =0;
        int r = heights.length-1;
        while(l<r){
            int width = r-l;
            int ht = Math.min(heights[l],heights[r]);
            maxArea = Math.max(maxArea,width*ht);
            
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
