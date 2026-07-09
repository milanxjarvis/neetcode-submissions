class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int colms=matrix[0].length;
        
           int low=0;
           int high=rows*colms-1;
           while(low<=high){
               int mid=(low+high)/2;
               int value=matrix[mid/colms][mid%colms];
               if(value==target){
                   return true;
               }
               else if(target<value){
                   high=mid-1;
               }
               else{
                   low=mid+1;
               }
           }
             return false;
       }
        
    }

