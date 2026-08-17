class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        if(!wordSet.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();

                if(curr.equals(endWord)) return level;

                char[] arr = curr.toCharArray();
                for(int j=0; j<arr.length; j++){
                    char original = arr[j];
                    for(char c='a'; c<='z'; c++){
                        if(c==original) continue;
                        arr[j]=c;

                        String newStr = new String(arr);

                        if(wordSet.contains(newStr)&& !visited.contains(newStr)){
                            q.add(newStr);
                            visited.add(newStr);
                        }
                    }
                    arr[j]=original;
                }
            }
            level++;
        }
        return 0;
    }
}
