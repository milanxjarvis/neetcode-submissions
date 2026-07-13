class Solution {
  private  int heights[][];
  private  int rows,cols;
    private final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        rows=heights.length;
        cols=heights[0].length;

        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];
        for(int r=0;r<rows;r++){
            dfs(r,0,pacific);
            dfs(r,cols-1,atlantic);
        }

        for(int c=0;c<cols;c++){
            dfs(0,c,pacific);
            dfs(rows-1,c,atlantic);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }
    private void dfs(int r,int c,boolean[][] visited){
      if(visited[r][c]) return;
       visited[r][c]=true;

       for(int[] dir:directions){
        int nr=r+dir[0];
        int nc=c+dir[1];
        if(nr>=0 && nc>=0&&nr<rows&&nc<cols&& heights[nr][nc]>=heights[r][c] && !visited[nr][nc]){
            dfs(nr,nc,visited);
        }
       }
    }
}
