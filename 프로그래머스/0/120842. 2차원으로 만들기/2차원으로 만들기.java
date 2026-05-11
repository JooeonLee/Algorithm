class Solution {
    public int[][] solution(int[] num_list, int n) {
        int row = num_list.length / n;
        int col = n;
        int[][] answer = new int[row][col];
        
        int idx = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++)
                answer[i][j] = num_list[idx++];
        }
        return answer;
    }
}