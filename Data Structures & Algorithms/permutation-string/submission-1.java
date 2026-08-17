class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int ls1 = s1.length();
        int ls2 = s2.length();
        if(ls2 < ls1) return false;
        Map<Character,Integer> m1 = new HashMap<>();
        for(char ch: s1.toCharArray()){
            m1.put(ch,m1.getOrDefault(ch,0)+1);
        }
        int l = 0;
        Map<Character,Integer> m2 = new HashMap<>();
        for(int r=0; r<ls2;r++){
            m2.put(s2.charAt(r),m2.getOrDefault(s2.charAt(r),0)+1);
            if(r-l+1 > ls1){
                m2.put(s2.charAt(l),m2.get(s2.charAt(l))-1);
                if(m2.get(s2.charAt(l))==0) m2.remove(s2.charAt(l));
                l++;
            }

            if(r-l+1==ls1 && m2.equals(m1)){
                return true;
            }
        }
        return false;
    }
}
