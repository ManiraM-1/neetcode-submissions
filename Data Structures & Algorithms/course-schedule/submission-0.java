class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int arr[]: prerequisites){
            graph.get(arr[1]).add(arr[0]);
        }
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            for(int x: graph.get(i)){
                indegree[x]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int x = q.poll();
            for(int nei : graph.get(x)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }

        boolean flag = true;
        for(int x: indegree){
            if(x!=0) return false;
        }
        return flag;

    }
}
