class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int k = temperatures.length;
       Stack<Integer> st = new Stack<>();
     int ans[] =  new int[temperatures.length];
     //List<Integer> ans = new ArrayList<>();
       for(int i=temperatures.length-1; i>=0; i--){
        while(!st.isEmpty()&&temperatures[st.peek()]<=temperatures[i]){
            st.pop();
        }
        if(!st.isEmpty()){
            ans[i]=st.peek()-i;
        }
        st.push(i);
       }
       return ans;
    }
}
