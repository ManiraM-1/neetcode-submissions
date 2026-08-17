class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())return false;
        Map<Character,Integer>map1=new HashMap<>();
        for(char ch: s1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int l =0;
        Map<Character,Integer> map2 = new HashMap<>();
        for(int r=0; r<s2.length(); r++){
            char ch = s2.charAt(r);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            while((r-l+1)>s1.length()){
                char leftChar = s2.charAt(l);
                map2.put(leftChar,map2.get(leftChar)-1);
                if (map2.get(leftChar) == 0) {
    map2.remove(leftChar);
}
                l++;
            }
            if((r-l+1)==s1.length()&&map2.equals(map1)){
                return true;
            }
        }
        return false;
    }
}
