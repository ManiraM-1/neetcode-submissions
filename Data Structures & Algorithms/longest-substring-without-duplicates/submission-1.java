class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans =0;
        int l = 0;
        for(int r=0; r<s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
