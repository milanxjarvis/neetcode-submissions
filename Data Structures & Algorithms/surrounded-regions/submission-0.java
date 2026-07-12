class Solution {
    private int rows,columns;
    public void solve(char[][] board) {
        rows=board.length;
        columns=board[0].length;
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O'){
                capture(board,i,0);
            }
            if(board[i][columns-1]=='O'){
                capture(board,i,columns-1);
            }
        }
         for(int j=0;j<columns;j++){
            if(board[0][j]=='O'){
                capture(board,0,j);
            }
            if(board[rows-1][j]=='O'){
                capture(board,rows-1,j);
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='T'){
                 board[i][j]='O';
                }
            }
            }
        
       
    }

    private void capture(char[][] board,int i,int j){
        if(i<0||j<0||i>=rows||j>=columns||board[i][j]!='O'){
            return;
        }
        board[i][j]='T';
        capture(board,i+1,j);
        capture(board,i-1,j);
        capture(board,i,j+1);
        capture(board,i,j-1);
    }
}
