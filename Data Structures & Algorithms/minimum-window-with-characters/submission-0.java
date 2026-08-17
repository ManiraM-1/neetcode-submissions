class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0) return "";
        Map<Character,Integer>map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int required = t.length();
        int l=0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        for(int r=start; r<s.length(); r++){
            char rightChar = s.charAt(r);
            if(map.containsKey(rightChar)){
                if(map.get(rightChar)>0){
                    required--;
                }
                map.put(rightChar,map.get(rightChar)-1);
            }
            while(required==0){
                if(r-l+1<min){
                    min=r-l+1;
                    start=l;
                }

                char leftChar = s.charAt(l);
                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar)+1);
                    if(map.get(leftChar)>0){
                        required++;
                    }
                }
                l++;
            }

        }
        return min==Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}