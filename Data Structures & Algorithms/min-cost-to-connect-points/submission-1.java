class Solution {
    public int minCostConnectPoints(int[][] points) {
     int n=points.length;
     if(n<=1) return 0;

     boolean[] inMst=new boolean[n];
     int[] minDist=new int[n];
     Arrays.fill(minDist,Integer.MAX_VALUE);
     minDist[0]=0;
     int minCost=0;
     for(int i=0;i<n;i++){
        int u=-1;
        for(int v=0;v<n;v++){
            if(!inMst[v]){
                if(u==-1||minDist[v]<minDist[u]){
                    u=v;
                }
            }
        }
        inMst[u]=true;
        minCost+=minDist[u];

        for(int v=0;v<n;v++){
            if(!inMst[v]){
               int dist=cost(u,v,points);
               if(dist<minDist[v]){
                minDist[v]=dist;
               }
            }
        }
     }   
     return minCost;
    }
    
    private int cost(int u,int v,int[][] points){
        int dist=Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1]-           points[v][1]);
        return dist;
    }
}
