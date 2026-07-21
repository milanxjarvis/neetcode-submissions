class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
          for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
          } 
          for(int[] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
          }
          int[] indegree=new int[numCourses];
          
          for(int i=0;i<numCourses;i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
            }
            for(int i=0;i<numCourses;i++){
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
            int count=0;
            while(!q.isEmpty()){
                int node=q.poll();
                count++;
                for(int j:adj.get(node)){
                  indegree[j]--;
                  if(indegree[j]==0){
                    q.offer(j);
                  }
                }
            }
            
            return count==numCourses;
    }
}
