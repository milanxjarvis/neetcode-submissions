class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo=new int[text1.length()][text2.length()];
        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }
        return dfs(text1,text2,text1.length()-1,text2.length()-1,memo);
    }
    private int dfs(String text1,String text2,int i,int j,int[][] memo){
        if(i<0 || j<0) return 0;
         if(memo[i][j]!=-1) return memo[i][j];
         if(text1.charAt(i)==text2.charAt(j)){
            return memo[i][j]=1+dfs(text1,text2,i-1,j-1,memo);
         }
          
          return memo[i][j]=Math.max(dfs(text1,text2,i-1,j,memo),dfs(text1,text2,i,j-1,memo));
    }
}
