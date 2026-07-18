class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

          for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
          } 
          for(int[] pre:prerequisites){
            list.get(pre[1]).add(pre[0]);
          }
          boolean[] visited=new boolean[numCourses];
          boolean[] pathVisited=new boolean[numCourses];
          for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs( i, visited, pathVisited, list)){
                   return false;
                }
            }
            
          } 
          return true; 
    }
    private boolean dfs(int node,boolean[] visited,boolean[] pathVisited,ArrayList<ArrayList<Integer>> list){
        visited[node]=true;
        pathVisited[node]=true;
        for(int neighbor:list.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor,visited,pathVisited,list)){
                    return true;
                }
            }else if(pathVisited[neighbor]){
                    return true;
                }
        }
        pathVisited[node]=false;

        return false;
    }
}
