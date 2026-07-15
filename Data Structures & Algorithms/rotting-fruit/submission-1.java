class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int time=0;
        Queue<int[]> q=new LinkedList<>();
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==2){
                  q.offer(new int[]{r,c});
                }
                if(grid[r][c]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            boolean rottenThisMinute=false;
            int size=q.size();
            for(int i=0;i<size;i++){
            int[] current=q.poll();
            int r=current[0];
            int c=current[1];
          
          for(int[] direction:directions) {
            int nr=r+direction[0];
            int nc=c+direction[1];
            if(nr>=0 &&nr<grid.length &&nc>=0&&nc<grid[0].length &&grid[nr][nc]==1){
                grid[nr][nc]=2;
                fresh--;
                q.offer(new int[]{nr, nc});
                rottenThisMinute = true;
            }
          }
        } 
        if(rottenThisMinute){
                time++;
            } 
        }
        return (fresh>0)? -1:time;
    }
}
