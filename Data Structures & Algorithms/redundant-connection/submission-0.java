class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
     int[] parent=new int[n+1];
        int[] rank=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i; 
        }
        for(int[] edge:edges){
          if(!union(edge[0],edge[1],parent,rank)){
                return new int[]{edge[0],edge[1]};
            }  
        }
            
        return new int[0];
    }
    private int find(int x,int[] parent){
        if(parent[x]!=x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
   private boolean union(int x,int y,int[] parent,int[] rank){
        int rootX=find(x,parent);
        int rootY=find(y,parent);
        if(rootY==rootX){
            return false;
        }
        if(rank[rootY]>rank[rootX]){
            parent[rootX]=rootY;
        } else if (rank[rootX]>rank[rootY]) {
            parent[rootY]=rootX;
        }else{
            parent[rootY]=rootX;
            rank[rootX]++;
        }
        return true;
    }
    
}
