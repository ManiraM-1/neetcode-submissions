class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean visited[] = new boolean[n];

        if(hasCycle(0,-1,visited,graph)){
            return false;
        }

        for(boolean v: visited){
            if(!v){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node,int parent, boolean[] visited, List<List<Integer>>graph){
        visited[node] = true;
        for(int nei : graph.get(node)){
            if(!visited[nei]){
                if(hasCycle(nei, node, visited, graph))return true;
            }else if(nei != parent) return true;
        }
        return false;
    }
}
