class TimeMap {
    class Node{
        int time;
        String value;
        Node(int time, String value){
            this.time = time;
            this.value = value;
        }
    }
    Map<String,List<Node>>map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Node(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Node> list = map.get(key);
        int l =0;
        int r = list.size()-1;
        String ans = "";
        while(l<=r){
            int mid =l+(r-l)/2;
            if(list.get(mid).time<=timestamp){
                ans=list.get(mid).value;
                l=mid+1;
            }else{
                r=mid-1;
            }

        }
        return ans;
    }
}
