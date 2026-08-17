class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;
        int i=0, j=heights.length-1;
        while(i<j){
            int minht = Math.min(heights[i],heights[j]);
            int width = j-i;
            int area = minht*width;
            ans = Math.max(ans,area);

            if(heights[i]<heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
}
