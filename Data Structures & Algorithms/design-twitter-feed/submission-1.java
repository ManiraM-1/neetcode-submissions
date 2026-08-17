class Twitter { 
    class Tweet{
        int time;
        int tweet;
        Tweet(int tweet, int time){
            this.tweet=tweet;
            this.time=time;
        }
    }
    Map<Integer,List<Tweet>> tweetMap;
    Map<Integer,Set<Integer>> followMap;

    public Twitter() {
         tweetMap = new HashMap<>();
         followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId,time++));
    }
    int time = 0;
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Tweet>pq = new PriorityQueue<>((a,b)->b.time-a.time);
        if(tweetMap.containsKey(userId)){
            pq.addAll(tweetMap.get(userId));
        }

        if(followMap.containsKey(userId)){
            for(int x: followMap.get(userId)){
                if(tweetMap.containsKey(x)){
                    pq.addAll(tweetMap.get(x));
                }
            }
        } 

        int cnt = 0;
        while(!pq.isEmpty()&&cnt<10){
            ans.add(pq.poll().tweet);
            cnt++;
        }  
        return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
