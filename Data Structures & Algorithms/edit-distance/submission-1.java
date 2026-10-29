class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
     return  distance(m-1,n-1,word1,word2,dp);

    }
    private int distance(int i,int j,String word1,String word2,int[][] dp){
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=distance(i-1,j-1,word1,word2,dp);
        }
        int res=Math.min(distance(i-1,j,word1,word2,dp),distance(i,j-1,word1,word2,dp));
        res=Math.min(res,distance(i-1,j-1,word1,word2,dp));
       return dp[i][j]= 1+res;
    }
}
