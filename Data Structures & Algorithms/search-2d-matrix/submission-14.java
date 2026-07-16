class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n =matrix.length;
        int m = matrix[0].length;
        for(int i =0; i<n;i++){
            if(matrix[i][0] <= target){
                if(matrix[i][0]==target){
                    return true;
                }
                System.out.println("N-1 is " + (n-1) + " M is " + m + " i is " + i);
                System.out.println("Looking at i " + i + " n-1 is " + (n-1));
                System.out.println("Looking at " + matrix[i][(m-1)]);
                if(matrix[i][m-1] < target){
                    continue;
                }
                else{
                    for(int j = 0; j < m; j++){
                        if(matrix[i][j]==target){
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}
