class Solution {
    public int[][] transpose(int[][] matrix) {
        int row =matrix[0].length;
        int col =matrix.length;
        int [][] result = new int [row][col];
        for(int i=0;i<col;i++){
            for (int j =0;j<row;j++){
                result[j][i]=matrix[i][j];
            }
        }
        return result;
    }
}