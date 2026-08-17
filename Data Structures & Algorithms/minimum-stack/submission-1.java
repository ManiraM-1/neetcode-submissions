class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<Integer>();
        minSt = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty()){
            minSt.push(val);
        }else{
            minSt.push(Math.min(val,minSt.peek()));
        }
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
