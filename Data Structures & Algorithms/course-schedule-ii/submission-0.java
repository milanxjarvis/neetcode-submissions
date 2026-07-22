class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
      int[] result=new int[numCourses];
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
                result[count]=node;
                count++;
                for(int j:adj.get(node)){
                  indegree[j]--;
                  if(indegree[j]==0){
                    q.offer(j);
                  }
                }
            }
            
            return count==numCourses?result:new int[0];  
    }
}
