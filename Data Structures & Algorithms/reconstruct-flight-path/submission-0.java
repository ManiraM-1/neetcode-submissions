class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets){
            if(!graph.containsKey(ticket.get(0))){
                graph.put(ticket.get(0), new PriorityQueue<>());
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK");
        return result;

    }
    public void dfs(String s){
        PriorityQueue<String> pq = graph.get(s);
        while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        result.addFirst(s);

    }
}
