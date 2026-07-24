class Solution {
    int count;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
       ArrayList<ArrayList<Integer>> list=new ArrayList<>();
         count=0;
          for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
          } 
          for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
          }
          boolean[] visited=new boolean[n];
          if(dfs(0,-1,visited,list) ){
            return false;
          }
          return count==n;
    }
    private boolean dfs(int node,int parent,boolean[] visited,ArrayList<ArrayList<Integer>> adjList){
      visited[node]=true;
      count++;
      for(int adj:adjList.get(node)){
        if(!visited[adj]){
            if(dfs(adj,node,visited,adjList)){
                return true;
            }
        }else if(adj!=parent){
            return true;
        }
      }
      return false;        
    }
}