class Solution {
    int component;
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
         component=0;
          for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
          } 
          for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
          }
          boolean[] visited=new boolean[n];
          for(int i=0;i<n;i++){
            if(!visited[i]){
                component++;
               dfs(i,visited,list);
            }
          }
          return component;
    }
    private void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adjList){
      visited[node]=true;
      for(int adj:adjList.get(node)) {
        if(!visited[adj]){
            dfs(adj,visited,adjList);
        }
      }    
    }
}
