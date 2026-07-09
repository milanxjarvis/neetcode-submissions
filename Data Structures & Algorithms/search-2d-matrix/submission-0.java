class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         for(int[] row:matrix){
           if(target>row[row.length-1]){
               continue;
           }
           int low=0;
           int high=row.length-1;
           while(low<=high){
               int mid=(low+high)/2;
               if(row[mid]==target){
                   return true;
               }
               if(target<row[mid]){
                   high=mid-1;
               }
               else{
                   low=mid+1;
               }
           }

       }
        return false;
    }
}
