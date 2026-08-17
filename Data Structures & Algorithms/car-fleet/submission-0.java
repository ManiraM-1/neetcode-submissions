class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double matrix[][]=new double[n][2];
        for(int i=0; i<n; i++){
            matrix[i][0]=position[i];
            matrix[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(matrix,(a,b)-> Double.compare(b[0],a[0]));
        double maxTime = 0;
        int ans = 0;
        for(int i=0; i<n;i++){
            if(matrix[i][1]>maxTime){
                ans++;
                maxTime = matrix[i][1];
            }
        }
        return ans;

    }
}
