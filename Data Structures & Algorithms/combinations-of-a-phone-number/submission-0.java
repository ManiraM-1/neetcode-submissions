class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>ans = new ArrayList<>();
        Map<Character,String>map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        helper(0,sb,digits,map,ans);
        return ans;
    }
    private void helper(int idx, StringBuilder sb, String digits,Map<Character,String> map, List<String>ans){
        if(digits.length()==0) return;
        if(idx==digits.length()){
            ans.add(sb.toString());
            return;
        }

        char ch = digits.charAt(idx);
        for(char c: map.get(ch).toCharArray()){
            sb.append(c);
            helper(idx+1,sb,digits,map,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
