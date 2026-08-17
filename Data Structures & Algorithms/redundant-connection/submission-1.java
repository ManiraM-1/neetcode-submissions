class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i]=i;
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];

            if(find(u)==find(v)){
                return e;
            }
            union(u,v);
        }
        return new int[0];
    }

    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    private void union(int u, int v){
        int pa = find(u);
        int pb = find(v);
        parent[pa]=pb;
    }
}
