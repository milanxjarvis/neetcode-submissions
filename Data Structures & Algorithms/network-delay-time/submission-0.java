class Solution {
    static class Edge{
        int destination;
        int weight;
        Edge(int destination,int weight){
            this.destination=destination;
            this.weight=weight;
        }
    }
    static class Pair{
        int node,distance;
        Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int w=time[2];
            graph.get(u).add(new Edge(v,w));
        }
        int[] dist=new int[n+1];
         Arrays.fill(dist,Integer.MAX_VALUE);
         dist[k]=0;
         PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
         pq.offer(new Pair(k,0));

         while(!pq.isEmpty()){
            Pair current=pq.poll();
            int u=current.node;
            int d=current.distance;

            if(d>dist[u]) continue;

             for(Edge edge:graph.get(u)){
                     int v=edge.destination;
                     int w=edge.weight;
                     if(dist[u]+w<dist[v]){
                        dist[v]=dist[u]+w;
                          pq.offer(new Pair(v,dist[v]));
                     }
                   
             }
         }
         int maxTime=0;
         for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                  return -1;
            }
            maxTime=Math.max(maxTime,dist[i]);

         }
            return maxTime;
    }
}