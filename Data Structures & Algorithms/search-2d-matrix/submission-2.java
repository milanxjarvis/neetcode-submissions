class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
    
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int val = matrix[mid / cols][mid % cols];  // map to 2D

            if (val == target) {
                return true;
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
     

