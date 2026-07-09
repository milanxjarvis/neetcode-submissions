class Twitter {
    int count;
    Map<Integer,List<int []>> tweetMap;
    Map<Integer,Set<Integer>> followMap;
    
    public Twitter() {
        tweetMap=new HashMap<>();
        followMap=new HashMap<>();
        count=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
       PriorityQueue<int[]> maxHeap =
    new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
      
      if(tweetMap.containsKey(userId)){
        for(int[] tweet:tweetMap.get(userId)){
            maxHeap.offer(tweet);
        }
      }

      if(followMap.containsKey(userId)){
        for(int followerId:followMap.get(userId)){
        if(tweetMap.containsKey(followerId)){
        for(int[] tweet:tweetMap.get(followerId)){
            maxHeap.offer(tweet);
          }
         }
       }
      }
       List<Integer> ans=new ArrayList<>();
       while(!maxHeap.isEmpty() && ans.size()<10){
          ans.add(maxHeap.poll()[1]);
       }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId) return;
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
        followMap.get(followerId).remove(followeeId);
        }
    }
}
