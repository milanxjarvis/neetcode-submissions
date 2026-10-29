class Solution {
    int[][] directions={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        dp=new int[rows][columns];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int  LIP=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
              LIP=Math.max(LIP,dfs(matrix,i,j,Integer.MIN_VALUE));
            }
        }
        return LIP;
    }
    private int dfs(int[][] matrix,int i,int j,int prev){
        int rows=matrix.length;
        int columns=matrix[0].length;
       if (i < 0 || i >= rows || j < 0 || j >= columns ||
             matrix[i][j] <= prev) {
          return 0;
         }
         if(dp[i][j]!=-1) return dp[i][j];
        int res=1;
        for(int[] d:directions){
            res=Math.max(res,1+dfs(matrix,i+d[0],j+d[1],matrix[i][j]));
        }
        return dp[i][j]=res;
    }
}
