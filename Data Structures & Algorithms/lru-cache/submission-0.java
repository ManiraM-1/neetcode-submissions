class LRUCache {
    class Node{
        int key, val;
        Node next, prev;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    Map<Integer, Node> map;
    int capacity;
    private Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertAtHead(node);
            return;
        }

        if(map.size()>=capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key,value);
        map.put(key,newNode);
        insertAtHead(newNode);

    }
}
