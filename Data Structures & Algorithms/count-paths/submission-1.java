class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,0);
       
       for(int i=0;i<m;i++){
        int[] current=new int[n];
        for(int j=0;j<n;j++){
            if(i==0 && j==0){
                current[j]=1;
                continue;
            }
            int up=0;
            int left=0;
            if(i>0){
                 up=dp[j];
            }
            if(j>0){
                 left=current[j-1];
            }
            current[j]=up+left;
            
        }
        dp=current;
       }
       return dp[n-1];
    }
   
}
