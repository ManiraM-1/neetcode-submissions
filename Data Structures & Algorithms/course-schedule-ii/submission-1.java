class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] arr: prerequisites){
            graph.get(arr[1]).add(arr[0]);
        }

        int indegree[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int x : graph.get(i)){
                indegree[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int x=0; x<numCourses; x++){
            if(indegree[x]==0){
                q.add(x);
            }
        }
        int ans[] = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[index++]=curr;

            for(int nei: graph.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return ans;
    }
}
