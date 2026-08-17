class Solution {
    public boolean isValid(String s) {
        int l =0;
        int r = s.length()-1;
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(map.containsKey(ch)){
                st.push(map.get(ch));
            }else{
                if(st.isEmpty() || st.pop()!=ch) return false;
            }
        }
        return st.isEmpty();
    }
}
