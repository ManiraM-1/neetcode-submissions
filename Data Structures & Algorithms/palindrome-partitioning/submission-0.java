class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> al = new ArrayList<>();
        helper(0,s,ans,al);
        return ans;
    }
    private void helper(int idx,String s, List<List<String>> ans, List<String>al){
        if(idx == s.length()){
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if(isPal(idx,i,s)){
                al.add(s.substring(idx,i+1));
                helper(i+1,s,ans,al);
                al.remove(al.size()-1);
            }
        }
    }
    private boolean isPal(int start, int end, String s){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
